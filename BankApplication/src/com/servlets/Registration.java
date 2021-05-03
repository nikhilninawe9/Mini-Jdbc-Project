package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Solutions;
import com.model.Customer;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registration() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		customer.setAccountNumber(Long.parseLong(request.getParameter("accountnumber")));
		customer.setEmail(request.getParameter("email"));
		customer.setMobileNumber(Long.parseLong(request.getParameter("mobile")));
		customer.setPassword(request.getParameter("password"));
		try {
			if (Solutions.addCustomer(customer)) {
				out.print("Customer added successfully");
				request.getRequestDispatcher("index.html").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
