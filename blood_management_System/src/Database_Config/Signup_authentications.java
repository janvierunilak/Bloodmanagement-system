/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Config;

import UsedClasses.PasswordUtils;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author valen
 */
public class Signup_authentications {
    //Connections connections = new Connections();
    Connection conn =   Connections.Create_Connections();
    PreparedStatement preparedstatement = null;
    ResultSet Result = null;

    public void RegisterUser(String fn, String ln, String email, String username, String phone, String pass, String type) {

        try {

            String salt = PasswordUtils.getSalt(30);
            String securedpass = PasswordUtils.generateSecurePassword(pass, salt);
            if (!username.isEmpty()) {

                preparedstatement = conn.prepareStatement("select *from Users where Username=?");
                preparedstatement.setString(1, username);
                Result = preparedstatement.executeQuery();

                if (Result.next()) {
                    System.out.println("The user exists!");
                } else {
                    preparedstatement = conn.prepareStatement("insert into Users(Firstname,Lastname,Email,Username,Password,salt,user_type,phone) values(?,?,?,?,?,?,?,?)");
                    preparedstatement.setString(1, fn);
                    preparedstatement.setString(2, ln);
                    preparedstatement.setString(3, email);
                    preparedstatement.setString(4, username);
                    preparedstatement.setString(5, securedpass);
                    preparedstatement.setString(6, salt);
                    preparedstatement.setString(7, type);
                    preparedstatement.setString(8, phone);
                    preparedstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, ".Account has been created successfully.");
                    System.out.println("Well Registered with  username of :" + username + "!");
                    final String[] tablenames = {"hospital", "bloodbank", "bloodstock", "delivery"};
                    final String[] types = {"Hospital", "Bloodbank", "Bloodstock", "Deliverer"};

                    preparedstatement.setString(1, type);
                    for (int i = 0; i < types.length; i++) {
                        if (type == types[i]) {


                            if (type.equalsIgnoreCase(tablenames[0])) {

                                String hospitaladdress = JOptionPane.showInputDialog("Enter the address of hospital: ");
                                preparedstatement = conn.prepareStatement("insert into hospital(hospital_name,address) values(?,?)");

                                preparedstatement.setString(2, hospitaladdress);

                                preparedstatement.setString(1, username);
                                preparedstatement.executeUpdate();

                            } else if (type.equalsIgnoreCase(tablenames[1])) {
                                System.out.println(tablenames[1]);
                                String address = JOptionPane.showInputDialog("Enter the address of bloodbank: ");
                                preparedstatement = conn.prepareStatement("insert into bloodbank(bloodbank_name,bloodbank_address) values(?,?)");
                                preparedstatement.setString(1, username);
                                preparedstatement.setString(2, address);


                                preparedstatement.executeUpdate();
                                System.out.println("querry has been executed!");
                                preparedstatement = conn.prepareStatement("update bloodbank set bloodbank_phone=? where bloodbank_name=?");
                                preparedstatement.setString(2, username);
                                preparedstatement.setString(1, phone);
                                preparedstatement.executeUpdate();

                            } else
                                JOptionPane.showMessageDialog(null, " Other information will be provided after logging in!");


                        }
                    }


                }
            } else {
                JOptionPane.showMessageDialog(null, " Username must be filled!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The user exists!");
            e.printStackTrace();
        }
    }

}
