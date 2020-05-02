<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<div align="center">
<h1>Home</h1>
	<tag:forEach var="post" items="${allPosts}">
	
		<jsp:include page="./posts/post.jsp" >
    		<jsp:param name="content" value="${post.getContent()}"/>
   			<jsp:param name="date" value="${post.getDate()}"/>
			<jsp:param name="email" value="${post.getEmail()}"/>
			<jsp:param name="id" value="${post.getId()}"/>
		</jsp:include> 
	
	</tag:forEach>
</div>
</body>
</html>