package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DbConnection;

public class GetEmployeesById {

	private Connection con;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	GetEmployeesById(int employee_id) throws SQLException {
		// Singleton approach
		con = DbConnection.getConnection();
		String sql = "select * from record where employee_id=?";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, employee_id);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String job = resultSet.getString(3);
			int salary = resultSet.getInt(4);
			System.out.println();
			System.out.println(
					"=====================================================================================================================");
			System.out.println("Employee Name: " + name + "| Employee id: " + id + "| Employee Job Designation: " + job
					+ "| Employee Salary: " + salary);
			System.out.println(
					"=====================================================================================================================");
			System.out.println();

		} else {
			System.out.println("***********Invalid id***********");
		}
		resultSet.close();
		con.close();
	}
}
