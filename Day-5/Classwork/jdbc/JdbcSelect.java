package com.coforge.day5.classwork.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcSelect {

	public static void main(String[] args) throws Exception {

		//Step-1 :Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//Step-2 : Connection with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Saud231005@");

		//Step-3 :Creating Statement
		String sql = "select * from tbl_students";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultset = statement.executeQuery();//Insert,delete and update query //itll return how many rows execute

		while (resultset.next()) {
			System.out.println(resultset.getInt("StudentID") + " " + resultset.getString("Name") + " "
					+ resultset.getInt("Age") + " " + resultset.getString("Gender") + " " + resultset.getString("City"));
		}

		//step-5 closing
		connection.close();
		statement.close();
	}
}