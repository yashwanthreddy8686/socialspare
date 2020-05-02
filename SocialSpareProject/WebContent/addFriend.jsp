<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Friend</title>
</head>
<body>
<div align="center">
<h1>Add New Friend</h1>  
<form action="Friend" method="post">  
<table>  
<tr><td>Email:</td><td><input type="email" name="friend_email"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Add Friend"/></td></tr>  
</table>  
</form>  
  
<br/>  
<a href="ViewFriends">View Friends</a>
</div>
</body>
</html>