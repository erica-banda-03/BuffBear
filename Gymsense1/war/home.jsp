<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.googlecode.objectify.*" %>
<%@ page import="gymsense.Post" %>
<%@ page import="gymsense.Dao.GymsenseDAO" %>
<%@ page import="gymsense.services.PMF" %>
<%@ page import="javax.jdo.JDOHelper" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="javax.jdo.PersistenceManagerFactory" %>

 
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
var map, map2;
var infowindow;
var service;
var myLocation;

function initialize() {
  
  myLocation = new google.maps.LatLng(30.285779, -97.737954);

  map = new google.maps.Map(document.getElementById('map-canvas1'),{
    center: myLocation,
    zoom: 15
  });
  
   map2 = new google.maps.Map(document.getElementById('map-canvas2'),{
    center: myLocation,
    zoom: 15
  });

}

function callback1(results, status) {
  if (status == google.maps.places.PlacesServiceStatus.OK) {
    for (var i = 0; i < results.length; i++) {
      createMarker1(results[i]);
    }
  }
}

function callback2(results, status) {
  if (status == google.maps.places.PlacesServiceStatus.OK) {
    for (var i = 0; i < results.length; i++) {
      createMarker2(results[i]);
    }
  }
}

function createMarker1(place) {
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

function createMarker2(place) {

  var lift = new Array("Gregory Gymnasium","Anna Hiss Gym", "Clark Field", "Recreational Sports Center");

  var placeLoc = place.geometry.location;

  var name = place.name;

  

  for(var j = 0; j < lift.length; j++) { 

       var res = name.match(lift[j]);

       if (res) {



        var marker = new google.maps.Marker({

          map: map2,

          position: placeLoc

        });



        var request2 = { reference: place.reference };

        service.getDetails(request2, function(details, status) {

        google.maps.event.addListener(marker, 'click', function() { 

         infowindow.setContent('<span style="padding: 0px; text-align:left" align="left"><h5>' + details.name + '&nbsp; &nbsp; ' + '</h5><p>' + details.formatted_address + '<br />' + details.formatted_phone_number + '<br />' +  '<a  target="_blank" href=' + details.website + '>' + details.website + '</a></p>' ) ;

         infowindow.open(map2, this);

          });

        });



     }

   }

}

function GoogleMap1(position) {
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
        service.nearbySearch(request, callback1);
}

function GoogleMap2(position) {

myLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);



var marker = new google.maps.Marker({

  map: map2,

  position: myLocation,

  animation: google.maps.Animation.DROP,

  title: "My Location"

});


map2.setCenter(myLocation);

   

var request = {

  location: myLocation,

          radius: 700,

          types:['gym','university','park']

        };





    infowindow = new google.maps.InfoWindow();

service = new google.maps.places.PlacesService(map2);

//service1 = new google.maps.places.PlacesService(map2);

    service.nearbySearch(request, callback2);

//service1.nearbySearch(request1, callback2);



}

function showError() {
	alert("Location can't be found");
}
//execute geolocation
if (navigator.geolocation) {
	navigator.geolocation.getCurrentPosition(GoogleMap1, showError);
	navigator.geolocation.getCurrentPosition(GoogleMap2, showError);
}
else {
	alert("Your browser does not support Geolocation.");

}

google.maps.event.addDomListener(window, 'load', initialize);
  
</script>
	
  </head>
  <body>
  
  	
  		
 	
	   <div id="header">
	 		<p1> #Gymsense<img src="http://i58.tinypic.com/33cwt49.png" id="towerImg2"> </p1>
	  	</div>
	  	
  	</div>
 
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
		<a href="settings.jsp" class="menuStyle">Settings</a>
		<!--<img src="https://cdn2.iconfinder.com/data/icons/simplus-network-and-mobile-devices/157/Layer_12-01-512.png"> -->
	</div>
	<div id="menuButton">
		
		<%
		
	    UserService userService = UserServiceFactory.getUserService();
	    User userEmail = userService.getCurrentUser();
	    %>
	    <% 
	    if (userEmail != null) {
	      pageContext.setAttribute("user", userEmail);
	      gymsense.User person = GymsenseDAO.INSTANCE.getuser(userEmail.getEmail());	
		  //out.print("hello" + person.getFirstName());
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
	<img src="http://i61.tinypic.com/2dj0yrr.jpg" id="hookEm">
</div>


<div id="workouts">
	<h2><a id="workoutOfTheDay">This Week's Workout Plan</a></h2>
	<%
		gymsense.User person = GymsenseDAO.INSTANCE.getuser(userEmail.getEmail()); %>
		<b>Monday:</b>
	 	<% out.println(person.getMwork());%><br><br>
		<b>Tuesday:</b>
		<% out.println(person.getTwork());%><br><br>
		<b>Wednesday:</b>
		<% out.println(person.getWwork());%><br><br>
		<b>Thursday:</b>
		<% out.println(person.getThwork());%><br><br>
		<b>Friday:</b>
		<% out.println(person.getFwork());%><br><br>
		<b>Saturday:</b>
		<% out.println(person.getSwork());%><br><br>
		<b>Sunday:</b>
		<% out.println(person.getSSwork());%><br>

 </div> 
       
 <div >
	<h2><a id="foodMap">Restaurants Near You</a></h2>
	<div id="map-canvas1"></div> 
</div>   

<div>
	<h2><a id="facilityMap">Workout Facilities Near You</a></h2>
	<div id="map-canvas2"></div> 
</div>          
    
<div>
	<h2><a id="calendar">Calendar</a></h2>
	<p>Calendar coming soon.</p>    
</div>       		
 		
  </body>
</html>