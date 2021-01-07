<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>"sf"</title>
<script>
function validate(){ 
	var username = document.form.username.value; 
	var password = document.form.password.value; 
	if(username == null || username == ""){ 
		alert("Username cannot be blank"); 
	return false; 
} 
else if(password == null || password == "")                        
	{                  
	alert("Password cannot be blank"); 
	return false;
}
}</script>
</head>
<h2>User Login</h2>

<body>
	<form method="post" action="LoginServlet">
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><span style="color: red"><%= (request.getAttribute("errMessage") == null) ? ""
		:request.getAttribute("errMessage")%></span></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="login"></input>
		</table>
		</form>
		<a href="recoverPass.jsp">I forgot my password</a>
	
</body>
</html>