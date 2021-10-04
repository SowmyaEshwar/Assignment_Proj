package com.te.staticdemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesWrite {
	public static void main(String[] args) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("directory.properties");
			Properties properties = new Properties();
			properties.setProperty("load", "com.mysql.jdbc.Driver");
			properties.setProperty("connection", "jdbc:mysql://localhost:3306/techno?user=root&password=sowmya");
			
			System.out.println("-------Static--------");
			properties.setProperty("select", "select * from emp where id=1");
			properties.setProperty("insert", "insert into emp values(4,'Vinutha M','Begur',50000)");
			properties.setProperty("update", "update emp set name='Vinu' where id=4");
			properties.setProperty("delete", "delete from emp where id=4");
			
			System.out.println("--------Dynamic----------");
			properties.setProperty("selectDynamic", "select * from emp where id=?");
			properties.setProperty("insertDynamic", "insert into emp values(?,?,?,?)");
			properties.setProperty("updateDynamic", "update emp set name= ? where id=?");
			properties.setProperty("deleteDynamic", "delete from emp where id=?");
			properties.store(fileOutputStream, "Queries written!!");
			System.out.println("Queries inserted!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
