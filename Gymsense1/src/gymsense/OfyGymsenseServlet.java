package gymsense;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import gymsense.Post;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class OfyGymsenseServlet extends HttpServlet{

	static {
        ObjectifyService.register(Post.class);
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    UserService userService = UserServiceFactory.getUserService();
	    User user = userService.getCurrentUser();
	
	    // We have one entity group per Guestbook with all Greetings residing
	    // in the same entity group as the Guestbook to which they belong.
	    // This lets us run a transactional ancestor query to retrieve all
	    // Greetings for a given Guestbook.  However, the write rate to each
	    // Guestbook should be limited to ~1/second.
	    
	    String blogPost = req.getParameter("blogPost");
	    String content = req.getParameter("content");
	    String title = req.getParameter("title");
	   
	    Post post = new Post(user, content, title);
	    ofy().save().entity(post).now();
	    resp.sendRedirect("/home.jsp?blogPost=" + blogPost);
	}
	
}
