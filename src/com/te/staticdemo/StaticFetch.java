package com.te.staticdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StaticFetch {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("directory.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			connection = DriverManager.getConnection(properties.getProperty("connection"));
			statement = connection.createStatement();
			resultSet = statement.executeQuery(properties.getProperty("select"));
			if (resultSet.next()) {
				System.out.println("ID:"+resultSet.getInt(1));
				System.out.println("Name:"+resultSet.getString(2));
				System.out.println("Location:"+resultSet.getString(3));
				System.out.println("Salary:"+resultSet.getDouble(4));
			}
			System.out.println("Data fetched!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
