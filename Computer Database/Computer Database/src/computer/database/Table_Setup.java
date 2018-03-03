package computer.database;

import java.sql.*;


public class Table_Setup {
    private Connection conn;
    private Statement state;
    private ResultSet rs;
    
   public Table_Setup(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","1995");
            state = conn.createStatement();
        }catch(Exception ex){
            System.out.println("Error: " + ex);
            
        }
    }
   public void getData(){
       try{
           String query = "Select *from computer";
           rs = state.executeQuery(query);
           System.out.println("Records");
        
           while(rs.next()){
               String name = rs.getString("name");
               String type = rs.getString("type");
               
               System.out.println("name: " + name+ " "+ "Type: "+type);
           }
           
       }catch(Exception ex){
           System.out.println("Error1: " + ex);
       }
   }
   public void inputData(String input){
       
   }
    
}
