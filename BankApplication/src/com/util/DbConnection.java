package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection con = null;
	final static String url = "jdbc:mysql://localhost:3306/bank_application";
	final static String driver = "com.mysql.cj.jdbc.Driver";
	final static String username = "root";
	final static String password = "Acerfaraari@123";

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return con;
	}
}
