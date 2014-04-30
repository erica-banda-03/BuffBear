package gymsense;

import static com.googlecode.objectify.ObjectifyService.ofy;
import gymsense.Dao.GymsenseDAO;
import gymsense.time.DailySlots;
import gymsense.time.TimeSlot;
import gymsense.time.WeeklySlots;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.ObjectifyService;


public class RegisterUserServlet extends HttpServlet{
	
	static {
		
		ObjectifyService.register(DailySlots.class);
	} 
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	    
	    String firstName = req.getParameter("firstName");
	    String lastName = req.getParameter("lastName");
	    String email = req.getParameter("email");
	    String birthMonth = req.getParameter("month");
	    String birthDay = req.getParameter("day");
	    String birthYear = req.getParameter("year");
	    String sex = req.getParameter("sex");
	    String workoutType = req.getParameter("workout");
	    String intensity = req.getParameter("intensity");
	    String heightInches = req.getParameter("inches");
	    String weight = req.getParameter("weight");
	    String heightFeet= req.getParameter("feet");
	    
	    GymsenseDAO.INSTANCE.add(firstName, lastName, email, birthMonth, birthDay, birthYear, sex, workoutType, intensity, weight, heightInches, heightFeet);
	    
	    //TimeSlot slot0 = new TimeSlot("11:00 pm", "11:30 pm", "Monday");
	    DailySlots mon = new DailySlots("Monday", email);
	    DailySlots tues = new DailySlots("Tuesday", email);
	    DailySlots wed = new DailySlots("Wednesday", email);
	    DailySlots thurs = new DailySlots("Thursday", email);
	    DailySlots fri = new DailySlots("Friday", email);
	    DailySlots sat = new DailySlots("Saturday", email);
	    DailySlots sun = new DailySlots("Sunday", email);
	    //mon.add(slot0);
	    //tues.add(slot1);
	    //wed.add(slot2);
	    //thurs.add(slot3);
	    //fri.add(slot4);
	    //sat.add(slot5);
	    //sun.add(slot6);
	    
	    ofy().save().entity(mon).now();
	    ofy().save().entity(tues).now();
	    ofy().save().entity(wed).now();
	    ofy().save().entity(thurs).now();
	    ofy().save().entity(fri).now();
	    ofy().save().entity(sat).now();
	    ofy().save().entity(sun).now();
	    
	    req.setAttribute("userEmail", email);
	    req.getRequestDispatcher("/scheduler.jsp").forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
	
}
