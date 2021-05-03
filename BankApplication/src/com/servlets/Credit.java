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

public class Credit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Credit() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Customer customer = new Customer();
		customer.setAccountNumber(Long.parseLong(request.getParameter("accountnumber")));
		try {
			Customer c = Solutions.getParams(customer);
			out.print("<head>");
			out.print("<script>\r\n" + "function add(){\r\n" + "var a,b,c;\r\n"
					+ "a=Number(document.getElementById(\"first\").value);\r\n"
					+ "b=Number(document.getElementById(\"second\").value);\r\n" + "c= a + b;\r\n"
					+ "document.getElementById(\"answer\").value= c;\r\n" + "}\r\n" + "</script>");
			out.print("</head>");
			out.println("<body>");
			out.print("<form action='CreditBalance' method='post'>");
			out.print("<label for='account'>Account Number</label><br>");
			out.print("<input type='number' id='account' name='accountnumber' value="
					+ Long.parseLong(request.getParameter("accountnumber")) + " ><br>");
			out.print("<label for='account'>Account Balance</label><br>");
			out.print("<input type='number' id='first' name='accountnumber' value=" + c.getBalance() + " ><br>");
			out.print("<label for='account'>Amount Debited</label><br>");
			out.print("<input type='number' id='second' name='debit' ><br>");
			out.print("<label for='account'>Amount Final</label><br>");
			out.print("<input type='number' id='answer' name='final'><br><br>");
			out.print("<button onclick='add()'>Submit</button>");
			out.print("</form>");
			out.print("</table>");
			out.println("</body>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
