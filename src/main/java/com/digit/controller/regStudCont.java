package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.studentApp;

@WebServlet("/regStudent")
public class regStudCont extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name = req.getParameter("user_name");
		String password = req.getParameter("password");
		int sid = Integer.parseInt(req.getParameter("sid"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		String sname = req.getParameter("sname");
		String email = req.getParameter("email");
		studentApp s = new studentApp();
		s.setPassword(password);
		s.setUser_name(user_name);
		s.setCourse_id(cid);
		s.setEmail(email);	
		s.setSid(sid);
		s.setSname(sname);
		HttpSession session = req.getSession();
		session.setAttribute("cid", s.getCourse_id());
		session.setAttribute("email", s.getEmail());
		session.setAttribute("sname", s.getSname());
		session.setAttribute("sid", s.getSid());
		boolean b = s.register();
		if (b == true) {
			resp.sendRedirect("/CourseManagementM/studentAdded.html");
		} else {
			resp.sendRedirect("/CourseManagementM/menu.jsp");
		}

	}

}
