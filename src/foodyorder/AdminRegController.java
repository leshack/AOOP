package foodyorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static foodyorder.AdminPanelController.infoBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class AdminRegController implements Initializable {
     AdminModel adminModel=new AdminModel();

     @FXML
    private JFXTextField emptxt;

    @FXML
    private JFXPasswordField passtxt;

    @FXML
    private JFXPasswordField alphacode;
    

    @FXML
 public void Reg(ActionEvent event)throws Exception {
       String Acode=emptxt.getText();
       String  pass=passtxt.getText();
      
       try {
           if((Acode.isEmpty() || pass.isEmpty() )){
               infoBox("Enter valid fields",null,"Error");
           }else{
               adminModel.isAdd2(Acode, pass);
               infoBox(" Added Sucessfully" ,null,"Success" );
               emptxt.clear();
               passtxt.clear();
               alphacode.clear();
               emptxt.setDisable(true);
               passtxt.setDisable(true);
           }
           
       } catch (SQLException ex) {
           infoBox("please fill balnk fields",null,"Alert" );
           Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
       }
      }
  public  void Back(ActionEvent event) throws IOException{
                    Stage primaryStage =new Stage();
                 primaryStage.initStyle(StageStyle.UNDECORATED);
		Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
                
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
                    }

   @FXML
   public  void Unhide(ActionEvent event) {
         try {
             String Alphacode=alphacode.getText();
             
             if(adminModel.isAlpha(Alphacode)){
                 infoBox("You can now enter You Admin previllages to became an admin",null,"Success" );
                  emptxt.setDisable(false);
                  passtxt.setDisable(false);
                  emptxt.clear();
                  passtxt.clear();
             }  else{
                 infoBox("Enter the correct Alpha code",null,"Denied" );
                 alphacode.clear();
                 emptxt.setDisable(true);
                 passtxt.setDisable(true);
             }
         } catch (SQLException ex) {
             Logger.getLogger(AdminRegController.class.getName()).log(Level.SEVERE, null, ex);
         }
   }

    @FXML
    public void exitScreen(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
                   emptxt.setDisable(true);
                   passtxt.setDisable(true);
    }    
    
}
