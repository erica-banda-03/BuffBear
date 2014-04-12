<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
  <head>
  	<title>Gymsense</title>
  	<link type="text/css" rel="stylesheet" href="landingpage.css" />
  	
  	<script type="text/javascript">
  	function validateForm(){
		if (user != null) {
			String site = new String("http://www.gym-sense.appspot.com/home.jsp");
			response.setHeader("Gymsense", site); 	
		}
		else{
		  return false;
		}
	}
  	</script>
  	
  </head>
  
  <body>
  
  <div id="text">
  	<h1>Gymsense</h1>
  	
  	<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    %>
   
    <form name="signedin" action="/home.jsp" onsubmit="return validateForm()" method="get">
	<div id="bothButtons">	
		<div>
			<a href="<%= userService.createLoginURL(request.getRequestURI()) %>" class="button">Sign In</a>
		</div>	
		
	</form>
		<div>
			<a href="signup.jsp" class="button">Sign Up</a>
		</div>
	
  </div>

  </body>
  
</html>