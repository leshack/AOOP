/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MainController implements Initializable {

    @FXML
    private BorderPane border_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void show_dashboard(MouseEvent event){
       Dynamicview.loadBorderCenter(border_pane,"dashboard");
    }

    @FXML
    private void show_agriculture(MouseEvent event) {
        Dynamicview.loadBorderCenter(border_pane,"agriculture");
    }

    @FXML
    private void show_food(MouseEvent event) {
        Dynamicview.loadBorderCenter(border_pane,"food");
    }

    @FXML
    private void show_security(MouseEvent event) {
        Dynamicview.loadBorderCenter(border_pane,"security");
    }

    @FXML
    private void show_supply(MouseEvent event) {
        Dynamicview.loadBorderCenter(border_pane,"supply");
    }
   
    
}
