<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>

<h1>Home</h1>
<a href="Profile">Profile</a>
	<tag:forEach var="post" items= "${allPosts}">
		<span>${post.getEmail()}</span><br>
		<span>${post.getContent()}</span><br>
		<span>${post.getPostDate()}</span><br>
		 <img src="data:image/jpg;base64,${post.getImage()}" width="240" height="300"/>
		 <form action="PostOperations" method="post">
		 			<button type="submit" value="${post.getId()}" name="like">Like</button>
					<span>${post.getLikes()}</span>
				<tag:if test="${liked}">
					<button type="submit" value="${post.getId()}" name="unlike">UnLike</button>
					<span>${post.getLikes()}</span>
				</tag:if>
					<button type="submit" value="${post.getId()}" name="save">Save</button>
				<tag:if test="${saved}">
					<span>Saved Successfully}</span>
				</tag:if>
				</form>

	</tag:forEach>
</body>
</html>