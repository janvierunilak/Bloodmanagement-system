/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Config;
import java.sql.*;

/**
 *
 * @author janvier
 */

public class donationdate {
     Connections connections=new Connections();
    PreparedStatement ps;
    ResultSet rs;
    public void RequestBlood_donation(String donorname,String donationcite,String donationdate,String bloodgroup){
        try{
            String query="insert into donor(donor_name,blood_group,donation_date,address) values(?,?,?,?)";
            ps=connections.Create_Connections().prepareStatement(query);
            ps.setString(1, donorname);
            ps.setString(2,bloodgroup);
            ps.setString(3,donationdate);
            ps.setString(4,donationcite);
            ps.executeUpdate();
            System.out.println("Blood request to "+donorname+" Is successfully sent!");
            
    }        
    
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
