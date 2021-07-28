/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Admin
 */
public class FXMLDocumentController implements Initializable {
    
 
    
      @FXML
    private TextField Textfield1;//This is were the first number will be held
 
    @FXML
    private TextField Textfield2;//This is were the second number will be held

    @FXML
    private Label result;//were the result will be handled
    
    
   //Event Handling i used ActionEvent
    public void avg(ActionEvent event) {
        int fin_res = ((Integer. parseInt(Textfield1.getText()))+(Integer. parseInt(Textfield2.getText())))/2;
         result.setText(Integer.toString(fin_res));
    }

    
    public void sub_diff(ActionEvent event) {
         int fin_res=(Integer. parseInt(Textfield1.getText()))- (Integer. parseInt(Textfield2.getText()));
     result.setText(Integer.toString(fin_res));
    }
     
   public void add_sum(ActionEvent event) {
     int fin_res=(Integer. parseInt(Textfield1.getText()))+ (Integer. parseInt(Textfield2.getText()));
     result.setText(Integer.toString(fin_res)); 
    } 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    private void getText() {
       throw new UnsupportedOperationException("Not supported yet.");
       //To change body of generated methods, choose Tools | Templates.
       
    }
    
}
