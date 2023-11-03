package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class School {
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
		String query="INSERT into student(id,name,school_name,class) VALUES (3,'Lahari','High school',10)";
		String updateQuery="Update student set school_name ='ZPHS' where name='Bindu'";
		String deleteQuery="delete from student where name='Nandu'";
		try {
			Connection conn=DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection to database is Successfull....");
			java.sql.Statement stmt =conn.createStatement();
			stmt.execute(query);
			System.out.println("Executed insert query");
			stmt.execute(updateQuery);
			System.out.println("Executed update query");
			stmt.execute(deleteQuery);
			System.out.println("Executed delete query");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
