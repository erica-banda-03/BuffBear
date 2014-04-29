package gymsense.time;

import gymsense.Dao.GymsenseDAO;

import java.io.IOException;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;
//import com.googlecode.objectify.annotation.Id;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class TimeServlet extends HttpServlet{
	
static {
		ObjectifyService.register(TimeSlot.class);
		ObjectifyService.register(DailySlots.class);
	} 
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
		//UserService userService = UserServiceFactory.getUserService();
	    //User user = userService.getCurrentUser();
	    
		//Object session = request.getSession();
	    //String user= (String)pageContext.getAttribute("User", PageContext.REQUEST_SCOPE);
	    String user = req.getParameter("userEmail");
	    String dayOfWeek = req.getParameter("day");
	    String startTime = req.getParameter("startTime");
	    String endTime = req.getParameter("endTime");    
	  
	  //obtaining current user and retrieving instance from datastore
	  gymsense.User person = GymsenseDAO.INSTANCE.getuser(user);
	 // DailySlots day;
	     
	  TimeSlot slot = new TimeSlot(startTime, endTime, dayOfWeek);
	  ofy().save().entity(slot).now();
	  //WeeklySlots w = new WeeklySlots(user.getEmail());  
	  
	 //DailySlots today = new DailySlots(dayOfWeek, user);
	 //today.add(slot);
	  
	  DailySlots today = ofy().load().type(DailySlots.class).id(user+dayOfWeek).get();
	  today.add(slot);
	  
	  ofy().save().entity(today).now();
	  
	   	    
	    //redirect back to time selection page
	    //resp.sendRedirect("/scheduler.jsp");
	    req.setAttribute("userEmail", user);
		req.getRequestDispatcher("/scheduler.jsp").forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
	
} 