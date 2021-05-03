package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Solutions;
import com.model.Customer;

public class AllCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllCustomers() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<a href='admin.html'>Back</a>");
		try {
			List<Customer> list = Solutions.getAllCustomers();
			out.print("<table border='1' width='100%'");
			out.print(
					"<tr><th>Customer Id</th><th>Customer Name</th><th>Address</th><th>Account Number</th><th>Email</th><th>Mobile Number</th><th>Account Balance</th></tr>");
			for (Customer c : list) {

				out.print("<tr><td>" + c.getId() + "</td><td>" + c.getName() + "</td><td>" + c.getAddress()
						+ "</td><td>" + c.getAccountNumber() + "</td><td>" + c.getEmail() + "</td><td>"
						+ c.getMobileNumber() + "</td><td>" + c.getBalance());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
