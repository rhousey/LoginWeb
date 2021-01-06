import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import javax.servlet.http.*;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 
		Member member = new Member();
		member.setUsername(username);
		member.setPassword(password);
		
		UserDao userDao = new UserDao(); 
		String validate = userDao.authenticateUser(member); 
		
		if(validate.equals("SUCCESS")) {
			
			HttpSession session = request.getSession(true);  
			session.setAttribute("username", username);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			session.setAttribute("password",  password);
			session.setAttribute(validate, session);
			request.getRequestDispatcher("/home.jsp").forward(request,response); 	
		}
		else {
			request.setAttribute("errMessage", validate); 
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
