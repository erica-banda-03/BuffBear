package gymsense;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.googlecode.objectify.ObjectifyService;

import gymsense.User;
import gymsense.dao.GymsenseDAO;


public class CronServlet extends HttpServlet{

	public static final Logger _log = Logger.getLogger(CronServlet.class.getName());
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		try {
			
		//	_log.severe("hello world");
		
		}
		catch (Exception e) { 
			_log.info("ERROR: Could not send out Email Results response : " + e.getMessage());
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		Boolean sendEmail = false;
		
		try {
		MimeMessage message = new MimeMessage(session, req.getInputStream());

		//Retrieve the new posts from past 24 hours 
		String strCallResult = "";
		List<User> users = GymsenseDAO.INSTANCE.getUser();
		
		for (User user: users) {	
			//create post history
			
			ObjectifyService.register(Post.class);
			List<Post> posts = ObjectifyService.ofy().load().type(Post.class).list();
		    
			if (posts.isEmpty()) {
									//no posts, don't send email
		    } else {
		    	strCallResult = "Hello " + user.getFirstName() + " here are the new posts from today" + "\r\n\n";
		    	
		    	/*Date current = new Date();
		    	Calendar currentTime = Calendar.getInstance();
	            currentTime.setTime(current);
	            Calendar postTime = Calendar.getInstance();
	            
		        for (Post post : posts) {
		        	postTime.setTime(post.getDate());
		            postTime.set(Calendar.DAY_OF_MONTH, currentTime.get(Calendar.DAY_OF_MONTH));
		            postTime.set(Calendar.MONTH, currentTime.get(Calendar.MONTH));
		            postTime.set(Calendar.YEAR, currentTime.get(Calendar.YEAR));
		            
		        	if ( (currentTime.getTimeInMillis() - postTime.getTimeInMillis()) <= 86400000){			// calculate if within 24 hours
		        		sendEmail= true;
		        		strCallResult += post.getUser() + " wrote: \r\n"; 
		        		strCallResult += post.getTitle() +"\r\n" + post.getContent() +"\r\n";
		        		strCallResult += "on "+ post.getDate() + "\r\n";
		        		strCallResult += "=================================" + "\r\n";
		        	}
		        }
		        
		        */
		    	
		    	for (Post post : posts) {
		    		if(post.getSent() == false){
		    			strCallResult += post.getUser() + " wrote: \r\n"; 
		        		strCallResult += post.getTitle() +"\r\n" + post.getContent() +"\r\n";
		        		strCallResult += "on "+ post.getDate() + "\r\n";
		        		strCallResult += "=================================" + "\r\n";
		        		ofy().delete().entity(post).now();
		        		post.setSent(true);
		        		ofy().save().entity(post).now();
		        		sendEmail = true;
		    		}
		    		
		    	}
		        	
		    }
		        	        
			strCallResult += "Thank you for subscribing" + "\r\n";
				
			//Send out Email
			if ( sendEmail == true){
				MimeMessage outMessage = new MimeMessage(session);
				outMessage.setFrom(new InternetAddress("admin@ejblog461l.appspotmail.com"));
				outMessage.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail().getName())); 
				outMessage.setSubject("Daily Blog Updates");
				outMessage.setText(strCallResult);
				Transport.send(outMessage);
			}
		}
		
		} catch (Exception e) {
			_log.info("ERROR: Could not send out Email Results response : " + e.getMessage());
		}
	}
		
}
