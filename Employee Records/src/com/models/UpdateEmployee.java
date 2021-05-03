package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DbConnection;

public class UpdateEmployee {
	private Connection con;
	private PreparedStatement preparedStatement;

	public UpdateEmployee(String employee_name, String employee_job, int employee_salary, int employee_id) {
		con = DbConnection.getConnection();
		String sql = "update record set employee_name=?,employee_job=?,employee_salary=? where employee_id=?";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, employee_name);
			preparedStatement.setString(2, employee_job);
			preparedStatement.setInt(3, employee_salary);
			preparedStatement.setInt(4, employee_id);
			int i = preparedStatement.executeUpdate();
			System.out.println(i + " Data successfully updated of id ");

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
