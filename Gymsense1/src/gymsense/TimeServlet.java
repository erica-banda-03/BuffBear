package gymsense;

import gymsense.dao.GymsenseDAO;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gymsense.dao.GymsenseDAO;


public class TimeServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    
	    String dayOfWeek = req.getParameter("day");
	    String startTime = req.getParameter("startTime");
	    String endTime = req.getParameter("endTime");
	    
	    
	    //add to database
	    // GymsenseDAO.INSTANCE.addWeeklySlot();
//GymsenseDAO.INSTANCE.updateTime(startTime, "jewelsleon@gmail.com");
	   
	    
	    //redirect back to time selection page
	    resp.sendRedirect("/scheduler.jsp");
	    
	    //when done redirect to home
	    //resp.sendRedirect("/home.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
	
}
