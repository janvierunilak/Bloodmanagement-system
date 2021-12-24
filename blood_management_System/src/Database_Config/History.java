/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Config;

import Used_pages.Donationreq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Kwizera
 */
public class History {
   // Connections connections = new Connections();
    Connection my_con =   Connections.Create_Connections();
    PreparedStatement ps;
Donationreq donationreq;
    public ArrayList<Donationreq> GetBloodRequestHistory(String username) {
        ArrayList<Donationreq> blood_requet_list = new ArrayList<>();

        String myquerry = "select *from donnation_request where donnorId=?";
        try {
            ps = my_con.prepareStatement("Select Id from users where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            int userid = 0;
            if (rs.next())
                userid = rs.getInt("Id");

            ps = my_con.prepareStatement(myquerry);
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                donationreq=new Donationreq(rs.getInt("Id"),rs.getString("date"),rs.getString("Status"),rs.getString("place"));
                String userdetails = "Date: " + rs.getString("date") + ", " + "place: " + rs.getString("place") + ",  " + "Status: " + rs.getString("Status");
                blood_requet_list.add( donationreq);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return blood_requet_list;
    }
}
