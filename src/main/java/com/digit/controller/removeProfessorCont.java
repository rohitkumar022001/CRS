package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.model.CourseApp;
import com.digit.model.professorApp;

@WebServlet("/removeProf")
public class removeProfessorCont extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		professorApp p=new professorApp();
		p.setPid(pid);
		boolean b=p.removePro();
		if(b==true) {
			resp.sendRedirect("/CourseManagementM/removeProfessorSucc.jsp");
		}
		else {
			resp.sendRedirect("/CourseManagementM/manageControl.html");
		}
	}
}
