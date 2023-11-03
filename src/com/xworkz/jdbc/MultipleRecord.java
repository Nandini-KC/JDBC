package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleRecord {

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
		String insertQuery="INSERT into bank(id,name,branch,state)VALUES(?,?,?,?)";
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection to database is Successfull....");
			stmt=conn.prepareStatement(insertQuery);
			stmt.setInt(1, 4);
			stmt.setString(2, "ICICI");
			stmt.setString(3, "Marthalli");
			stmt.setString(4, "Karnataka");
			stmt.execute();
			
			stmt.setInt(1, 5);
			stmt.setString(2, "Canara");
			stmt.setString(3, "Chittoor");
			stmt.setString(4, "Andhra Pradesh");
			stmt.execute();
			
			stmt.setInt(1, 6);
			stmt.setString(2, "Bank of Baroda");
			stmt.setString(3, "Thirupathi");
			stmt.setString(4, "Andhra Pradesh");
			stmt.execute();
			
			stmt.setInt(1, 7);
			stmt.setString(2, "SBI");
			stmt.setString(3, "Kanipakam");
			stmt.setString(4, "Andhra Pradesh");
			stmt.execute();
			
			stmt.setInt(1, 8);
			stmt.setString(2, "Indian");
			stmt.setString(3, "Thavanampalli");
			stmt.setString(4, "Andhra Pradesh");
			stmt.execute();
			
			
			stmt.setInt(1, 9);
			stmt.setString(2, "HDFC");
			stmt.setString(3, "Chittoor");
			stmt.setString(4, "Andhra Pradesh");
			stmt.execute();
			
			
			stmt.setInt(1, 10);
			stmt.setString(2, "SBI Hyderabad");
			stmt.setString(3, "Hyderabad");
			stmt.setString(4, "Telangana");
			stmt.execute();
			
			stmt.setInt(1, 11);
			stmt.setString(2, "Axis");
			stmt.setString(3, "Bangalore");
			stmt.setString(4, "Karnataka");
			stmt.execute();
			
			System.out.println("Multiple records inserted successfully");
		
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
