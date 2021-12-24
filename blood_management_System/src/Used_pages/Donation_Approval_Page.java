package Used_pages;

import Database_Config.Connections;
import static Used_pages.date_picker_1.initAndShowGUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Donation_Approval_Page{

    private static  TableView<Donor> table=new TableView<>();
    private  static ObservableList<Donor> data=
            FXCollections.observableArrayList(
                   
            );
;
    static HBox hb;
            
           
    
//
//    public static void main(String[] args) {
//        new Donation_Approval_Page().launch(args);
//    }
     // Connections connections = new Connections();
   static PreparedStatement ps;
   static Connection conn =   Connections.Create_Connections();
public static ArrayList<Donor> availableDonors(){
    ArrayList<Donor> donors=new ArrayList<Donor>();
     String querry = "select *from donnation_request";
     String userquerry=" select * from users where Id=?";
     int requestId=0;
     try {
            ps = conn.prepareStatement(querry);
              ResultSet result = ps.executeQuery();
             
              String fName = null,lName = null,username = null,email = null,date = null,status=null;
              int id;
            while (result.next()) {
                id=result.getInt("donnorId");
                 ps= conn.prepareStatement(userquerry);
                 ps.setInt(1, id);
                 ResultSet userResult=ps.executeQuery();
                 if(userResult.next()){
                     fName=userResult.getString("Firstname");
                     lName=userResult.getString("Lastname");
                     username=userResult.getString("Username");
                     email=userResult.getString("Email");    
                 }
                 date=result.getString("date");
                 status=result.getString("status");
                 requestId=result.getInt("Id");
                 donors.add(new Donor(requestId,fName,lName,username,email,date,status)); 
            }
           
     }
     catch(Exception ex){
         
     }
     
    return donors;
}     
    public  static Scene AddDonor() {
 ArrayList<Donor> availabledonors=availableDonors();
 for(Donor donor:availabledonors){
     data.add(donor);
 }
    hb = new HBox();
        Group gr = new Group();
        Scene scene = new Scene(gr);
        //scene.getStylesheets().add("quizes/LoginForm.css");
        gr.setAutoSizeChildren(true);

        final Label label = new Label("List of donation requests");
        label.setFont(new Font("Arial", 30));

        label.setId("table");
        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Donor, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Donor, String>("lastName"));
        TableColumn UserNameCol = new TableColumn("User Name");
        UserNameCol.setMinWidth(100);
        UserNameCol.setCellValueFactory(
                new PropertyValueFactory<Donor, String>("username"));
        TableColumn pendingCol = new TableColumn("Status");
        pendingCol.setMinWidth(100);
        pendingCol.setCellValueFactory(
                new PropertyValueFactory<Donor, String>("status"));
        TableColumn yearCol = new TableColumn("User Name");
        yearCol.setMinWidth(50);
        yearCol.setCellValueFactory(
                new PropertyValueFactory<Donor, String>("username"));
        TableColumn emailCol;
        emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Donor, String>("email"));
        TableColumn Datecol = new TableColumn("Date");
        Datecol.setMinWidth(100);
        Datecol.setCellValueFactory(
                new PropertyValueFactory<Donor, String>("date"));
        table.getColumns().addAll(firstNameCol, lastNameCol, yearCol, emailCol, Datecol, pendingCol);
        table.setItems(data);

        final Button viewme = new Button("Modify");
        Stage testStage = new Stage();
        testStage.setTitle("Donor approval");
        viewme.setOnAction((e) -> {
            Donor donor = table.getSelectionModel().getSelectedItem();
            if (donor != null) {
                System.out.println("The selected donor is: " + donor.getUsername());
                checkDonor(donor, testStage);
            } else
                JOptionPane.showMessageDialog(null, "you have selected none!");
        });
        hb.getChildren().addAll(viewme);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        //st.setScene(scene);
        //st.show();
        return scene;
    }

    public static void checkDonor(Donor donor, Stage stage) {
        HBox firstnamehbx = new HBox();
        String fname = donor.getFirstName();
        firstnamehbx.setAlignment(Pos.CENTER);
        Label fnameLabel = new Label(fname);
        firstnamehbx.getChildren().addAll(new Label("FirstName: "), fnameLabel);

        HBox lastnamehbx = new HBox();
        lastnamehbx.getChildren().addAll(new Label("Lastname: "), new Label(donor.getLastName()));
        lastnamehbx.setAlignment(Pos.CENTER);
        HBox emailhbx = new HBox();
        emailhbx.getChildren().addAll(new Label("Email: "), new Label(donor.getEmail()));
        emailhbx.setAlignment(Pos.CENTER);
        HBox usernamehbx = new HBox();

        usernamehbx.getChildren().addAll(new Label("Username: "), new Label(donor.getUsername()));
        usernamehbx.setAlignment(Pos.CENTER);
        HBox requestDatehbx = new HBox();
        requestDatehbx.getChildren().addAll(new Label("requestDate: "), new Label(donor.getDate()));
        requestDatehbx.setAlignment(Pos.CENTER);
        HBox makeChoicehbx = new HBox();
        makeChoicehbx.getChildren().add(new Label("Update Request: "));
        ToggleGroup radioButtonGroup = new ToggleGroup();
        RadioButton approve = new RadioButton("Approve");
        approve.setUserData("Approve");
        approve.setId("approval");
        approve.setToggleGroup(radioButtonGroup);
        RadioButton deny = new RadioButton("Deny");
        deny.setUserData("deny");
        deny.setToggleGroup(radioButtonGroup);
        deny.setId("deny");

        VBox choiceVBX = new VBox();
        choiceVBX.getChildren().addAll(approve, deny);
        makeChoicehbx.getChildren().add(choiceVBX);
        makeChoicehbx.setAlignment(Pos.CENTER);
        VBox allViews = new VBox();
        Button saveBtn = new Button("Save changes");
        saveBtn.setAlignment(Pos.CENTER);
 String query="update donnation_request set status=? where Id=?";
  

  
   
        radioButtonGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
             public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
                RadioButton chk = (RadioButton) t1.getToggleGroup().getSelectedToggle();// Cast object to radio button
                System.out.println("Selected Radio Button - " + chk.getText());
               
                if (chk.getText() == approve.getText()) {
                   // System.out.println("Approved!");
                    donor.setStatus("Approved");
                   
                } else {
                   // System.out.println("Denied!");
                    donor.setStatus("Denied");
                  
                }
                    
            }
        });
        saveBtn.setOnAction(e -> {
             try{
   Alert a=new Alert(AlertType.INFORMATION);
                ps= conn.prepareStatement(query);
                  ps.setString(1,donor.getStatus());
                  ps.setInt(2, donor.getDonorId());
                  ps.executeUpdate();
                  a.setContentText("User is "+donor.getStatus()+" !");
                  a.show();
                  // JOptionPane.showMessageDialog(null,"User is "+donor.getStatus()+" !","Info",JOptionPane.INFORMATION_MESSAGE);
             System.out.println("User is "+donor.getStatus()+" !");
//             stage.close();
                }
                catch(Exception ex){
                   ex.printStackTrace();
                }
            table.refresh();
        });
        allViews.getChildren().addAll(firstnamehbx, lastnamehbx, emailhbx, usernamehbx, requestDatehbx, makeChoicehbx, saveBtn);
        allViews.setSpacing(10);
        Scene scene = new Scene(allViews, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        AddDonor(primaryStage);
//    }

    public static class Donor {

        private SimpleStringProperty firstName;
        private SimpleStringProperty lastName;
        private SimpleStringProperty email;
        private SimpleStringProperty date;
        private SimpleStringProperty status;
        private final SimpleStringProperty username;
        private SimpleIntegerProperty userId;


        private Donor(int donorId,String fName, String lName, String username, String email, String date, String status) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.date = new SimpleStringProperty(date);
            this.status = new SimpleStringProperty(status);
            this.username = new SimpleStringProperty(username);
            this.userId=new SimpleIntegerProperty(donorId);
        }
     public int getDonorId() {
            return userId.get();
        }

        public void setDonorId(int id) {
            userId.set(id);
        }
        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String em) {
            email.set(em);
        }

        public String getDate() {
            return date.get();
        }

        public void setDate(String date) {
            this.date.set(date);
        }

        public String getStatus() {
            return status.get();
        }

        public void setStatus(String status) {
            this.status.set(status);
        }

        public String getUsername() {
            return username.get();
        }

        public void setUsername(String username) {
            this.username.set(username);
        }

public static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Blood Management System");
        final JFXPanel fxPanel = new JFXPanel();
      
        frame.add(fxPanel);
        frame.setSize(720, 550);
        frame.setVisible(true);
        
        
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }
 private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene =AddDonor();
        fxPanel.setScene(scene);
    }
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Coming...");
//                initAndShowGUI();
//            }
//        });
//    }
    }

}
 
