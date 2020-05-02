<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.*" %>
    
<%
    User user = (User) session.getAttribute("user");

	if(user == null){
		response.sendRedirect("index.jsp");
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Profile</title>
</head>
<body>
<div align="center">
<h1>Profile</h1>
	
	<h2> ${user.getFname()} ${user.getLname()}<br></h2>
	<h2> ${user.getEmail()}<br></h2>
	<br><br>
	
	<div class="nav">
	<a href="Home">Home</a>
	<a href="addFriend.jsp">Friends</a>
	<a href="passwordChange.jsp">Change Password</a>
	<a href="DeleteAccount">Delete Account</a>
	<a href="logout.jsp">Logout</a>
	</div>
	
	<form action="CreatePost" method="POST">
	    <br><br><textarea name="content"></textarea><br><br>
		<input type="file" name="image"><br><br>
		<button type="submit">Create</button>
		<button type="reset">Clear</button>
	</form>
</div>
</body>
</html>