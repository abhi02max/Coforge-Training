package com.coforge.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getDBConnection()
            throws ClassNotFoundException, SQLException {

        Class.forName(ApplicationProperties.driver);

        Connection connection = DriverManager.getConnection(
                ApplicationProperties.url,
                ApplicationProperties.username,
                ApplicationProperties.password);

        return connection;
    }
}