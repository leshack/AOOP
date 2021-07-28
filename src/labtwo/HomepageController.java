/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labtwo;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class HomepageController implements Initializable {
    
    
     @FXML
    private BorderPane border_pane;

    /** @FXML
    void OpenC(ActionEvent event) throws IOException {
            Stage primaryStage = new Stage(); 
        Parent root = FXMLLoader.load(getClass().getResource("customers.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("CUSTOMER");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void OpenM(ActionEvent event)throws IOException {
         Stage primaryStage = new Stage(); 
        Parent root = FXMLLoader.load(getClass().getResource("movies.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("MOVIES");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void OpenR(ActionEvent event) throws IOException {
         Stage primaryStage = new Stage(); 
        Parent root = FXMLLoader.load(getClass().getResource("Rentals.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Rentals");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void openG(ActionEvent event) throws IOException {
         Stage primaryStage = new Stage(); 
        Parent root = FXMLLoader.load(getClass().getResource("Genres.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("GENRES");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    **/
     @FXML
    void CloseH(TouchEvent event) throws IOException {
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
     private void show_movie(javafx.scene.input.MouseEvent event){
       Dynamicview.loadBorderCenter(border_pane,"movies");
    }

    @FXML
     private void show_customer(javafx.scene.input.MouseEvent event) {
        Dynamicview.loadBorderCenter(border_pane,"customers");
    }

    @FXML
    private void show_rentals(javafx.scene.input.MouseEvent event) {
        Dynamicview.loadBorderCenter(border_pane,"Rentals");
    }

    @FXML
    private void show_genres(javafx.scene.input.MouseEvent event) {
        Dynamicview.loadBorderCenter(border_pane,"FXML");
    }

   
    }    
    

