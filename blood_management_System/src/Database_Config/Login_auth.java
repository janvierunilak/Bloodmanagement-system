/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Config;

import UsedClasses.PasswordUtils;
import Used_pages.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author valen
 */
public class Login_auth {
    Connections connections = new Connections();
    PreparedStatement ps;

    public void userlogin(String username, String password) {
//        boolean isNormaluser=false;
//          boolean isHospital=false;
//            boolean isBloodBank=false;
//              boolean isDelivler=false;

        boolean truelyuser = false;
        String securedpass = "";
        String salt = "";
        String usertype = "";
        String querry = "select *from users where username=?";
        try {
            ps = connections.Create_Connections().prepareStatement(querry);
            ps.setString(1, username);
            ResultSet usercredentials = ps.executeQuery();
            if (usercredentials.next()) {
                securedpass = usercredentials.getString("Password");
                salt = usercredentials.getString("salt");
                usertype = usercredentials.getString("user_type");
            }
            truelyuser = PasswordUtils.verifyUserPassword(password, securedpass, salt);
            System.out.println("is user found? " + truelyuser);
            // new donorprofile(username).setVisible(true);
            //Hospital Deliverer Bloodbank Normal_user
            if (truelyuser == true) {
                System.out.println("User type so far !" + usertype);
                if (usertype.equalsIgnoreCase("Normal_user")) {
                    new donorprofile(username).setVisible(true);
                } else if (usertype.equalsIgnoreCase("Hospital")) {
                    new hospitalprofile().setVisible(true);
                } else if (usertype.equalsIgnoreCase("Bloodbank")) {
                    new bloodbankprofile().setVisible(true);
                } else if (usertype.equalsIgnoreCase("Deliverer")) {
                    new deliveryprofile().setVisible(true);
                } else {
                    System.out.println("No other user type supported yet!");
                }


            } else System.out.println("User credentials no match!");
        } catch (Exception e) {

        }

    }


}
