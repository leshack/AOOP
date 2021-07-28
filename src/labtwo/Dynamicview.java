/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labtwo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author hp
 */
public class Dynamicview {
    
  private  Dynamicview(){
        
    }
    public static  void loadBorderCenter(BorderPane borderpane,String resource){
      try {
          Parent homepage = FXMLLoader.load(new DynamicView().getClass().getResource(""+resource+".fxml"));
            
          borderpane.setCenter(homepage);
      } catch (IOException ex) {
          Logger.getLogger(Dynamicview.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }

    private static class DynamicView {

        public DynamicView() {
        }
    }
}

