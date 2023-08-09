<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Report Card</h1><br><br>
<a href="Logout">Logout</a><br><br>
<p align="right"><a href="menu.jsp">Back To Menu</a></p>
<br><br>
<%
int cid=0;
String pname="";
int test1_score=0;
  int test2_score=0;
  int practical_score=0;
  int final_score=0;
  String grade="";
  String cname="";
  String sname="";
  int sid=0;
try {
	
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/courses";

    String user = "root";

    String pass = "Welcome@123";

    Connection con = DriverManager.getConnection(url, user,pass);
    session=request.getSession();
    sid=(int)session.getAttribute("sid");
   
    /* int cid=0;
    String pname="";
    int test1_score=0;
	  int test2_score=0;
	  int practical_score=0;
	  int final_score=0;
	  String grade="";
	  String cname="";
	  String sname=""; */
    PreparedStatement prep = con.prepareStatement("Select * from grading where sid=?");
   	prep.setInt(1, sid);
       ResultSet r = prep.executeQuery();
       if(r.next()){
    	  test1_score=r.getInt(2);
    	  test2_score=r.getInt(3);
    	  practical_score=r.getInt(4);
    	  final_score=r.getInt(5);
    	  grade=r.getString(6);
    	   
       }
       PreparedStatement prep1 = con.prepareStatement("Select * from student where sid=?");
      	prep1.setInt(1, sid);
          ResultSet r1 = prep1.executeQuery();
          if(r1.next()){
        	
       	  cid=r1.getInt(2);
       	  sname=r1.getString(3);
          }
          PreparedStatement prep2= con.prepareStatement("Select * from professor where c_id=?");
        	prep2.setInt(1, cid);
            ResultSet r2 = prep2.executeQuery();
            if(r2.next()){
         	 pname=r2.getString(3);
            }
            PreparedStatement prep3 = con.prepareStatement("Select * from course where cid=?");
        	prep3.setInt(1, cid);
            ResultSet r3 = prep3.executeQuery();
            if(r3.next()){
         	 cname=r3.getString(2);
            }
            
             out.println("<b>Student Id</b> : "+sid+"<br><br>");
            out.println("<b>Student Name</b> : "+sname+"<br><br>");
            out.println("<b>Professor Assigned</b> : "+pname+"<br><br>");
            out.println("<b>Course Assigned</b> : "+cname+"<br><br>");
            out.println("<b>test1_score</b> : "+test1_score+"<br><br>");
            out.println("<b>test2_score</b> : "+test2_score+"<br><br>");
            out.println("<b>practical_score</b> : "+practical_score+"<br><br>");
            out.println("<b>final_score</b> : "+final_score+"<br><br>");
            out.println("<b>Grade</b> : "+grade+"<br><br>");
             
}
catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>