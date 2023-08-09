<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<h1 align="center">

PROFESSOR DETAILS

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
String sql="select *from professor";
 Statement stmt = con.createStatement();
ResultSet r = stmt.executeQuery(sql);
while(r.next()){
	out.println("<hr>");
	out.println("Professor Id : - "+r.getInt(1)+"<br><br>");
	out.println("Course Id Of Professor : - "+r.getInt(2)+"<br><br>");
	out.println("Professor Name : - "+r.getString(3)+"<br><br>");
	out.println("Professor Expeience : - "+r.getInt(4)+"<br><br>");
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