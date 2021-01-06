import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;


@WebServlet("/recoverPassServlet")
public class recoverPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private String host;
	    private String port;
	    private String user;
	    private String pass;
	   
	    
        public recoverPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  public void init() { 
	  ServletContext context = getServletContext(); 
	  host = context.getInitParameter("host"); 
	  port = context.getInitParameter("port"); 
	  user = context.getInitParameter("user"); 
	  pass = context.getInitParameter("pass"); 
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 	 String email = request.getParameter("email"); 
			 	 String username = request.getParameter("username"); 
		         Random ran = new Random(); 
		         ran.nextInt(99999); 
		         String newPassword = DigestUtils.md5Hex("" + ran); 
		         System.out.println(newPassword);
		         Member x = new Member();
		         
		         x.setEmail(email);
		         x.setUsername(username);
		         x.setPassword(newPassword);
		         
		         UserDao u = new UserDao(); 
		         String reset = u.resetPassword(email, newPassword);

		         if(reset.equals("SUCCESS")) {
		         EmailUtil e = new EmailUtil(email, newPassword); 
		         e.send(); 
				 request.getRequestDispatcher("/login.jsp").forward(request,response);  
		         }
		 }
		         
				 
		 
		 catch(Exception e) {
			 System.out.println("Error at reset servlet "); 
		 }
	}
}
