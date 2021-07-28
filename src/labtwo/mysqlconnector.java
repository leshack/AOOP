/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labtwo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
class mysqlconnector {
    
      Connection conn = null;
    
    public static Connection connectDb(){
     try {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/moviesdb?useTimezone=true&serverTimezone=UTC","root","");
       JOptionPane.showMessageDialog(null,"ConnectionEstablished");
       return conn;   
    }catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
       return null;  
}
     } 
}
