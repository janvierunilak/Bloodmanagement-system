/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsedClasses;

/**
 *
 * @author valen
 */
public class VerifyProvidedPassword_1{
    public static void main(String[] args)
    {
        // User provided password to validate
        String providedPassword = "myPassword123";
                
        // Encrypted and Base64 encoded password read from database
        String securePassword = "HhaNvzTsVYwS/x/zbYXlLOE3ETMXQgllqrDaJY9PD/U=";
        
        // Salt value stored in database 
       // String salt = "EqdmPh53c9x33EygXpTpcoJvc4VXLK";
        String salt="3bFSiEthhBvdMtYEoFQGOCkvxr3K04";
        
        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + providedPassword + " is correct.");
        } else {
            System.out.println("Provided password is incorrect");
        }

    }
}
