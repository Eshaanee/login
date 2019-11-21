<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Correct username page</title>
</head>
<body BGCOLOR="RGB(23,150,198)">
<h1>USER AUTHENTICATION SYSTEM</h1>
<p>Message: ${message}</p>
<form action="MainF" method="post">
	username:  <input type="text"  name="username" value= "${username}" style="background-color:Green"><br>
	password: <input type = "password" name="password" style="background-color:Red"><br>
	usercode: <input type = "text" name="usercode" style="background-color:Red"><br>
	<input type="submit" value="submit">
	</form>
</body>
</html>