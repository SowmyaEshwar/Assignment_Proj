package com.te.dynamicdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DynamicInsert {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id:");
		int id = scanner.nextInt();
		System.out.println("enter the name:");
		String name = scanner.next();
		System.out.println("enter the location:");
		String location = scanner.next();
		System.out.println("enter the salary:");
		double salary = scanner.nextDouble();
		scanner.close();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("directory.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);

			connection = DriverManager.getConnection(properties.getProperty("connection"));
			preparedStatement = connection.prepareStatement(properties.getProperty("insertDynamic"));
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, location);
			preparedStatement.setDouble(4, salary);
			int result = preparedStatement.executeUpdate();
			System.out.println("Data inserted dynamically!!!");
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
