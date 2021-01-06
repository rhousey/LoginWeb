<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String username = (String)session.getAttribute("username");
String password = (String)session.getAttribute("password"); 
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script>
function validate(){ 
	var newPass = document.form.newPass.value; 
	var confirmPass = document.form.confirmPass.value; 

	 if(newPass == null || newPass == ""){ 
		alert("New Password Required"); 
	return false; 
	
	}
	else if(confirmPass == null || confirmPass == ""){ 
		alert("Confirm New Password"); 
	return false; 
	}
	else if(!confirmPass.equals(newPass)){
		alert("New password does not match the confirmation."); 
		return false; 
	}
	
	else if(password.length<6)
    { 
	     alert("Password must be at least 6 characters long."); 
	     return false;
}
}
</script>
</head>
<body>
	<center>
		<h2>Reset Password</h2>
	</center>
	<form name= "form" action="resetPassServlet" method= "post"
		onsubmit="return validate()">
		<table align="center">
		<tr> <td>Username: 
		<td>${username}</td>
			<td><input type = "hidden" name = "username" value = "${username}" /></td>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="newPass" /></td>
			</tr>
			<tr>
				<td>Confirm New Password:</td>
				<td><input type="password" name="confirmPass" /></td>
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
	</body>
</html>