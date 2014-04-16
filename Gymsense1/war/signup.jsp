<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<html>
  <head>
  	<title>Gymsense SignUp</title>
  	<link type="text/css" rel="stylesheet" href="signup.css" />
  	
  	
  	<script type="text/javascript">
  	function validateForm(){
		var a=document.forms["register"]["firstName"].value;
		var b=document.forms["register"]["lastName"].value;
		var c=document.forms["register"]["email"].value;
		var d=document.forms["register"]["weight"].value;
		
		
		if (a==null || a=="" || b==null || c==null || d==null ){
		  alert("All fields must be filled out!");
		  return false;
		}
	}
  	</script>
  	
  </head>
  
  <body>
<h1>Gymsense Sign-up</h1>
	<form name="register" action="/RegisterUser" onsubmit="return validateForm()" method="post">
		
			<div class="form-section">
				
				<div class="left-col">
					<label for="user-firstname">Name</label>
					<div class="field">
						<input type="text"  name="firstName" id="user-firstname" placeholder="First" data-validate="{&quot;required&quot;: true, &quot;format&quot;: &quot;^.{2,255}$&quot;}" value="">
					</div>
					
					<div class="field">	
						<input type="text" name="lastName" id="user-lastname" placeholder="Last" data-validate="{&quot;required&quot;: true, &quot;format&quot;: &quot;^.{2,255}$&quot;}" value="" >
					</div>
					
					<label for="user-email">Email Address</label>
					(must be a gmail account)
					<div class="field">
						<input type="text" name="email" id="user-email" placeholder="me@gmail.com" data-validate="{&quot;required&quot;: true, &quot;format&quot;: &quot;email&quot;}" value="" autocomplete="off">
					</div>
					
					<!--  
					<label for="password">Password</label>
					<div class="field"><input type="text" name="password" id="password"  value="">
					</div>
					<label for="confirmpassword">Confirm Password</label>
					<div class="field"><input type="text" name="confirmPassword" id="confirmPassword"  value="">
					</div>
					-->
					
					<label for="weight">Weight</label>
					<div class="field"><input type="text" name="weight" id="weight" placeholder="in pounds" value="">
					</div>
				
				

				<label for="birthday">Birthday</label>
				<div class="birthday">
				
				<select id="month" name="month">
					<option></option>
					<option value = "1">January</option>
					<option value = "2">February</option>
					<option value = "3">March</option>
					<option value = "4">April</option>
					<option value = "5">May</option>
					<option value = "6">June</option>
					<option value = "7">July</option>
					<option value = "8">August</option>
					<option value = "9">September</option>
					<option value = "10">October</option>
					<option value = "11">November</option>
					<option value = "12">December</option> 
				</select>
				
				<!-- Day dropdown -->
			<select name="day" id="day" size="1">
				<option></option>
			    <option value="01">01</option>
			    <option value="02">02</option>
			    <option value="03">03</option>
			    <option value="04">04</option>
			    <option value="05">05</option>
			    <option value="06">06</option>
			    <option value="07">07</option>
			    <option value="08">08</option>
			    <option value="09">09</option>
			    <option value="10">10</option>
			    <option value="11">11</option>
			    <option value="12">12</option>
			    <option value="13">13</option>
			    <option value="14">14</option>
			    <option value="15">15</option>
			    <option value="16">16</option>
			    <option value="17">17</option>
			    <option value="18">18</option>
			    <option value="19">19</option>
			    <option value="20">20</option>
			    <option value="21">21</option>
			    <option value="22">22</option>
			    <option value="23">23</option>
			    <option value="24">24</option>
			    <option value="25">25</option>
			    <option value="26">26</option>
			    <option value="27">27</option>
			    <option value="28">28</option>
			    <option value="29">29</option>
			    <option value="30">30</option>
			    <option value="31">31</option>
			</select>
				
				<select id="year" name="year">
					<option></option>
					<option value="2007">2007</option>
					<option value="2006">2006</option>
					<option value="2005">2005</option>
					<option value="2004">2004</option>
					<option value="2003">2003</option>
					<option value="2002">2002</option>
					<option value="2001">2001</option>
					<option value="2000">2000</option>
					<option value="1999">1999</option>
					<option value="1998">1998</option>
					<option value="1997">1997</option>
					<option value="1996">1996</option>
					<option value="1995">1995</option>
					<option value="1994">1994</option>
					<option value="1993">1993</option>
					<option value="1992">1992</option>
					<option value="1991">1991</option>
					<option value="1990">1990</option>
					<option value="1989">1989</option>
					<option value="1988">1988</option>
					<option value="1987">1987</option>
					<option value="1986">1986</option>
					<option value="1985">1985</option>
					<option value="1984">1984</option>
					<option value="1983">1983</option>
					<option value="1982">1982</option>
					<option value="1981">1981</option>
					<option value="1980">1980</option>
					<option value="1979">1979</option>
					<option value="1978">1978</option>
					<option value="1977">1977</option>
					<option value="1976">1976</option>
					<option value="1975">1975</option>
					<option value="1974">1974</option>
					<option value="1973">1973</option>
					<option value="1972">1972</option>
					<option value="1971">1971</option>
					<option value="1970">1970</option>
					<option value="1969">1969</option>
					<option value="1968">1968</option>
					<option value="1967">1967</option>
					<option value="1966">1966</option>
					<option value="1965">1965</option>
					<option value="1964">1964</option>
					<option value="1963">1963</option>
					<option value="1962">1962</option>
					<option value="1961">1961</option>
					<option value="1960">1960</option>
					<option value="1959">1959</option>
					<option value="1958">1958</option>
					<option value="1957">1957</option>
					<option value="1956">1956</option>
					<option value="1955">1955</option>
					<option value="1954">1954</option>
					<option value="1953">1953</option>
					<option value="1952">1952</option>
					<option value="1951">1951</option>
					<option value="1950">1950</option>
					<option value="1949">1949</option>
					<option value="1948">1948</option>
					<option value="1947">1947</option>
					<option value="1946">1946</option>
					<option value="1945">1945</option>
					<option value="1944">1944</option>
					<option value="1943">1943</option>
					<option value="1942">1942</option>
					<option value="1941">1941</option>
					<option value="1940">1940</option>
				</select>	
			</div>
			</div>	
				
			<div class="center-col">	
				<div>
				<label for="workout">Workout Type</label><br>
				<input type="radio" name="workout" value="Cardio">Cardio<br>
				<input type="radio" name="workout" value="Weight-loss">Weight-loss<br>
				<input type="radio" name="workout" value="Weightlifting">Weightlifting
				</div>
				
				<div>
				<label for="intensity">Workout Intensity</label><br>
				<input type="radio" name="intensity" value="">Heavy<br>
				<input type="radio" name="intensity" value="Light">Light<br>
				</div>
				
				<div>
				<label for="sex">Sex</label><br>
				<input type="radio" name="sex" value="male">Male<br>
				<input type="radio" name="sex" value="female">Female<br>
				<input type="radio" name="sex" value="other">Other
				</div>
				
				<div>
				<label for="Height">Height</label><br>
				<select id="feet" name="feet">
				<option></option>
				<option value = "3">3</option>
				<option value = "4">4</option>
				<option value = "5">5</option>
				<option value = "6">6</option>
				<option value = "7">7</option>
				<option value = "8">8</option>
				</select>
				
				<select id="inches" name="inches" >
				<option></option>
				<option value = "0">0</option>
				<option value = "1">1</option>
				<option value = "2">2</option>
				<option value = "3">3</option>
				<option value = "4">4</option>
				<option value = "5">5</option>
				<option value = "6">6</option>
				<option value = "7">7</option>
				<option value = "8">8</option>
				<option value = "9">9</option>
				<option value = "10">10</option>
				<option value = "11">11</option>
				<option value = "12">12</option> 
				</select>
				</div>
				</div>
			
		<!--	<div class="time">
				<label for="time">Workout Time Availability</label><br>
				
				<label for "monHour">Monday</label><br>
				<select id=" name="monHour" class>
				<option></option>
				<option value = "1">1</option>
				<option value = "2">2</option>
				<option value = "3">3</option>
				<option value = "4">4</option>
				<option value = "5">5</option>
				<option value = "6">6</option>
				<option value = "7">7</option>
				<option value = "8">8</option>
				<option value = "9">9</option>
				<option value = "10">10</option>
				<option value = "11">11</option>
				<option value = "12">12</option> 
				</select>
				
				<select id=" name="monMinute" class>
				<option></option>
				<option value = "15">15</option>
				<option value = "30">30</option>
				<option value = "45">45</option>
				</select>
				
				<select id=" name="monMinute" class>
				<option></option>
				<option value = "AM">AM</option>
				<option value = "PM">PM</option>
				</select>
				
				<select id=" name="tuesHour" class>
				<option></option>
				<option value = "1">1</option>
				<option value = "2">2</option>
				<option value = "3">3</option>
				<option value = "4">4</option>
				<option value = "5">5</option>
				<option value = "6">6</option>
				<option value = "7">7</option>
				<option value = "8">8</option>
				<option value = "9">9</option>
				<option value = "10">10</option>
				<option value = "11">11</option>
				<option value = "12">12</option> 
				</select>
				
				<select id=" name="tuesMinute" class>
				<option></option>
				<option value = "15">15</option>
				<option value = "30">30</option>
				<option value = "45">45</option>
				</select>
				
				<select id=" name="monMinute" class>
				<option></option>
				<option value = "AM">AM</option>
				<option value = "PM">PM</option>
				</select>
				
			</div> -->
				
				<div class="right-col">
					<div>
					<input type="submit" value="Submit" id="submit" />
					</div>
				</div>
		</div>	
	
	</form>

	</body>
</html>