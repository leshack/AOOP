

package labtwo;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeJava.type;
import static oracle.net.aso.C00.s;
import static org.eclipse.persistence.expressions.ExpressionOperator.As;
import static sun.net.www.http.HttpClient.New;
import static sun.net.www.http.HttpClient.New;

/**
 *
 * @author Admin
 */
public class moviesController implements Initializable {
    
    @FXML
    private Label label;
    
      @FXML
    private TextField txt_name;
    
      @FXML
    private ComboBox<String> gen;
    ObservableList<String> list = FXCollections.observableArrayList("Action","Science Fiction","Horror",
            "Romance","Comedy","Animation","Documentary",
            "Drama","Familly","Fantasy","Adventure","Crime"
            ,"History","War","Mystery","Reality","Soap","Kids","Politics","Talk");

    @FXML
    private ComboBox<String> reg ;
     
   /* ObservableList<String> list2 = FXCollections.observableArrayList("Action","Science Fiction","Horror",
            "Romance","Comedy","Animation","Documentary",
           "Drama","Familly","Fantasy","Adventure","Crime"
           ,"History","War","Mystery","Reality","Soap","Kids","Politics","Talk");
*/
            
    
   
   Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
   public void Save_Movies (){
    conn = mysqlconnector.connectDb();
    String sql;
        sql = "INSERT INTO movies(Genres,Names)values(?,?)";
    try{
        pst = conn.prepareStatement(sql);
        pst.setString(1, gen.getValue());
        pst.setString(2, txt_name.getText());
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"Movie Added success");
    }   catch (Exception e) {
                   JOptionPane.showMessageDialog(null,e);

        }
}
   
    public void Remove_Movies(){
      /* conn = mysqlconnector.connectDb();
        String sql;
        sql = "DELETE FROM movies WHERE 1 ";
        try{
         pst = conn.prepareStatement(sql);
         pst.setString(1, gen.getValue());
         pst.setString(2, txt_name.getText());
         pst.execute();
        
         JOptionPane.showMessageDialog(null,"Movie Deleted success");
               }  catch (Exception e) {
                 JOptionPane.showMessageDialog(null,e);

       }
   */
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gen.setItems(list);
      //reg.setItems(list2);
      
    }    

    public void  Test() {
        
      try{
        String sql;
        sql = "SELECT  Names from movies ";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next());
        {
         reg.getItems().addAll(rs.getString("Names"));
    }
        pst.close();
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(moviesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
