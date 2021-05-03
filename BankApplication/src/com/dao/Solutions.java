package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Admin;
import com.model.Customer;
import com.util.DbConnection;

public class Solutions {
//	public static boolean addCustomer(Customer customer) throws SQLException {
//		boolean flag = false;
//		Connection con = DbConnection.getConnection();
//		String sql = "insert into customers(name,address,account_number,email,mobile_number,password) values (?,?,?,?,?,?)";
//		PreparedStatement preparedStatement = con.prepareStatement(sql);
//		preparedStatement.setString(1, customer.getName());
//		preparedStatement.setString(2, customer.getAddress());
//		preparedStatement.setLong(3, customer.getAccountNumber());
//		preparedStatement.setString(4, customer.getEmail());
//		preparedStatement.setLong(5, customer.getMobileNumber());
//		preparedStatement.setString(6, customer.getPassword());
//		preparedStatement.executeUpdate();
//		flag = true;
//		con.close();
//		return flag;
//	}

	public static boolean addCustomer(Customer customer) throws SQLException {
		boolean flag = false;
		Connection con = DbConnection.getConnection();
		String sql = "insert into customers(name,address,account_number,email,mobile_number,password,balance) values (?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, customer.getName());
		preparedStatement.setString(2, customer.getAddress());
		preparedStatement.setLong(3, customer.getAccountNumber());
		preparedStatement.setString(4, customer.getEmail());
		preparedStatement.setLong(5, customer.getMobileNumber());
		preparedStatement.setString(6, customer.getPassword());
		preparedStatement.setLong(7, 200000);
		preparedStatement.executeUpdate();
		flag = true;
		con.close();
		return flag;
	}

	public static boolean validate(Customer customer) throws SQLException {
		boolean status = false;
		Connection con = DbConnection.getConnection();
		String sql = "select * from customers where account_number=? and password=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setLong(1, customer.getAccountNumber());
		preparedStatement.setString(2, customer.getPassword());
		ResultSet re = preparedStatement.executeQuery();
		while (re.next()) {
			status = true;
		}
		con.close();
		return status;
	}

	public static boolean adminValidation(Admin admin) throws SQLException {
		boolean status = false;
		Connection con = DbConnection.getConnection();
		String sql = "select * from admin where admin_username=? and admin_password=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, admin.getAdminUsername());
		preparedStatement.setString(2, admin.getAdminPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			status = true;
		}
		con.close();
		return status;
	}

	public static Long viewBalance(Customer customer) throws SQLException {
		Long balance = null;
		Connection con = DbConnection.getConnection();
		String sql = "select balance from customers where account_number=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setLong(1, customer.getAccountNumber());
		ResultSet re = preparedStatement.executeQuery();
		while (re.next()) {
			balance = re.getLong(1);
		}
		con.close();
		return balance;
	}

	public static Customer getParams(Customer customer) throws SQLException {
		Customer cust = new Customer();
		Connection con = DbConnection.getConnection();
		String sql = "select balance,name from customers where account_number=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setLong(1, customer.getAccountNumber());
		ResultSet re = preparedStatement.executeQuery();
		while (re.next()) {
			cust.setBalance(re.getLong(1));
			cust.setName(re.getString(2));
		}
		con.close();
		return cust;
	}

	public static int getDebitOrCredit(Customer customer) throws SQLException {
		Customer cust = new Customer();
		Connection con = DbConnection.getConnection();
		String sql = "update customers set balance=? where account_number=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setLong(1, customer.getBalance());
		preparedStatement.setLong(2, customer.getAccountNumber());
		int a = preparedStatement.executeUpdate();
		con.close();
		return a;
	}

	public static List<Customer> getAllCustomers() throws SQLException {
		Connection con = DbConnection.getConnection();
		String sql = "select * from customers";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		List<Customer> l = new ArrayList<>();
		while (rs.next()) {
			Customer c = new Customer();
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setAddress(rs.getString(3));
			c.setAccountNumber(rs.getLong(4));
			c.setEmail(rs.getString(5));
			c.setMobileNumber(rs.getLong(6));
			c.setPassword(rs.getString(7));
			c.setBalance(rs.getLong(8));
			l.add(c);
		}
		con.close();
		return l;
	}

}
