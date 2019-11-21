<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Authentication System</title>
</head>
<body BGCOLOR="RGB(245,156,23)">
<p>Message: ${message}</p>
<form action="MainF" method="post">
	username:  <input type="text"  name="username"  style="background-color:Red"><br>
	password: <input type = "password" name="password"><br>
	usercode: <input type = "text" name="usercode"><br>
	<input type="submit" value="submit">
	</form>
</body>
</html>