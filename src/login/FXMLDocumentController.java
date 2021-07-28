/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author hp
 */
public class FXMLDocumentController {
    
    @FXML
    private Label label;
    
      @FXML
    private TextField txtuser;

    @FXML
    private PasswordField txtpass;
    
       @FXML
    private Button submitButton;
    
     @FXML
    private Label txtlo;
     
      @FXML
    private Label exit;
    
    public void Login(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
         Window owner = submitButton.getScene().getWindow();
        System.out.println(txtuser.getText());
        System.out.println(txtpass.getText());
        
       if(txtuser.getText().isEmpty()){
           showAlert(Alert.AlertType.ERROR,owner, "Form Error!",
                   "please enter your username id");
             return;
       }
               if(txtpass.getText().isEmpty()){
                 showAlert(Alert.AlertType.ERROR,owner, "Form Error!",
                   "please enter your password");
             return;  
               }
               String usname =txtuser.getText();
               String pass = txtpass.getText();
               
               JbcDao JbcDao = new JbcDao();
               boolean flag = JbcDao.validate(usname,pass);
               
          if(!flag){
              infoBox("Please enter correct username and password",null,"Failed");
          }else{
              infoBox("Login Successful!",null,"Succes!");
        Stage primaryStage = new Stage(); 
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Dashbord ");
        primaryStage.setScene(scene);
        primaryStage.show();
          }
       
    }
         @FXML
     void signup(ActionEvent event) throws IOException{
        Stage primaryStage = new Stage(); 
        Parent root = FXMLLoader.load(getClass().getResource("sighup.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("SIGNING UP");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    private void infoBox(String infoMessage,String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
    
  @FXML
    private void handleClose(ActionEvent event){
       System.exit(0);
}  
     
}


