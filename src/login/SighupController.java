/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

 


public class SighupController implements Initializable {
    
  @FXML
    private TextField fname;

    @FXML
    private TextField uname;

    @FXML
    private TextField email;

    @FXML
    private TextField lname;
    
      @FXML
    private PasswordField pass;
    
    int index =-1;
    Connection conn =null;
    ResultSet rs =null;
    PreparedStatement pst = null;
    
    public void Add_users(){
        conn = ConnectionClass.getConnection();
        String sql ="insert into users(usname,fname,lname,email,pass)values(?,?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, uname.getText());
                pst.setString(2, fname.getText());
                pst.setString(3, lname.getText());
                pst.setString(4, email.getText());
                pst.setString(5, pass.getText());
                pst.execute();
                
                JOptionPane.showMessageDialog(null,"users Added succesful");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
