<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<div align="center">
<a href="profile.jsp">Profile</a>
<h3>Change Password</h3>
<form action="changePassword.jsp" method="post">
<table>
<tr><td>Current Password</td><td><input type="password" name="current" ></td></tr>
<tr><td>New Password</td><td><input type="password" name="new"></td></tr>
<tr><td>Confirm Password</td><td><input type="password" name="confirm"></td></tr>
<tr><td><input type="submit" value="Change Password"></td><td><input type="reset" value="Reset"></td></tr>
</table>
</form>
</div>
</body>
</html>