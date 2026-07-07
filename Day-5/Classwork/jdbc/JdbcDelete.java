package com.coforge.day5.classwork.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDelete {

	public static void main(String[] args) throws Exception {

		//Step-1 :Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//Step-2 : Connection with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Saud231005@");

		//Step-3 :Creating Statement
		String sql = "delete from tbl_students where Studentid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		//step4 Executing Query
		statement.setInt(1, 301);

		int n = statement.executeUpdate();//Insert,delete and update query //itll return how many rows execute

		if (n == 1) {
			System.out.println("Student Details Entered");
		} else {
			System.out.println("Student Details Not Entered");
		}

		//step-5 closing
		connection.close();
		statement.close();
	}
}