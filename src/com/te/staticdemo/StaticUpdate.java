package com.te.staticdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class StaticUpdate {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("directory.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			connection = DriverManager.getConnection(properties.getProperty("connection"));
			statement = connection.createStatement();
			statement.executeUpdate(properties.getProperty("update"));
			System.out.println("Data updated!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
