package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DbConnection;

public class AddEmployees {

	private Connection con;
	PreparedStatement preparedStatement;

	public AddEmployees(int id, String name, String job, int salary) {
		con = DbConnection.getConnection();
		String sql = "insert into record(employee_id,employee_name,employee_job,employee_salary)values(?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, job);
			preparedStatement.setInt(4, salary);
			int i = preparedStatement.executeUpdate();
			System.out.println("***** New entry of employee has been added");
			System.out.println("Name: " + name + "| Id: " + id + "| Designation: " + job + "| Salary: " + salary);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
