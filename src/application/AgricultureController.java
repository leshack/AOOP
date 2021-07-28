/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AgricultureController implements Initializable {

    @FXML
    private AnchorPane border_pane;
     @FXML
    private BorderPane border_pane2;
     
       @FXML
    private TextField txt_fname;

    @FXML
    private TextField txt_lname;

    @FXML
    private TextField txt_phone;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_age;

    @FXML
    private TextField txt_city;

    @FXML
    private ComboBox<String> txt_scale;
    ObservableList<String> list = FXCollections.observableArrayList(" scale farmer","Small scale farmer");

      @FXML
    private TextField txt_acres;
    
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
   public void Add_users (){
    conn = mysqlconnector.connectDb();
    String sql;
        sql = "INSERT INTO users(Firstname,Lastname,Phonenumber,IDNo,Email,Age,City,Scale,Acres)values(?,?,?,?,?,?,?,?,?)";
    try{
        pst = conn.prepareStatement(sql);
        pst.setString(1, txt_fname.getText());
        pst.setString(2, txt_lname.getText());
        pst.setString(3, txt_phone.getText());
        pst.setString(4, txt_id.getText());
        pst.setString(5, txt_email.getText());
        pst.setString(6, txt_age.getText());
        pst.setString(7, txt_city.getText());
        pst.setString(8, txt_scale.getValue());
        pst.setString(9, txt_acres.getText());
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"User Add success");
    }   catch (Exception e) {
                   JOptionPane.showMessageDialog(null,e);

        }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       txt_scale.setItems(list);
    }    

    @FXML
    private void show_agriculture1(MouseEvent event) throws IOException {
       Parent agriculture = FXMLLoader.load(getClass().getResource("agriculture1.fxml"));
        
     border_pane2.setCenter(agriculture);
    }
    
}
