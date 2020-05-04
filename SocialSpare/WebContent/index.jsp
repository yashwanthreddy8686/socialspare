<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SocialSpark</title>
<style type="text/css">
   *{
   margin:0;
   padding:0;
   }
   body{
   		font_family:sans-serif;
   }
  .regform{
  			width:800px;
  			background-color:rgb(0,0,0,0.6);
  			margin:auto;
  			color:#FFFFFF;
  			padding:10px,0px,10px,0px;
  			text-align:center;
  			border-radius:15px 15px 0px 0px;
 		 }
	.main{
		  background-color:rgb(0,0,0,0.5);
		  width:800px;
	      margin:auto;
	     }
	   form{
	   		padding:10px;
	   }  
#name{
	  width:100%;
	  height:100px;
     }
 .name{
 	 margin-left:25px;
 	 margin-top:30px;
 	 width:125px;
 	 color:white;
 	 font-size:18px;
 	 font-weight:700;  
      }   
.firstname{
		   position:relative;
		   left:200px;
		   top:-37px;
		   line-height:40px;
		   border-radius:6px:
		   padding:0 22px;
		   font-size:16px;
          }
 .lastname{
            position:relative;
		   left:417px;
		   top:-80px;
		   line-height:40px;
		   border-radius:6px:
		   padding:0 22px;
		   font-size:16px;
 		   color:#555;
          }         
  .firstlabel{
              position:relative;
              color:#E5E5E5;
              text-tronsform:capitalize;
              font-size:14px;
		      left:203px;
		      top:-45px; 
             } 
   .lastlabel{
              position:relative;
              color:#E5E5E5;
              text-tronsform:capitalize;
              font-size:14px;
		      left:490px;
		      top:-75px; 
              }          
    .email{
            position:relative;
            color:#555;
            line-height:40px;
            width:270px;
            border-radius: 6px;
            padding: 0 20px
            font-size:16px;
		    left:200px;
		    top:-37px; 
           }      
     .password{
            position:relative;
            color:#555;
            line-height:40px;
            width:270px;
            border-radius: 6px;
            padding: 0 20px
            font-size:16px;
		    left:200px;
		    top:-37px; 
           }     
      .button1{
      		 background-color:#3BAF9F;
      		 display:block;
      		 margin:20px 0px 0px 20px;
      		 text-align:center;
      		 border:2px solod #366473;
      		 padding:14px 110px;
      		 outline:none;
      		 color:white;
      		 cursor:pointer;
      		 transition:0.25px;
      		 }     
                          
</style>
</head>
<body>
	
	<h1>Social Spark</h1>
	<fieldset>
	<legend>Login</legend>
	<form action="Login" method="post" >
		Email ID<input type = "text" name="email" placeholder="ENTER EMAIL"><br>
		password<input type = "password" name="pass" placeholder="ENTER PASSWORD"><br>
		<a href="Home"><button type = "submit" value = "login">Login</button></a>
		<button type = "reset">Reset</button>
		<tag:if test="${loginerror}">
		<span>Incorrect User name or Password</span>
		</tag:if>
	</form>
	</fieldset>
	<div class="regform"><h1>Create a New Account </h1></div>
	<div class ="main">
	  <form action="Register" method="post">
		 <div id="name">
		  <h2 class="name">Name</h2>
		  <input class="firstname" type="text" name="first_name"><br>
		  <label class="firstlabel">First Name</label>
		  <input class="lastname" type="text" name="last_name"><br>
		  <label class="lastlabel">Last Name</label>
		 </div>
		 
		  <h2 class="name">Email</h2>
		  <input class="email" type="text" name="email_id"><br>
		  <h2 class="name">Password</h2>
		  <input class="password" type="password" name="passwd"><br>
		  <button class="button1" type="submit">Register</button>
		  <tag:if test="${registererror}">
		  <span>User Already In Use</span>
		  </tag:if>
		  <tag:if test="${registersuccess}">
		  <span>Account Created</span>
		  </tag:if>
		 
	  </form>
	</div>
</body>
</html>