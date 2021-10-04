package com.te.dynamicdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DynamicUpdate {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id:");
		int id = scanner.nextInt();
		System.out.println("enter the name:");
		String name = scanner.next();
		scanner.close();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("directory.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection(properties.getProperty("connection"));
			preparedStatement = connection.prepareStatement(properties.getProperty("updateDynamic"));
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, name);
			int result = preparedStatement.executeUpdate();
			System.out.println("Data updated dynamically!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
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
