<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.googlecode.objectify.*" %>
<%@ page import="gymsense.Post" %>
<%@ page import="gymsense.dao.GymsenseDAO" %>

 
<html>
  <head>
  	<title>Gymsense</title>
  	<link type="text/css" rel="stylesheet" href="Gymsense.css" />
  	
  	<script type="text/javascript">
  	function showmessage() {
 	  document.getElementById("email").type="visible";
 	  document.getElementById("email").style.textAlign="center";
 	  document.getElementById("sub").style.visibility = "visible";
 	  document.getElementById("user").type="visible";
 	  document.getElementById("user").style.textAlign="center";
	}
	
	function remove1() {
 	  document.getElementById("rem").type="visible";
 	  document.getElementById("rem").style.textAlign="center";
 	  document.getElementById("remove").style.visibility = "visible";
	}
	
	function validateForm(){
		var x=document.forms["subscribe"]["email"].value;
		var y=document.forms["subscribe"]["user"].value;
		if (x==null || x=="" || y==null || y==""){
		  alert("Email and name must be filled out");
		  return false;
		}
	}
	
	function validateForm2(){
		var x=document.forms["unsubscribe"]["rem"].value;
		if (x==null || x==""){
		  alert("Email must be filled out");
		  return false;
		}
	}
	
	</script>
	
  </head>
  <body>
  
  	<h1>
 		<p1> Gymsense </p1>
  	</h1>
 
	<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    %>
    <%
    
    if (user != null) {
      pageContext.setAttribute("user", user);
	%>
		<div id="signout">
			<p>
			<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>" class="button">Sign out</a>
			</p>
		</div>
		<div id="newpost">
			<a href="newpost1.jsp" class="button">Create New Post</a>
		</div>	
	<%
    } else {
	%>
		<div id="signin">
		<a href="<%= userService.createLoginURL(request.getRequestURI()) %>" class="button">Sign In</a>
		</div>
	<%
    }
	%>
 
        
       		
			
				<div id= "subscription" >
				<form name="subscribe" action="/subscribers" onsubmit="return validateForm()" method="get">
					<input type="button" value="Subscribe" class="button" onclick="showmessage()"/>
					<input type="hidden" type="text" name="email" placeholder='Email Address' id="email" style="height:30px">
					<input type="hidden" type="text" name="user" placeholder='Name' id="user" style="height:30px">
					<input type="submit" style="visibility:hidden" value="Submit" id="sub"/>
				</form>
				</div>
				<div id= "subscription">
				<form name="unsubscribe" action="/unsubscribe" onsubmit="return validateForm2()" method="get">
					<input type="button" value="Unsubscribe" class="button" onclick="remove1()"/>
					<input type="hidden" type="text" name="rem" placeholder='Email Address' id="rem" style="height:30px">
					<input type="submit" style="visibility:hidden" value="Remove Me" id="remove"/>
				</form>
				</div>
 		
  </body>
</html>