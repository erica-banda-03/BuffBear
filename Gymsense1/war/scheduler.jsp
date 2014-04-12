<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Time Selection</title>

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
$(function(){ $('#timestart').timepickr({convention:12}); });
$(function(){ $('#timestart').timepickr(); });
</script>
</head>
<body>

<label for="startTime">Start Time</label>
<input id="startTime" type="text" value="09:00" />
	
<form name="timeSelection" action="/timeSelection" method="post">
	<label for="day">Day of the Week</label>
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
		
	<label for="startTime">Start Time</label>
	<input id="startTime" type="text" value="09:00" />
	<label for="endTime">End Time</label>
	<input id="endTime" type="text" value="10:00" />
	
	
		<input type="submit" value="Save" id="submit" class="button"/>
		<a href="home.jsp" id="submit" >Done</a>
	</form>
</body>
</html>