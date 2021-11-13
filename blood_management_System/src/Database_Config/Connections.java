/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Config;

import static java.lang.Class.forName;

import java.sql.*;

/**
 * @author valen
 */
public class Connections {
    Connection conn = null;
    String DB_Url = null;
    String Username = null;
    String password = null;

    public Connection Create_Connections() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DB_Url = "jdbc:mysql://localhost/bms1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Username = "root";
            password = "";
            conn = DriverManager.getConnection(DB_Url, Username, password);
            System.out.println("Well connected to the network: " + DB_Url + " !");
        } catch (Exception ex) {
            System.out.println("Not Connected");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connections conn = new Connections();
        conn.Create_Connections();
    }
}
