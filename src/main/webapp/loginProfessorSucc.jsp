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
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Login Successful</h1><br><br>
<a href="Logout">Logout</a><br><br>
<form action="marksCon" Method="post">
<h2>Grade Student</h2><br>
<label>Enter Student Id</label><br><br>
<input type="text" name="sid"><br><br>
<label>Enter Test1 Score</label><br><br>
<input type="text" name="test1_score"><br><br>
<label>Enter Test2 Score</label><br><br>
<input type="text" name="test2_score"><br><br>
<label>Enter Practical Score</label><br><br>
<input type="text" name="practical_score"><br><br>
<input type="submit" value="grade">
</form>
<p align="center">
<%

int pid=0;

  String cname="";
  int sid=0;
  int cid=0;
  String sname="";
try {
	
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/courses";

    String user = "root";

    String pass = "Welcome@123";

    Connection con = DriverManager.getConnection(url, user,pass);
    session=request.getSession();
    pid=(int)session.getAttribute("pid");
   
    /* int cid=0;
    String pname="";
    int test1_score=0;
	  int test2_score=0;
	  int practical_score=0;
	  int final_score=0;
	  String grade="";
	  String cname="";
	  String sname=""; */
   
          PreparedStatement prep2= con.prepareStatement("Select * from professor where pid=?");
        	prep2.setInt(1, pid);
            ResultSet r2 = prep2.executeQuery();
            if(r2.next()){
    
         	 cid=r2.getInt(2);
            }
            PreparedStatement prep3 = con.prepareStatement("Select * from course where cid=?");
        	prep3.setInt(1, cid);
            ResultSet r3 = prep3.executeQuery();
            if(r3.next()){
         	 cname=r3.getString(2);
            }
            out.println("<b>Course Id</b> : "+cid+"<br><br>");
            out.println("<b>Course Assigned</b> : "+cname+"<br><br>");
            PreparedStatement prep1 = con.prepareStatement("Select * from student where cid=?");
          	prep1.setInt(1, cid);
              ResultSet r1 = prep1.executeQuery();
              while(r1.next()){
            	
           	  sid=r1.getInt(1);
           	  sname=r1.getString(3);
           	out.println("<hr>");
           	  out.println("<b>Student Id</b> : "+sid+"<br><br>");
              out.println("<b>Student Name</b> : "+sname+"<br><br>");
              
              }
            
           
          
           
             
}
catch(Exception e){
	e.printStackTrace();
}


%>
</p>
</body>
</html>