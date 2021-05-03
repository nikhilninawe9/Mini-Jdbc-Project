package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DbConnection;

public class GetAllEmployees {

	private Connection con;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	GetAllEmployees() {
		con = DbConnection.getConnection();
		String sql = "select * from record";
		try {
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String job = resultSet.getString(3);
				int salary = resultSet.getInt(4);
				System.out.println(
						"=====================================================================================================================");
				System.out.println("Employee Name: " + name + "| Employee id: " + id + "| Employee Job Designation: "
						+ job + "| Employee Salary: " + salary);
				System.out.println(
						"=====================================================================================================================");
			}
			resultSet.close();
			con.close();
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
