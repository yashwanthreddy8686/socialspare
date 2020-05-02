<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Spark</title>
</head>
<body>
<div align="center"><h1>Social Spark</h1></div><br><br><br><br>
     <fieldset>
		<legend>Login</legend>
		<div align="center">
		<form action="Login" method="POST">
			<input type="email" name="email" placeholder="Enter your Email">
			<br><br>
			<input type="password" name="pass" placeholder="Enter your Password">
			<br><br>
			<button type="submit">Login</button>
			<button type="reset">Reset</button>
			<a href="register.jsp">Register</a>
			<tag:if test="${loginError}">
					<br>
					<span> incorrect email or password </span>	
			</tag:if>
        </form>
        </div>
	</fieldset>
</body>
</html>