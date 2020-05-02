<span>${param.date}</span> <br>
<span>${param.content}</span> <br>
<span>${param.email}</span><br>

<form action="PostOperations">
    <button name="delete" value="${param.id} ">Delete</button>
	<button name="edit" value="${param.id} ">Edit</button>
	<button name="like" value="${param.id} ">Like</button>
</form>

 <br><br><br>