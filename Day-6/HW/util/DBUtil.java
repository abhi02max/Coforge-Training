package com.coforge.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName(ApplicationProperties.driver);

		// Step-2 : Connection with DB
		Connection connection = DriverManager.getConnection(ApplicationProperties.url, ApplicationProperties.root,
				ApplicationProperties.password);
		return connection;
	}
}
