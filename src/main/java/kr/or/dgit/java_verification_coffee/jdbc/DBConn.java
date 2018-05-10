package kr.or.dgit.java_verification_coffee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConn {
	private static final DBConn instance = new DBConn();

	private Connection connection;

	public static DBConn getInstance() {
		return instance;
	}

	private DBConn() {
		try {
			Properties info = LoadProperties.getInstance().getProperties();
			connection = DriverManager.getConnection(info.getProperty("url"), info);
		} catch (SQLException e) {
			System.err.printf("%s = %s%n", e.getMessage(), e.getErrorCode());
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void connectionClose() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
