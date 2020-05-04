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
<title>Profile</title>
</head>
<body>


	<h1>Profile</h1>
	
	<h2> ${user.getFname()} ${user.getLname()}<br></h2>
	<h2> ${user.getEmail()}<br></h2>
	<br><br>
	
	
	<a href="Home">Home</a>
	<div class="main-grid">
	
	<form action="CreatePost" method="POST" class ="profile-form" enctype="multipart/form-data" >
		<h2 class="sub-heading">Create Post</h2>
		<br>
		<textarea name="content" placeholder="What's On Your Mind ?"></textarea>
		<input type="file" name="image" size="50"><br><br>
		
		<button type="submit" name= "createPost">Create</button>
		<button type="reset">Clear</button>
		<br>
		<br>
		<tag:if test="${created}">
			<span class ="error">Post Successfully Created</span>
		</tag:if>
		<tag:if test="${notcreated}">
			<span class ="error">Post cannot be Created</span>
		</tag:if>
	</form>
	
	<div class="posts">
	 
	<tag:forEach var="posts" items= "${allUserPosts}">
		<div class="userposts">
		
		<span>${posts.getEmail()}</span><br>
		<span>${posts.getContent()}</span><br>
		<span>${posts.getPostDate()}</span><br>
		 <img src="data:image/jpg;base64,${post.getImage()}" width="240" height="300"/>
		<form action="PostOperations" method="post">
					<button type="submit" value="${posts.getId()}" name="like">Like</button>
					<span>${posts.getLikes()}</span>
				<tag:if test="${liked}">
					<button type="submit" value="${posts.getId()}" name="unlike">UnLike</button>
					<span>${posts.getLikes()}</span>
				</tag:if>
					<button type="submit" value="${posts.getId()}" name="edit">Edit</button>
					<button type="submit" value="${posts.getId()}" name="save">Save</button>
					<button type="submit" value="${posts.getId()}" name="delete">Delete</button>
				</form>
		</div>
	</tag:forEach>
	
	
	</div>
	
    </div>
	<br>
	<br>
	
	<div class="friends">
		<h1>Friends List</h1>
		<tag:forEach var="friends" items="${allUserFriends}">
			<div class="friend">
				<h2>${friends.getEmail()}</h2>
				<form action="FriendOperation" method="get">
					<button type="submit" value="${friends.getEmail()}" name="view">View</button>
					<button type="submit" value="${friends.getEmail()}" name="message">Message</button>
					<button type="submit" value="${friends.getEmail()}" name="unfriend">UnFriend</button>
				</form>
			</div>
		</tag:forEach>
	</div>
	<div class="logout">
		<input type="submit" value="${user.getEmail()}" name="logout">
	
	</div>

</body>
</html>