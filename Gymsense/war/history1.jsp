<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.googlecode.objectify.*" %>
<%@ page import="gymsense.Post" %>
 
<html>
  <head>
  	<link type="text/css" rel="stylesheet" href="Gymsense.css" />
  </head>
 
  <body>
  
  	<h1>
 		<p1> Gymsense </p1>
  	</h1>
 
	<div id="home">
		<a href="home.jsp" class="button">Home</a>
		
	</div> 
 
	<% 
    String blogPost = request.getParameter("blogPost");
    if (blogPost == null) {
        blogPost = "default";
    }
    pageContext.setAttribute("blogPost", blogPost);
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();

    if (user != null) {
      pageContext.setAttribute("user", user);
	%>

	<%
    } 
%>
 
<%
    
	ObjectifyService.register(Post.class);
	List<Post> posts = ObjectifyService.ofy().load().type(Post.class).list();   
	Collections.sort(posts,Collections.reverseOrder()); 
	
    if (posts.isEmpty()) {
        %>
        <div><p>This blog has no posts.</p></div>
        <%
    } else {
    	
        
        for (Post post : posts) {
        	pageContext.setAttribute("post_title", post.getTitle());
            pageContext.setAttribute("post_content", post.getContent());
            pageContext.setAttribute("post_date", post.getDate());
            
            
            if (post.getUser() != null) {
            
            
           
                pageContext.setAttribute("post_user", post.getUser());
                %>
               		<div id="post"> <p><b>${fn:escapeXml(post_user.nickname)}</b>:</p>
                <%
                
	            %>
	           		<p2><div>${fn:escapeXml(post_title)} </div></p2>
	           	<%
	           	%>
	           		<div>${fn:escapeXml(post_content)}</div>
	            <%
	            
	            %>
                <div id="date">Posted on <b>${fn:escapeXml(post_date)}</b> </div></div>
                <%
                
               
            }
            
        }
        
        %><a href="#" class="back-to-top">Back to Top</a><%
    }
				
%>
 		
  </body>
</html>