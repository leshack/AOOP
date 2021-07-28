/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.util.Collections.list;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ConnectionClass {
    Connection conn =null;
   
    public static Connection getConnection(){
        String dbName ="inforation";
        String userName="root";
        String password="";
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inforation?useTimezone=true&serverTimezone=UTC","root","");
           JOptionPane.showMessageDialog(null,"ConnectionEstablished");
           return conn;
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
          return null;
        }
    }
      public static ObservableList<users> getDatausers(){
        
        Connection conn =getConnection();
        ObservableList<users> list = FXCollections.observableArrayList();
        try {
            String sql = null;
           PreparedStatement ps = conn.prepareStatement("select * from users");
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
             list.add(new users(rs.getString("uname"),rs.getString("fname"),rs.getString("lname"),rs.getString("email"),rs.getString("pass")));
            }
        }catch (Exception e){
       }
        
        return list;
    }
    private static class users {
     public users() {
        }

        private users(String string, String string0, String string1, String string2, String string3) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
  
}
