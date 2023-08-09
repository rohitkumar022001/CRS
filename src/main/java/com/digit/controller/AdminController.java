package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.model.CourseApp;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String user_name = req.getParameter("user_name");

		String password = req.getParameter("password");

		CourseApp c = new CourseApp();

		c.setUser_name(user_name);

		c.setPassword(password);

		boolean b = c.admin();

		if (b == true) {

			res.sendRedirect("/CourseManagementM/menu.jsp");

		}
		else {
			res.sendRedirect("/CourseManagementM/Admin.html");
		}
	}

}
