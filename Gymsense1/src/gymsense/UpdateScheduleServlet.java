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

public class UpdateScheduleServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
		String user = req.getParameter("userEmail");
		String idDay = req.getParameter("id");
		
		//add daily slot 
	  if(req.getParameter("action").equals("save")){
		String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
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
			}
	  } 
	  //remove dailyslot from user's record
	  else if(req.getParameter("action").equals("remove")){
		  //String deleteDay = req.getParameter("");
		  DailySlots dSlot = ofy().load().type(DailySlots.class).id(idDay).get();
		  
		  
		  //ofy().delete().type(DailySlots.class).id(idDay);
		 // ofy().delete().type(TimeSlot.class).id();
		  
		  
	  }    
	    //redirect to home sign-in page
	    resp.sendRedirect("/home.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
	
	
}