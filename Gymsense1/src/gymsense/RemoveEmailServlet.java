package gymsense;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import gymsense.Dao.GymsenseDAO;

public class RemoveEmailServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    String address = req.getParameter("rem");
		GymsenseDAO.INSTANCE.remove(address);

		resp.sendRedirect("/ofypost.jsp");
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
		
	}
	
	
}

