/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JbcDao {
   Connection conn =null;
     ResultSet rs =null;
     PreparedStatement pst = null;
      private static final String SELECT_QUERY="SELECT * FROM users WHERE usname = ? and pass =?"; 
    public boolean validate(String usname,String pass)throws SQLException, ClassNotFoundException{
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inforation?useTimezone=true&serverTimezone=UTC","root","");
    
            pst = conn.prepareStatement(SELECT_QUERY);
            pst.setString(1, usname);
            pst.setString(2, pass);
            
            System.out.println(pst);
            ResultSet resultSet =pst.executeQuery();
            if(resultSet.next()){
                return true;
            }
         }catch(SQLException e){
             printSQLException(e);
         }
          return false;
    }

    private void printSQLException(SQLException ex) {
        for(Throwable e:ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState:"+((SQLException)e).getSQLState());
                 System.err.println("Error Code:" +((SQLException)e).getErrorCode());
                 System.err.println("Message:"+e.getMessage());
                 Throwable t =ex.getCause();
                 while (t != null){
                     System.out.println("Cause:"+t);
                     t = t.getCause();
                 }
                 
            }
        }
    }
}
    
        
    


 

