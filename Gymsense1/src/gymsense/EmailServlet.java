package gymsense;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import gymsense.dao.GymsenseDAO;

public class EmailServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String name = req.getParameter("user");
	    String address = req.getParameter("email");
	    
	    //GymsenseDAO.INSTANCE.add(name, address);

	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	/*	String name = req.getParameter("user");
	    String address = req.getParameter("email");
		EJBlogDAO.INSTANCE.add(name, address);*/
		
	}
	
	
}

