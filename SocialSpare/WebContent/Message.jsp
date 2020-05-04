<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
<%@ page import="com.model.*" %>
    
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
<title>Insert title here</title>
</head>
<body>

<div class="sendMessage">
	<h1>Send a Message</h1>
	<form action="Message" method="post">
		<textarea name="message" rows="8" cols="80"></textarea>
		<input type="submit" name="send" value="Send Message">
	</form>
</div>
</body>
</html>