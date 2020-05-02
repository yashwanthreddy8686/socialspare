<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%
String currentPassword=request.getParameter("current");
String Newpass=request.getParameter("new");
String conpass=request.getParameter("confirm");
String connurl = "jdbc:mysql://localhost:3306/social-spark";
Connection con=null;
String pass="";
String email="";
try{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(connurl, "root", "abc123...");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from user where pass='"+currentPassword+"'");
while(rs.next()){
email=rs.getString(1);
pass=rs.getString(4);
} System.out.println(email+ " "+pass);
if(pass.equals(currentPassword)){
Statement st1=con.createStatement();
int i=st1.executeUpdate("update user set pass='"+Newpass+"' where email='"+email+"'");
out.println("Password changed successfully");
st1.close();
con.close();
}
else{
out.println("Invalid Current Password");
}
}
catch(Exception e){
out.println(e);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<br><a href="profile.jsp">Profile</a>
</body>
</html>
