<%@ page session="true" %>
<%@ page import="com.googlecode.objectify.*" %>
<%@ page import="gymsense.time.DailySlots" %>
<%@ page import="gymsense.time.TimeParser" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Time Selection</title>
<link type="text/css" rel="stylesheet" href="scheduler.css" />
<link rel="Stylesheet" media="screen" href="css/reset.css" />
<link rel="Stylesheet" media="screen" href="css/styles.css" />
<link rel="Stylesheet" media="screen" href="css/ui.core.css" />
<link rel="Stylesheet" media="screen" href="css/jquery.timepickr.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.js"></script>
<script type="text/javascript" src="js/jquery.utils.js"></script>
<script type="text/javascript" src="js/jquery.strings.js"></script>
<script type="text/javascript" src="js/jquery.anchorHandler.js"></script>
<script type="text/javascript" src="js/jquery.ui.all.js"></script>
<script type="text/javascript" src="js/ui.timepickr.js"></script>
<script>
$(function(){ $('#startTime').timepickr({convention:12}); });
$(function(){ $('#endTime').timepickr({convention:12}); });
</script>

<script type="text/javascript">
  	function validateForm(){
		var start =document.forms["timeSelection"]["startTime"].value;
		var end =document.forms["timeSelection"]["endTime"].value;
		var a = 0;
		if (a==null){
		  alert("Invalid time selected!");
		  return false;
		}
	}
  	</script>

</head>
<body>

<div id="title">
<h1>Select your workout times</h1>
</div>
<%
	String email = (String)request.getAttribute("userEmail");
	out.println(email);
%>
	<div id="scheduleBox">
	<div id="left_Col">
	<form name="timeSelection" action="/timeSelection" onsubmit="return validateForm()" method="post">
	<div>	
		<label for="day">Day of the Week</label><br></br>
		<select id="day" name="day">
			<option></option>
			<option value = "Monday">Monday</option>
			<option value = "Tuesday">Tuesday</option>
			<option value = "Wednesday">Wednesday</option>
			<option value = "Thursday">Thursday</option>
			<option value = "Friday">Friday</option>
			<option value = "Saturday">Saturday</option>
			<option value = "Sunday">Sunday</option>		
		</select>
	</div>
	
	<div>
		<label for="startTime">Start Time</label><br></br>
	<input id="startTime" name="startTime" type="text" value="09:00 am" class="demo" style="width: 82px; "/>	
	</div>
	<div>
		<label for="endTime">End Time</label><br></br>
	<input id="endTime" name="endTime" type="text" value="10:00 am" class="demo" style="width: 82px; "/>
		
	</div>
	
	
<% //ensures that times that are being input are valid!

/*String start //change this
	   String end = //change this
	   String startAP, endAP;
	   int startH, startMin; 
	   int endH, endMin;
	   
		TimeParser.parseTime(start);
		startH = TimeParser.getHour();
		startMin = TimeParser.getMinutes();
		startAP = TimeParser.getAMPM();
		if ((startAP.equalsIgnoreCase("pm") && !(startH == 12 && startAP.equalsIgnoreCase("pm"))) || (startH == 12 && startAP.equalsIgnoreCase("am"))){
			startH+=12;
		}
		
		TimeParser.parseTime(end);
		endH = TimeParser.getHour();
		endMin = TimeParser.getMinutes();
		endAP = TimeParser.getAMPM();
		if ((endAP.equalsIgnoreCase("pm") && !(endH == 12 && endAP.equalsIgnoreCase("pm"))) || (endH == 12 && endAP.equalsIgnoreCase("am"))){
			endH+=12;
		}
		
		if (TimeParser.verifyTimes(startH, startMin, endH, endMin)) { */%>
	
			
	<% /*	}
		
		else {
			
			out.print("Incorrect times. Please select other times.");
		}
		*/
	%>
	
<% //view the time slots already added. 



%>	<div>
	<input type="submit" value="Save" name="submit" id="submit" class="button"/>
	</div>
		
	<input name="userEmail" type="hidden" value="${userEmail}"/>
	</form>
	</div>	
	
	<div id="right_col">
		<div id="donediv">
			<form name="makeWorkout" action="/calendar-sampleservlet" method="post">
				<input name="userEmail" type="hidden" value="${userEmail}"/>
				<input type="submit" value="Done" id="done" class="button"/>
			</form>
		</div>
	</div>
	
	</div>
</body>
</html>