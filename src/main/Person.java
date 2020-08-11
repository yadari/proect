package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Person {
    Statement stat;
    ResultSet RestS;
    Connection con;

    public void insert(String name,int age,String gender){
      int  UserID=0;
      
        try {
            String DBURL = "jdbc:ucanaccess://DB1.accdb";
            con = DriverManager.getConnection(DBURL);
            stat = con.createStatement();
            stat.executeUpdate("Insert into  Person (" +"'"+UserID+
            "','"+name+"','"+age+"','"+gender+"')");
            
            con.close();
            System.out.println("all data inserted");
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void select() throws SQLException{
        String DBURL = "jdbc:ucanaccess://DB1.accdb";
            con = DriverManager.getConnection(DBURL);
            stat = con.createStatement();
               
        String st1= "Select * from Person";
            RestS = stat.executeQuery(st1);
            while (RestS.next())   {
                System.out.println("ID"+RestS.getString(1)+"|Name"+RestS.getString(2)+"|Age"+RestS.getString(3)+"|Gender"+RestS.getString(4));
               }
            con.close();
            System.out.println("all data are reseved");
    }
    public void delete(String name) throws SQLException{
        String DBURL = "jdbc:ucanaccess://DB1.accdb";
            con = DriverManager.getConnection(DBURL);
            stat = con.createStatement();
               
      String sql = "DELETE FROM Registration " +
                   "WHERE Name Like'"+name+"'";
      stat.executeUpdate(sql);
            con.close();
            System.out.println("data is deleted");
    }
    
    
    
}
