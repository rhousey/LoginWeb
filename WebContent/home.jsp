<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body> 
<%String username = (String)session.getAttribute("username");%>
<body> 
<br>
<br>
<center><h2>
	Welcome ${username}</h2></center> <br><br>	
	<table align = "center"><tr><td>${msg}</td>
	<td></td></tr><tr><td>
	<a href = "resetPassForm.jsp">Reset Your Password</a>
			<tr><td> 
			<form action = "logout">
			<input type = "submit" value = "logout">
			</form>
			</td></tr>
		</table>
</body>
</html>