package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleRecordUpdate {

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
		String updateQuery="UPDATE bank set branch=? where name=?";
		String query="select * from bank";
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection to database is Successfull....");
			stmt=conn.prepareStatement(updateQuery);
			stmt.setString(1, "Majestic");
			stmt.setString(2, "ICICI");
			stmt.executeUpdate();
			
			stmt.setString(1, "Koramangala");
			stmt.setString(2, "SBI");
			stmt.executeUpdate();
			System.out.println("updated data successfully");
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
			{
				
					try {
						conn.close();
						System.out.println("Connection is closed");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
			}
			if(stmt!=null)
			{
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
