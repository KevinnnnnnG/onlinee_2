/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SENA
 */
public class ConexBD {
     Connection cnx;
    String url = "jdbc:mysql://localhost/inventarios2";
    String usr = "root";
    String pass = "";

    public Connection ConexionBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url,usr,pass);
            if (cnx != null) {
                System.out.println("Conexion establecida");
                return cnx;
            }
                    }
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(ConexBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        ConexBD micon = new ConexBD();
        micon.ConexionBD();
    }
}
