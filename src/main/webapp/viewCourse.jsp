<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">

COURSE DETAILS

</h1>
<br><br>
<a href="menu.jsp">Back to Menu</a>
<br>
	<%
try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/courses";

    String user = "root";

    String pass = "Welcome@123";

    

    Connection con = DriverManager.getConnection(url, user,pass);
String sql="select *from course";
 Statement stmt = con.createStatement();
ResultSet r = stmt.executeQuery(sql);
while(r.next()){
	out.println("<hr>");
	out.println("Course Id : - "+r.getInt(1)+"<br><br>");
	out.println("Course  : - "+r.getString(2)+"<br><br>");
	out.println("Fee : - "+r.getInt(3)+"<br><br>");
	out.println("Duration : - "+r.getInt(4)+"<br><br>");
	//out.println("<br><br>");
	
}
out.println("<hr>");
}
	catch(Exception e){

	    e.printStackTrace();

	}

%>


</body>
</html>