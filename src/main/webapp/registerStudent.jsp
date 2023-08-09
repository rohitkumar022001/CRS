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
<link rel="stylesheet" href="resource/assets/css/style6.css">
</head>
<body>
	<!-- <form action="regStudent" method="post">
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
	</form>  -->
	 <section>
		<div class="form-box">
			<div class="form-value">
				<form action="regStudent" method="post">
					<h2>Register Student</h2>
					<div class="inputbox">
						<input type="text" name="user_name" required>
						<label for="">Username</label>
					</div>
					<div class="inputbox">
						<input type="text" name="sid" required>
						<label for="">Student Id</label>
					</div>
					<div class="inputbox">
						<input type="text" name="cid" required>
						<label for="">Course Id</label>
					</div>
					<div class="inputbox">
						<input type="text" name="sname" required>
						<label for="">Student Name</label>
					</div>
					<div class="inputbox">
						<input type="text" name="email" required>
						<label for="">Email</label>
					</div>
					<div class="inputbox">
						<ion-icon name="lock-closed-outline"></ion-icon>
						<input type="text" name="password" required>
						<label for="">Password</label>
					</div>
					
					<input class="login" type="submit" value="Register">
					</form>
					
			</div>
		</div>
	</section>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script> 
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