package gymsense;

import gymsense.dao.GymsenseDAO;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterUserServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    
	    String firstName = req.getParameter("firstName");
	    String lastName = req.getParameter("lastName");
	    String email = req.getParameter("email");
	    //String password = req.getParameter("password");
	    String birthMonth = req.getParameter("month");
	    String birthDay = req.getParameter("day");
	    String birthYear = req.getParameter("year");
	    //Integer birthDay = Integer.parseInt(req.getParameter("day"));
	    //Integer birthYear = Integer.parseInt(req.getParameter("year"));
	    String sex = req.getParameter("sex");
	    String workoutType = req.getParameter("workout");
	    String intensity = req.getParameter("intensity");
	    String heightInches = req.getParameter("inches");
	    String weight = req.getParameter("weight");
	    //Integer weight = Integer.parseInt(req.getParameter("weight"));
	    //Integer heightInches = Integer.parseInt(req.getParameter("inches"));
	    String heightFeet= req.getParameter("feet");
	    
	    //Integer heightFeet = Integer.parseInt(req.getParameter("feet"));
	    GymsenseDAO.INSTANCE.add(firstName, lastName, email, birthMonth, birthDay, birthYear, sex, workoutType, intensity, weight, heightInches, heightFeet);
	    
	    resp.sendRedirect("/scheduler.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
	
}
