package gymsense;

import static com.googlecode.objectify.ObjectifyService.ofy;
import gymsense.Dao.GymsenseDAO;
import gymsense.time.DailySlots;
import gymsense.time.TimeSlot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.extensions.appengine.auth.oauth2.AbstractAppEngineAuthorizationCodeServlet;

public class createWorkoutServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
		String user = req.getParameter("userEmail");
		String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		//com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();
	    //com.google.appengine.api.users.User user = userService.getCurrentUser();
	    
	  //obtaining current user and retrieving instance from datastore
	    gymsense.User person = GymsenseDAO.INSTANCE.getuser(user);
		String intensity = person.getIntensity();
		String workoutType = person.getWorkoutType();
	    
		for (int x=0; x < 7; x++){
			DailySlots day = ofy().load().type(DailySlots.class).id(user+weekdays[x]).get();
			TimeSlot slot = day.getLargestTimeSlot();
			
			if(slot != null && slot.getStartHour() != 23 && slot.getEndHour() != 23){
				TimeSlotfiller tsf = new TimeSlotfiller(slot, weekdays[x], workoutType, intensity);
			//	(tsf.getTotalWorkoutTime(), weekdays[x], slot.getStartHour())
				GymsenseDAO.INSTANCE.updateWorkouts(weekdays[x], tsf.getName(),tsf.createWorkout(), user);
					
				}
				//person.setWorkouts(x, tsf.getName()+tsf.createWorkout()+tsf.getTotalWorkoutTime());
			}
		 
	   	    
	    //redirect to home sign-in page
	    resp.sendRedirect("/signIn.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
	
	
}
