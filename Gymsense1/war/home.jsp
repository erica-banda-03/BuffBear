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
	
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true&libraries=places"></script>
    <script>
var map;
var infowindow;
var service;
var myLocation;

function initialize() {
  
  myLocation = new google.maps.LatLng(30.285779, -97.737954);

  map = new google.maps.Map(document.getElementById('map-canvas'),{
    center: myLocation,
    zoom: 15
  });

}

function callback(results, status) {
  if (status == google.maps.places.PlacesServiceStatus.OK) {
    for (var i = 0; i < results.length; i++) {
      createMarker(results[i]);
    }
  }
}

function createMarker(place) {
  var placeLoc = place.geometry.location;
  var marker = new google.maps.Marker({
    map: map,
    position: placeLoc
  });

  var request2 = { reference: place.reference };
  service.getDetails(request2, function(details, status) {
      google.maps.event.addListener(marker, 'click', function() { 
         infowindow.setContent('<span style="padding: 0px; text-align:left" align="left"><h5>' + details.name + '&nbsp; &nbsp; ' + '</h5><p>' + details.formatted_address + '<br />' + details.formatted_phone_number + '<br />' +  '<a  target="_blank" href=' + details.website + '>' + details.website + '</a></p>' ) ;
         infowindow.open(map, this);
        });
  });
}

function GoogleMap(position) {
	myLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);

	var marker = new google.maps.Marker({
	   map: map,
	   position: myLocation,
	   animation: google.maps.Animation.DROP,
	   title: "This is your location"
	});

	map.setCenter(myLocation);

	var request = {
	  location: myLocation,
          radius: 400,
          types: ['restaurant']
        };


        infowindow = new google.maps.InfoWindow();
        service = new google.maps.places.PlacesService(map);
        service.nearbySearch(request, callback);
}

function showError() {
	alert("Location can't be found");
}
//execute geolocation
if (navigator.geolocation) {
	navigator.geolocation.getCurrentPosition(GoogleMap, showError);
}
else {
	alert("Your browser does not support Geolocation.");

}

google.maps.event.addDomListener(window, 'load', initialize);
  
</script>
	
  </head>
  <body>
  
  	<h1>
 		<p1> #Gymsense </p1>
  	</h1>
 
<div id="menu">
<div id="menuButton">
	<a href="#workoutOfTheDay" class="menuStyle">Today's Workout</a>
</div>
<div id="menuButton">
	<a href="#foodMap" class="menuStyle">Restaurants</a>
</div>
<div id="menuButton">
	<a href="#facilityMap" class="menuStyle">Workout Facilities</a>
</div>
<div id="menuButton">
	<a href="#calendar" class="menuStyle">Calendar</a>
</div>
<div id="menuButton">
	<a href="scheduler.jsp" class="menuStyle">Update Free Times</a>
</div>
<div id="menuButton">
	
	<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    %>
    <%
    
    if (user != null) {
      pageContext.setAttribute("user", user);
	%>		
			<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>" class="menuStyle" id="signin">Sign out</a>	
		
	<%
    } else {
	%>

		<a href="<%= userService.createLoginURL(request.getRequestURI()) %>" class="menuStyle" id="signin">Sign In</a>

	<%
    }
	%>
	
</div>


</div>

<div id="mainImage">
	<img src="http://i.usatoday.net/sports/gallery/2008/03/23/s080323_texas.jpg" id="hookEm">
</div>


<h2>About Gymsense</h2>

<div>
	<h2><a id="workoutOfTheDay">Today's Workout</a></h2>
	<p>here's your workout..</p> <br>  
 </div> 
       
 <div >
	<h2><a id="foodMap">Restaurants Near You</a></h2>
	<div id="map-canvas"></div>
</div>   

<div>
	<h2><a id="facilityMap">Workout Facilities Near You</a></h2>
	another map goes here ~~~
</div>          
    
<div>
	<h2><a id="calendar">Calendar</a></h2>
	<p>here's your calendar..</p>    
</div>       		
			
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