/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labtwo;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class CustomersController implements Initializable {
   @FXML
    private TextField phone;

    @FXML
    private TextField uname;

    @FXML
    private TextField email;
    
     Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    void save_customer(ActionEvent event) {
         conn = mysqlconnector.connectDb();
    String sql;
        sql = "INSERT INTO customers(Name,phonenumber,Email)values(?,?,?)";
    try{
        pst = conn.prepareStatement(sql);
        pst.setString(1, uname.getText());
        pst.setString(2, phone.getText());
        pst.setString(3, email.getText());
        
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"Customer Added successful");
    }   catch (Exception e) {
                   JOptionPane.showMessageDialog(null,e);

        }
    }

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
