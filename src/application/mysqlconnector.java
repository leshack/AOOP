/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class mysqlconnector {
    Connection conn = null;
    
    public static Connection connectDb(){
     try {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/farmers?useTimezone=true&serverTimezone=UTC","root","");
       JOptionPane.showMessageDialog(null,"ConnectionEstablished");
       return conn;   
    }catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
       return null;  
}
     } 
     
}

