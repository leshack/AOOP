package calcb;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author a47
 */
public class CalcB extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //LABELS
     Text num_one=new Text("1st Number");
     Text num_two=new Text("2nd Number");
     Text result_label=new Text("Result");
     Text result=new Text();


     
     
     
     //TEXTFIELDS
     TextField num_one_tf=new TextField();
     TextField num_two_tf=new TextField();
     
     //BUTTONS
     Button sum_btn = new Button("Sum");
     Button ave_btn = new Button("Average");
     Button diff_btn = new Button("Difference"); 
     
     if(num_one_tf.getText().trim().isEmpty()){
         num_one_tf.setText(Integer.toString(0));
     }
      if(num_two_tf.getText().trim().isEmpty()){
         num_two_tf.setText(Integer.toString(0));
     }
     
     
     
    //EVENT HANDLING 
    // Force the fields to be Integers
     num_one_tf.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("\\d*")) {
                num_one_tf.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
     });
     num_two_tf.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("\\d*")) {
                num_two_tf.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
      });
    
     
     //Buttons handling
     
     //Sum
     sum_btn.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) { 
         int fin_res = (Integer. parseInt(num_one_tf.getText())) + (Integer. parseInt(num_two_tf.getText()));
         result.setText(Integer.toString(fin_res));
         } 
      })); 
      //Ave
     ave_btn.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) { 
         int fin_res = ((Integer. parseInt(num_one_tf.getText()))+(Integer. parseInt(num_two_tf.getText())))/2;
         result.setText(Integer.toString(fin_res));
         } 
      })); 
     
      //Diff
     diff_btn.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) { 
         int fin_res = ((Integer. parseInt(num_one_tf.getText()))-(Integer. parseInt(num_two_tf.getText())));
         result.setText(Integer.toString(fin_res));
         } 
      })); 
     
     
     
       
     //GRIDPANE (Container)  
     
     GridPane gridPane = new GridPane();     
     gridPane.add(num_one,1,1);
     gridPane.add(num_two,1,2);
     gridPane.add(result_label,1,3);
     gridPane.add(num_one_tf,2,1);
     gridPane.add(num_two_tf,2,2);
     gridPane.add(result,2,3);
     gridPane.add(sum_btn,3,1);
     gridPane.add(ave_btn,3,2);
     gridPane.add(diff_btn,3,3);
     
    
     gridPane.setMinSize(500,250);        
     gridPane.setVgap(10);        
     gridPane.setHgap(20);        
     gridPane.setAlignment(Pos.CENTER);
             
     //SCENE
     Scene my_scene = new Scene(gridPane);


     //STAGE
     primaryStage.setScene(my_scene);
     primaryStage.setTitle("Simple Calculator");
     primaryStage.show();
     
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}