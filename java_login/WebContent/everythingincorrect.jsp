<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body BGCOLOR="rgb(24,156,89)">
<h1>USER AUTHENTICATION SYSTEM</h1>
<p>Message: ${message}</p>
<form action="MainF" method="post">
	username:  <input type="text" name="username" style="background-color:Red"><br>
	password: <input type = "password" name="password"  style="background-color:Red"><br>
	usercode: <input type = "text" name="usercode"  style="background-color:Red"><br>
	<input type="submit" value="submit">
	</form>
</body>
</html>