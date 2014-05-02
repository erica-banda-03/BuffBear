<%@ page session="true" %>

<html>
  	<head>
  		<title>Gymsense Settings</title>
  		<link type="text/css" rel="stylesheet" href="settings.css" />
  		
  	<script type="text/javascript">
  	function validateForm(){
		var d =document.forms["register"]["day"].value;
		
		if (d==null){
		  alert("Please select a day");
		  return false;
		}
	}
  	</script>
  		
	</head>
	<body>
		<h1>Settings</h1>
		
		<%
		String email = (String)session.getAttribute("userEmail");
		//out.println(email);
		%>
		<div id= "formBody">
		<form name="updateInfo" action="/Settings?action=update" onsubmit="return validateForm()" method="post">
			<input name="userEmail" type="hidden" value="${userEmail}"/>
		<div id="formPiece">
			<label for="workout">Update Workout Type:</label><br>
				<input type="radio" name="workout" class="radio1" value="Cardio">Cardio<br>
				<input type="radio" name="workout" class="radio1" value="Weight-loss">Weight-loss<br>
				<input type="radio" name="workout" class="radio1" value="Weightlifting">Weightlifting
		</div>
		<div id="formPiece">
			
			<label for="intensity">Update Workout Intensity Level:</label><br>
				<input type="radio" name="intensity" value="Heavy">Heavy<br>
				<input type="radio" name="intensity" value="Light">Light<br>
		</div>
		<div id="formPiece">
			<label for="weight">Update Weight:</label><br>
				<input type="text" name="weight" id="weight" placeholder=" in pounds" value="" style="width: 91px; ">
		</div>
		
		<div id="update">
		<input type="submit" value="Update" id="update" class="button" style="width: 130px; "/>
		</div>
	</form>
			<div id="delete">
			<form name="makeWorkout" action="/Settings?action=delete" method="post">
				<input name="userEmail" type="hidden" value="${userEmail}"/>
				<label for="delete">Delete my account:</label><br>
				<input type="submit" value="Delete" id="delete" class="button" style="width: 130px; "/>
			</form>
			</div>
		</div>
		
				
	</body>
</html>