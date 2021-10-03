package Used_pages;
import Database_Config.donationdate;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class date_picker_1 {
    
public static String username="";
public date_picker_1(String username){
    this.username=username;
}
    public static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Blood Management System");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private static Scene createScene() {
        String css=date_picker_1.class.getResource("./Datepicker.css").toExternalForm();
         VBox vbox=new VBox();
            Text  text  =  new  Text();
        
        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome To Blood Management System!");

        Label greeting_label=new Label("Hello there ");
        DatePicker datePicker = new DatePicker();
        datePicker.setDayCellFactory(picker -> new DateCell(){
            public void updateItem(LocalDate date,boolean empty){
                super.updateItem(date, empty);
                LocalDate today=LocalDate.now();
                setDisable(empty || date.compareTo(today)<=0);
            }
        });
        Button button = new Button("Select the activity date");
       
           
        button.setOnAction(action -> {
                 
                 LocalDate value = datePicker.getValue();
                 System.out.println("This is the selected date type \n "+value.toString());
                 new donationdate().RequestDonnation(username,"Kacyiru",value.toString());
                 String nowdate=new Date().toString();
                 System.out.println("current year \n "+nowdate);
                Scanner sc=new Scanner(nowdate);
                int nowyear=0;
                String now=null;
                while(sc.hasNext()){
                  now=sc.next();
                }
                    nowyear=Integer.parseInt(now);
              
           
        });
         
        greeting_label=new Label("Hello "+username+" Please Select the date for blood donation");
        vbox.getChildren().add(text);
        vbox.getChildren().add(greeting_label);
        HBox hbox = new HBox(datePicker);
        hbox.getChildren().add(button);
        vbox.getChildren().add(hbox);
        hbox.setId("hbox");
        vbox.setId("vbox");
        

        Scene  scene  =  new  Scene(vbox, Color.ALICEBLUE);
        scene.getStylesheets().add(css);
     
    

        return (scene);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}

