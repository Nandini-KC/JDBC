package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchAllRecords {

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
		String query="SELECT * from student";
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection to database is Successfull....");
			stmt=conn.prepareStatement(query);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println("ID: "+rs.getInt(1));
				System.out.println("Student name="+rs.getString("name"));
				System.out.println("School Name="+rs.getString(3));
				System.out.println("class ="+rs.getString("class"));
				
			}
			
		
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
