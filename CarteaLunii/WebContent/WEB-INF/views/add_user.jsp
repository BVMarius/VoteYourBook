<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.dao.LocationDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/styles.css" />
</head>
<body>
	<div class="register-welcome">Welcome to IBM BookClub</div>
	<form action="AddUser" method="post">

		<h2>Sign Up</h2>
		<p>
			<label for="firstName" class="floatLabel">First Name</label> <input id="First"
				name="firstName" type="text">
		</p>
		<p>
			<label for="lastName" class="floatLabel">Last Name</label> <input id="Name"
				name="lastName" type="text">
		</p>
		<p>
			<label for="Email" class="floatLabel">Email</label> <input id="Email"
				name="email" type="text">
		</p>
		<p>
			<label for="password" class="floatLabel">Password</label> <input
				id="password" name="password" type="password">
			<legend>Enter a password longer than 8 characters</legend>
		</p>
		<p>
			<label for="confirm_password" class="floatLabel">Confirm
				Password</label> <input id="confirm_password" name="confirm_password"
				type="password">
			<legend>Your passwords do not match</legend>
		</p>
		<p>
		Your current location: <select name="town">
		

	
		<%
		for(Map.Entry<Integer,String> entry:LocationDAO.retriveAvailableLocations().entrySet())	{
			out.println(String.format("<option value=%d>%s</option>", entry.getKey(),entry.getValue()));
			
		}
		
		%>
			</select>
		<p>
			<input type="submit" value="Create My Account" id="submit">
		</p>

	</form>



	</div>

</body>
</html>