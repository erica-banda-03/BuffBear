<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html>
 <head>
  	<title>Gymsense</title>
  	<link type="text/css" rel="stylesheet" href="signIn.css" />
  	
 </head>

<body>

<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
%>

	<div id="signup">
			<a href="<%= userService.createLoginURL("http://www.gym-sense.appspot.com/home.jsp") %>" class="button">Sign In</a>
	</div>
</body>
</html>