package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DbConnection;

public class DeleteEmployee {
	private Connection con;
	private PreparedStatement preparedStatement;

	public DeleteEmployee(int id) {
		con = DbConnection.getConnection();
		String sql = "delete from record where employee_id=?";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int i = preparedStatement.executeUpdate();
			System.out.println("Data deleted of id: " + id);
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
