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

public class CreditBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreditBalance() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Customer customer = new Customer();
		customer.setAccountNumber(Long.parseLong(request.getParameter("accountnumber")));
		customer.setBalance(Long.parseLong(request.getParameter("final")));
		try {
			if (Solutions.getDebitOrCredit(customer) > 0) {
				Customer c = Solutions.getParams(customer);
				out.print("Balance after debit");
				out.print("<br>");
				out.print("<table border='1' width='25%'");
				out.print("<tr><th>Account Holder</th><th>Account Number</th><th>Balance</th></tr>");
				out.print("<tr><td>" + c.getName() + "</td><td>" + Long.parseLong(request.getParameter("accountnumber"))
						+ "</td><td>" + c.getBalance() + "</td></tr>");
				out.print("<a href='customer.html'>Back</a>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
