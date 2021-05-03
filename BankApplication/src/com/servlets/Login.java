package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Solutions;
import com.model.Customer;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Customer customer = new Customer();
		Long accNum = Long.parseLong(request.getParameter("accountnumber"));
		String pass = request.getParameter("password");
		customer.setAccountNumber(accNum);
		customer.setPassword(pass);
		try {
			if (Solutions.validate(customer)) {
				HttpSession session = request.getSession();
				session.setAttribute("accountnumber", accNum);
				session.setAttribute("password", pass);
				request.getRequestDispatcher("customer.html").include(request, response);
			} else {
				out.print("Invalid Credentials.. Please try again!..");
				request.getRequestDispatcher("login.html").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
