<%@ page session="true" %>
<%@ page import="com.googlecode.objectify.*" %>
<%@ page import="gymsense.time.DailySlots" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="gymsense.time.TimeSlot" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Time Selection</title>
<link type="text/css" rel="stylesheet" href="updateScheduler.css" />
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
$(function(){ $('#startTimeRemove').timepickr({convention:12}); });
$(function(){ $('#endTimeRemove').timepickr({convention:12}); });
</script>
</head>
<body>


<div id="title">
<h1>Update your workout times</h1><br></br>
</div>
<%
	String email = (String)session.getAttribute("userEmail");
	String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	//out.println(email);
%>

<div id="schedule">
<% 
ObjectifyService.register(DailySlots.class);
ObjectifyService.register(TimeSlot.class);
ArrayList<DailySlots> l = new ArrayList<DailySlots>();
for (String day: days ){
	l.add( ObjectifyService.ofy().load().type(DailySlots.class).id(email+day).get());
}

if (l == null || l.size() <= 0) {
	%> You have no workout times.
	<% 
}
if (l != null && l.size()>0){
%>
<%ArrayList<TimeSlot> MSlot= l.get(0).getTimeSlots(); 
 		out.println(MSlot);
	%>
		 Sunday: <%out.println(l.get(0).toString());%><a href="/updateSchedule?action=remove&id=${userEmail}Sunday" >X</a><br></br>
		 Monday: <%out.println(l.get(1).toString());%><a href="/updateSchedule?action=remove&id=${userEmail}Monday" >X</a><br></br>
		 Tuesday:<%out.println(l.get(2).toString());%><a href="/updateSchedule?action=remove&id=${userEmail}Tuesday" >X</a><br></br>
		 Wednesday: <%out.println(l.get(3).toString());%><a href="/updateSchedule?action=remove&id=${userEmail}Wednesday" >X</a><br></br>
		 Thursday: <%out.println(l.get(4).toString());%><a href="/updateSchedule?action=remove&id=${userEmail}Thursday" >X</a><br></br>
		 Friday: <%out.println(l.get(5).toString());%><a href="/updateSchedule?action=remove&id=${userEmail}Friday" >X</a><br></br>
		 Saturday: <%out.println(l.get(6).toString());%><a href="/updateSchedule?action=remove&id=${userEmail}Satruday" >X</a><br></br>
		 
		 <%

}
%>
</div>

	<div id="scheduleBox">
	<div id="left_Col" style="height: 174px; ">
	<form name="timeSelectionAdd" action="/updateScheduler" method="post">
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
	<input id="endTime" name="endTime" type="text" value="10:00 am" class="demo" style="width: 84px; "/>
		
	</div>
	
	<div>
	<input type="submit" value="Add" name="submit" id="submit" class="button"/>
	</div>
	<div>
	<input type="submit" value="Remove" name="remove" id="remove" class="button"/>
	</div>

	<input name="userEmail" type="hidden" value="${userEmail}"/>
	</form>
	</div>
		
	<div id="right_col">
	<div id="doneDiv" >
		<form name="makeWorkout" action="/createWorkout" method="post">
			<input name="userEmail" type="hidden" value="${userEmail}"/>
			<input type="submit" value="Done" id="done" class="button" />			
		</form>
	</div>
	</div>
	
	</div>
	
</body>
</html>