/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * @author janvier
 */
public class donationdate {
    //Connections connections = new Connections();
    Connection my_con =   Connections.Create_Connections();
    PreparedStatement ps;

    public void RequestDonnation(String username, String place, String date) {
        String findid_querry = "select Id from users where Username=?";

        try {
            ps = my_con.prepareStatement(findid_querry);
            ps.setString(1, username);
            ResultSet result = ps.executeQuery();
            int foundId = 0;
            if (result.next()) {
                foundId = result.getInt("Id");
            } else {
                System.out.println("User not found! ");
                return;
            }
            ps = my_con.prepareStatement("insert into donnation_request(donnorId,place,date) values(?,?,?)");
            ps.setInt(1, foundId);
            ps.setString(2, place);
            ps.setString(3, date);
            ps.executeUpdate();
            System.out.println("Donnation request has occured!!");
            JOptionPane.showMessageDialog(null,"Donnation request has occured!!","Info",JOptionPane.INFORMATION_MESSAGE);
             

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
