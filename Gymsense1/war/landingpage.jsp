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
  	
  </head>
  
  <body>
  
  	<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
   
    %>
  
  <div id="text" >
  	<div id= "title"><h1>Gymsense</h1></div>
  	<div id="smlText">Your mind and body will thank you</div>
		
		<div id="signup">
			<a href="<%= userService.createLoginURL("http://www.gym-sense.appspot.com/home.jsp") %>" class="button">Sign In</a>
		</div>
		<div id="signup">
			<a href="signup.jsp" class="button">Sign Up</a>
		</div>	
		
	
  </div>

  </body>
  
</html>