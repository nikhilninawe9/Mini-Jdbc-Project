package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Solutions;
import com.model.Admin;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLogin() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Admin admin = new Admin();
		admin.setAdminUsername(request.getParameter("adminusername"));
		admin.setAdminPassword(request.getParameter("adminpassword"));
		try {
			if (Solutions.adminValidation(admin)) {
				out.print(request.getParameter("adminusername") + " You have Logged in!...");
				request.getRequestDispatcher("admin.html").include(request, response);
			} else {
				out.print("Invalid Credentials");
				request.getRequestDispatcher("adminlogin.html").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
