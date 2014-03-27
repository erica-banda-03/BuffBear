package gymsense;

import gymsense.dao.GymsenseDAO;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class RegisterUserServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    UserService userService = UserServiceFactory.getUserService();
	    User user = userService.getCurrentUser();
	    
	    
	    String firstName = req.getParameter("firstName");
	    String lastName = req.getParameter("lastName");
	    String email = req.getParameter("email");
	    String password = req.getParameter("password");
	   // String confirmPassword = req.getParameter("confirmPassword");
	    String workoutType = req.getParameter("workout");
	    
	    GymsenseDAO.INSTANCE.add(firstName, lastName, email, password, workoutType);
	    
	    resp.sendRedirect("/home.jsp");
	}
	
}
