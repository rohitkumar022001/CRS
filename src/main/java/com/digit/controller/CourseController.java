package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.CourseApp;

@WebServlet("/addcourse")
public class CourseController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid=Integer.parseInt(req.getParameter("cid"));
		String cname=(req.getParameter("cname"));
		int fees=Integer.parseInt(req.getParameter("fees"));
		int dur_months=Integer.parseInt(req.getParameter("dur_months"));
		CourseApp c=new CourseApp();
		c.setCid(cid);
		c.setCname(cname);
		c.setDur_months(dur_months);
		c.setFees(fees);
		HttpSession session=req.getSession(true);
		session.setAttribute("cid",c.getCid());
		session.setAttribute("cname", c.getCname());
		session.setAttribute("fees", c.getFees());
		session.setAttribute("dur_months",c.getDur_months());
		boolean b=c.course();
		if(b==true) {
			resp.sendRedirect("/CourseManagementM/courseAdded.html");
		}
		else {
			resp.sendRedirect("/CourseManagementM/courseAddedFail.html");
		}
	}

}
