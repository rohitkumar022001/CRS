//package com.digit.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.digit.model.studentApp;
//
//@WebServlet("/show")
//public class showMarksController extends HttpServlet{
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int sid=Integer.parseInt(req.getParameter("sid"));
//		studentApp s=new studentApp();
//		s.setSid(sid);
//		HttpSession session=req.getSession();
//		session.setAttribute("sid",s.getSid());
//		boolean b=s.showMarks();
//		if(b==true) {
//			resp.sendRedirect("/CourseManagementM/showMarks.jsp");
//		}
//	}
//
//}
