<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Collections" %>
<%@ page import="gymsense.Post" %>
 
<html>
  <head>
  	<link type="text/css" rel="stylesheet" href="Gymsense.css" />
  	
  	<script type="text/javascript">
  	
  	function validateForm(){
		var x=document.forms["newPost"]["title"].value;
		var y=document.forms["newPost"]["content"].value;
		if (x==null || x=="" || y==null || y==""){
		  alert("Title and content must be filled out!");
		  return false;
		}
	}
  	
  	</script>
  	
  </head>
 
  <body>
 
	<h1>
 		<p1> Create A New Post </p1>
	</h1>
	  
	      <form name="newPost" action="/home" onsubmit="return validateForm()" method="post">
	      <div id= "submission">
		      <div><textarea name="title" placeholder='Title' rows="1" cols="60"></textarea></div>
		      <div><textarea name="content" placeholder='Content' rows="9" cols="60"></textarea></div>
		      <div>
		      		<input type="submit" value="Submit" />
		     		<input type=button onclick="location.href='home.jsp'" value="Nevermind"/>
		      </div>
	      </div>
	      <input type="hidden" name="blogPost" value="${fn:escapeXml(blogPost)}"/>
	    </form>
	  
  
  </body>
  
  </html>