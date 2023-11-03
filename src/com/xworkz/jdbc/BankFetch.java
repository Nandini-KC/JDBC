package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankFetch {

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
		String fecthBankByName="Select * from bank where name='Indian'";
		try {
			Connection conn=DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection to database is Successfull....");
			java.sql.Statement stmt =conn.createStatement();
			ResultSet rs=stmt.executeQuery(fecthBankByName);
			System.out.println(rs);
			if(rs.next())
			{
				System.out.println("Bank name "+rs.getString(2));
				System.out.println("Bank branch "+rs.getString(3));
				System.out.println("Bank state "+rs.getString("state"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
