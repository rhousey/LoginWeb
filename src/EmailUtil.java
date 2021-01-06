import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

public class EmailUtil{
	private String email; 
	private String password; 
	
	public EmailUtil(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public void send(){
		Properties prop = System.getProperties(); 
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.required", "true");
	    
	    Session s = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("*********", "********");
			}
		});
      
	try {
	Message msg = new MimeMessage(s); 
	msg.setFrom(new InternetAddress(*****, *****));	
	InternetAddress[] to = {new InternetAddress(email)}; 
	msg.setRecipients(Message.RecipientType.TO, to); 
	msg.setSubject("Reset Pass");
	msg.setSentDate(new Date()); 
	//msg.setText("The link to reset your password is : " + "http://localhost:8080/LoginWeb/RecoverPassword?key1="+ email + "&key2=" + randomCode);  
	msg.setText("Your temporary password is : " +  password + "\nReset it after logging in.");  

	Transport.send(msg);
}
	catch(Exception e) {
		System.out.println("Error occured when trying to send email."); 
	}
		
	}
}
	
	


	