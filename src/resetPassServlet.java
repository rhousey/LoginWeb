import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/resetPassServlet")
public class resetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username"); 
		String newPass = request.getParameter("newPass"); 
		String confirmPass = request.getParameter("confirmPass"); 
		Member member = new Member();
		member.setUsername(username);
		member.setPassword(newPass);
		UserDao userDao = new UserDao(); 
        String validate = userDao.reset(username, newPass);
        session.setAttribute("username", username); 
        if(validate.equals("SUCCESS")) {
        	request.setAttribute("msg", "User Updated Successfully");
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response); 
        }
    	request.setAttribute("msg", validate); 
		request.getRequestDispatcher("/resetPassForm.jsp").forward(request, response);

	}

	}


