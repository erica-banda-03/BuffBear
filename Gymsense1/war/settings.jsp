<html>
  	<head>
  		<title>Gymsense Settings</title>
  		<link type="text/css" rel="stylesheet" href="Gymsense.css" /><br><br>
	</head>
	<body>
		<h1>Settings</h1>
		
		<%
		String email = (String)request.getAttribute("userEmail");
		//out.println(email);
		%>
		<form name="updateInfo" action="/Settings?action=update" method="post">
		<div>
			<label for="workout">Update Workout Type:</label><br>
				<input type="radio" name="workout" class="radio1" value="Cardio">Cardio<br>
				<input type="radio" name="workout" class="radio1" value="Weight-loss">Weight-loss<br>
				<input type="radio" name="workout" class="radio1" value="Weightlifting">Weightlifting
		</div>
		<div>
			
			<label for="intensity">Update Workout Intensity Level:</label><br>
				<input type="radio" name="intensity" value="Heavy">Heavy<br>
				<input type="radio" name="intensity" value="Light">Light<br>
		</div>
		<div>
			<label for="weight">Update Weight:</label><br>
				<input type="text" name="weight" id="weight" placeholder="in pounds" value="" style="width: 91px; ">
		</div>
	</form>
		
		<div>
			Delete my account:
			<form name="makeWorkout" action="/Settings?action=delete" method="post">
				<input name="userEmail" type="hidden" value="${userEmail}"/>
				<input type="submit" value="Delete" id="done" class="button" style="width: 130px; "/>
			</form>
		</div>
		
				
	</body>
</html>