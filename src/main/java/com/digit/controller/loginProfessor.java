package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.professorApp;
import com.digit.model.studentApp;

@WebServlet("/loginProfessor")
public class loginProfessor extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name=req.getParameter("user_name");
		String password=req.getParameter("password");
		int pid=Integer.parseInt(req.getParameter("pid"));
		professorApp p=new professorApp();
		p.setUser_name(user_name);
		p.setPassword(password);
		p.setPid(pid);
		HttpSession session=req.getSession();
		session.setAttribute("pid", pid);
		boolean b=p.loginprof();
		if(b==true) {
			resp.sendRedirect("/CourseManagementM/loginProfessorSucc.jsp");
		}
		else {
			resp.sendRedirect("/CourseManagementM/loginProfessorFail.jsp");
		}
	}
	
}
