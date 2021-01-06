import java.io.IOException;
import java.util.Random;
import org.apache.commons.codec.digest.DigestUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	// * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	// */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        //Copying all the input parameters in to local variables
	         String email = request.getParameter("email");
	         String username = request.getParameter("username");
	         String password = request.getParameter("password");
	    
	        
	         NewRegistration register = new NewRegistration();
	         

	         register.setEmail(email);
	         register.setUsername(username);
	         register.setPassword(password);

	         
	         RegisterDao reg = new RegisterDao(); 
	         String userRegistered = reg.registerUser(register);
	         
	         if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
	         {
	 			request.setAttribute("username", username);
	            request.getRequestDispatcher("/home.jsp").forward(request, response);
	         }
	         else   //On Failure, display a meaningful message to the User.
	         {
	            request.setAttribute("errMessage", userRegistered);
	            request.getRequestDispatcher("/create.jsp").forward(request, response);
	         }
	}
	}