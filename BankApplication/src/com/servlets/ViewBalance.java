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

public class ViewBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewBalance() {
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
		customer.setAccountNumber(Long.parseLong(request.getParameter("accountnumber")));
		try {
			if (Solutions.viewBalance(customer) != null) {
				out.print("<h4>Balance Status</h4>");
				out.print("<table border='1' width='25%'");
				out.print("<tr><th>Account Number</th><th>Balance</th></tr>");
				out.print("<tr><td>" + Long.parseLong(request.getParameter("accountnumber")) + "</td><td>"
						+ Solutions.viewBalance(customer) + "</td></tr>");
				out.print("<a href='customer.html'>Bank Customers Tasks</a>");
			} else {
				out.print("Acount doesnt exists!");
				request.getRequestDispatcher("checkbalance.html").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
