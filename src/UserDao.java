import java.sql.*;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils; 
public class UserDao{ 
	public static Member inputInfo(String email)
    {      
		  Connection con;
		    Member m = null;
		    try {
		      con = DBConnection.createConnection();
		      PreparedStatement stmt = con.prepareStatement("Select password from member where email=?");
		      stmt.setString(1, email);
		      ResultSet rs = stmt.executeQuery();
		      if (rs.next()) {
		        m = new Member();
		        
		        m.setPassword(rs.getString("password"));
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return m;
		    
		  }
	
	public String reset(String username, String password) {
	      Connection cn = null; 
	      try {
		    	cn = DBConnection.createConnection(); 
		    	String sql = "update member set username=?, password=? where username=?";
		    	PreparedStatement statement = cn.prepareStatement(sql);
		    	statement.setString(1, username); 
		    	statement.setString(2, password); 
		    	statement.setString(3, username); 
		    	
		    	int i = statement.executeUpdate();  
		    
		    if(i != 0) {
		    	return "SUCCESS"; 
		    	
		    }
		    }
		    catch(SQLException e) {
		    	e.printStackTrace();
		    }
			return "Error when resetting password";

	}
	public String resetPassword(String email, String password) {
		 // Member m = UserDao.inputInfo(email); 
		//  String randomPassword = RandomStringUtils.randomAlphanumeric(10);
	      Connection cn = null; 
		  //m.setPassword(randomPassword);
		    try {
		    	cn = DBConnection.createConnection(); 
		    	String sql = "update member set email=?, password=? where email=?";
		    	PreparedStatement statement = cn.prepareStatement(sql);
		    	statement.setString(1, email); 
		    	statement.setString(2, password); 
		    	statement.setString(3, email); 
		    	
		    	int i = statement.executeUpdate();  
		    
		    if(i != 0) {
		    	return "SUCCESS"; 
		    	
		    }
		    }
		    catch(SQLException e) {
		    	e.printStackTrace();
		    }
			return "error";

	}

	// method to authenticate login of existing member in users data base
	public String authenticateUser(Member m) {
		String username = m.getUsername(); 
		String password = m.getPassword(); 
		ResultSet resultSet = null; 
		String usernameDB; 
		String passwordDB;
		try{
			Connection con = DBConnection.createConnection();	        
			Statement s = con.createStatement(); 		
			resultSet = s.executeQuery("select username, password from member"); 
			while(resultSet.next()) {
				usernameDB = resultSet.getString("username"); 
				passwordDB = resultSet.getString("password"); 
			
		   if(username.equals(usernameDB) && password.equals(passwordDB)) { 
	       return "SUCCESS"; 
			}
		
		}
		}
		catch(SQLException e) { 
			e.printStackTrace(); 
		}
		return "Invalid Login"; 
	}
}