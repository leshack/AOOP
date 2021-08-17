/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodyorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Winston
 */
public class AdminModel {
     Connection connection;
     int aid;
    public AdminModel(){
        connection =SqlConnection.Connector();
        if(connection==null){
            System.exit(0);
            System.out.println("notconnected");
        }
    }
    public boolean isDbConnected(){
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
            return false;
            
        }
       
        
    } 
     public void isAdd(String fname,String lname,String pass) throws SQLException{
        PreparedStatement preparedStatement =null;
        String query="insert into restaurant (first_name,last_name,password)"+"value(?,?,?)";
      try {
          preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
          preparedStatement.setString(1,fname);
          preparedStatement.setString(2,lname);
          preparedStatement.setString(3,pass);
          preparedStatement.execute();
          ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
          if (generatedKeys.next()) {
              aid =generatedKeys.getInt(1);
            }
      } catch (SQLException ex) {
          Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          connection.close();
      }
        

        
    }
     public void isAdd2(String Acode,String pass) throws SQLException{
        PreparedStatement preparedStatement =null;
       
        String query="insert into admin (Admin_code,password)"+"value(?,?)";
      try {
          preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
          preparedStatement.setString(1,Acode);
          preparedStatement.setString(2,pass);
          
          preparedStatement.execute();
      } catch (SQLException ex) {
          Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          connection.close();
      }
        

        
    }
     public boolean isAlpha( String Alcode) throws SQLException{
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet =null;
        String query="select * from admin where Alpha_code=?";
        try{
            preparedStatement =connection.prepareStatement(query);
            preparedStatement.setString(1, Alcode);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(" no!"+e);
            return false;
        }finally{
            preparedStatement.close();
            resultSet.close();
        }
        
      }
     public boolean isAdmin(int userid,String pass) throws SQLException{
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet =null;
        String query="select * from admin where Admin_code=? and password=?";
        try{
            preparedStatement =connection.prepareStatement(query);
            preparedStatement.setInt(1, userid);
            preparedStatement.setString(2, pass);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(" no!"+e);
            return false;
        }finally{
            preparedStatement.close();
            resultSet.close();
        }
        }
    
}
