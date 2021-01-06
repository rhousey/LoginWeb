import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
public class RegisterDao { 
 		 	
 		     public String registerUser(NewRegistration registration)
 		     {      
 		     String email = registration.getEmail();
 	         String username = registration.getUsername();
 	         String password = registration.getPassword();
 	         PreparedStatement prepareStatement = null; 
 	         ResultSet resultSet = null; 
 	 		 Statement s = null; 
 	 		 Connection cn;
 				
 				try {
 					cn = DBConnection.createConnection(); 
 	 				s = cn.createStatement(); 
 	 				String INSERT_USERS_SQL = "INSERT INTO member (email, username, password) VALUES (?, ?, ?)"; 
 	 				prepareStatement = cn.prepareStatement(INSERT_USERS_SQL); //Making use of prepared statements here to insert bunch of data
 	 				prepareStatement.setString(1, email); 
 	 				prepareStatement.setString(2, username);
 	 				prepareStatement.setString(3, password);
 
        	  int i = prepareStatement.executeUpdate();
        	  	if (i!=0) {
             return "SUCCESS"; 
        	  			}	
 				}
  
 				catch(SQLException e) { 
 					e.printStackTrace();
 				}
 				return "Invalid Registry"; 
 				}
     }