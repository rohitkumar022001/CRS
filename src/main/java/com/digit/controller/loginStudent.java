package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.studentApp;

@WebServlet("/loginStudent")
public class loginStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name=req.getParameter("user_name");
		String password=req.getParameter("password");
		int sid=Integer.parseInt(req.getParameter("sid"));
		studentApp s=new studentApp();
		s.setUser_name(user_name);
		s.setPassword(password);
		s.setSid(sid);
		HttpSession session=req.getSession();
		session.setAttribute("sid", sid);
		boolean b=s.loginstud();
		if(b==true) {
			resp.sendRedirect("/CourseManagementM/loginStudSucc.jsp");
		}
		else {
			resp.sendRedirect("/CourseManagementM/loginStudFail.jsp");
		}
		
	}

}
