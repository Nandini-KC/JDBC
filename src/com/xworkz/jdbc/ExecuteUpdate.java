package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate {
	public static void main(String[] args) {
		String jdbcURL="jdbc:mysql://localhost:3306/sys";
		String userName="root";
		String password="Xworkzodc@123";
		
		String driverClass="com.mysql.jdbc.Driver";
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Connection to Database...");
		Statement stmt=null;
		String query="INSERT into student(id,name,school_name,class) VALUES (4,'Thanusha','Chainthanya',5)";
		
		try {
			Connection conn=DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection to database is Successfull....");
			 stmt=conn.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println("Updated table");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}

}
