<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script>
function validate(){ 
	var email = document.form.email.value; 
	var username = document.form.username.value; 
	if(email == null || email == ""){ 
		alert("Email Required"); 
	return false; 
	
} 
else if(username == null || username == "")                        
	{                  
	alert("Username Required"); 
	return false;
}
}
</script>
</head>
<body>
	<center>
		<h2>Request a Temporary Password</h2>
	</center>
	<form name= "form" action="recoverPassServlet" method= "post"
		onsubmit="return validate()"> 
		<table align="center">
			<tr> 
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			 <tr> 
				<td><span style="color: red"><%= (request.getAttribute("errMessage") == null) ? ""
		:request.getAttribute("errMessage")%></span></td>
			</tr>
			<tr>
			<td></td>
				<td><input type="submit" value="Reset"></input><input
					type="reset" value="Reset"></input></td>
			</tr>
					</table>
					</form>
					<a href = "login.jsp" >Login</a>
<%-- <img src="${pageContext.servletContext.contextPath}/resources/back-arrow-1767531-1502435.png" alt=""/> --%>
</body>
</html>