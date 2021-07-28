/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labtwo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Admin
 */
public class Test {
     
   Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
     @FXML
    private ComboBox reg ;

    public void Test() {
        conn = mysqlconnector.connectDb();
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
    
}
    
}
