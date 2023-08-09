<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Student</title>
</head>
<body>
	<form action="regStudent" method="post">
		<label>Register Student</label> <br>
		<br> <label>Enter User Name</label> <br>
		<br> <input type="text" name="user_name"> <br>
		<br> <label>Enter Student Id</label> <br>
		<br> <input type="text" name="sid"> <br>
		<br> <label>Enter Course Id</label> <br>
		<br> <input type="text" name="cid"> <br>
		<br> <label>Student Name</label> <br>
		<br> <input type="text" name="sname"> <br>
		<br> <label>Email</label> <br>
		<br> <input type="text" name="email"> <br>
		<br> <label>Password</label><br>
		<br> <input type="text" name="password"> <br>
		<br> <input type="submit" name="Register">
	</form>
<p align="center">
	<%
	String cname="";
	int cid=0;
	Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/courses";

    String user = "root";

    String pass = "Welcome@123";

    Connection con = DriverManager.getConnection(url, user,pass);
    PreparedStatement prep3 = con.prepareStatement("Select * from course");
    ResultSet r3 = prep3.executeQuery();
    while(r3.next()){
 	 cid=r3.getInt(1);
 	cname=r3.getString(2);
 	out.println("<b>Course Id</b> : "+cid+"<br><br>");
 	out.println("<b>Course Name</b> : "+cname+"<br><br>");
 	
    }
	%>
	</p>
</body>
</html>