package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.model.CourseApp;
import com.digit.model.studentApp;
@WebServlet("/removeCourse")
public class removeCourseCont extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid=Integer.parseInt(req.getParameter("cid"));
		CourseApp c=new CourseApp();
		c.setCid(cid);
		boolean b=c.removec();
		if(b==true) {
			resp.sendRedirect("/CourseManagementM/removeCourseSucc.jsp");
		}
		else {
			resp.sendRedirect("/CourseManagementM/manageControl.html");
		}
		
	}

}
