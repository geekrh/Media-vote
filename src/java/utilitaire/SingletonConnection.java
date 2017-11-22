/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitaire;

/**
 *
 * @author Mohammmed Mehdi Sarray#
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonConnection {
    private static Connection con;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vote", "root", "");
            System.out.println("connexion etablie");
        } catch (Exception ex) {
             ex.getStackTrace()  ;
        }
        
    }

    public static Connection getCon() {
        return con;
    }
        
}
 

