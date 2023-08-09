package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.professorApp;

@WebServlet("/regProfessor")
public class regProfCont extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name = req.getParameter("user_name");
		String password = req.getParameter("password");
		int pid = Integer.parseInt(req.getParameter("pid"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		String pname = req.getParameter("pname");
		int exp = Integer.parseInt(req.getParameter("exp"));
		professorApp p = new professorApp();
		p.setPassword(password);
		p.setUser_name(user_name);
		p.setCid(cid);
		p.setExp(exp);
		p.setPid(pid);
		p.setPname(pname);
		HttpSession session = req.getSession();
		session.setAttribute("cid", p.getCid());
		session.setAttribute("exp", p.getExp());
		session.setAttribute("pname", p.getPname());
		session.setAttribute("pid", p.getPid());
		boolean b = p.register();
		if (b == true) {
			resp.sendRedirect("/CourseManagementM/professorAdded.jsp");
		} else {
			resp.sendRedirect("/CourseManagementM/menu.jsp");
		}
	}

}
