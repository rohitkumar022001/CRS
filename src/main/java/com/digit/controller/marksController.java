package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.gradeApp;

@WebServlet("/marksCon")
public class marksController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid=Integer.parseInt(req.getParameter("sid"));
		int test1_score=Integer.parseInt(req.getParameter("test1_score"));
		int test2_score=Integer.parseInt(req.getParameter("test2_score"));
		int practical_score=Integer.parseInt(req.getParameter("practical_score"));
		gradeApp g=new gradeApp();
		g.setPractical_score(practical_score);
		g.setSid(sid);
		g.setTest1_score(test1_score);
		g.setTest2_score(test2_score);
		HttpSession session=req.getSession();
		session.setAttribute("sid", g.getSid());
		//System.out.println((int)session.getAttribute("sid"));
		boolean b=g.grade();
		if(b==true) {
			resp.sendRedirect("/CourseManagementM/gradeSucc.jsp");
		}
		else {
			resp.sendRedirect("/CourseManagementM/gradeFail.jsp");
		}
	}

}
