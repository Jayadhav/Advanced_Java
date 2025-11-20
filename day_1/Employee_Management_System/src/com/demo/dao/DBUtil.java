package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil 
{
	
	static Connection con = null;
	public static Connection getMyConnection()
	{
		if(con==null)
		{
			try 
			
			{
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url ="jdbc:mysql://192.168.10.117:3306/dac106?useSSL=false";
				con = DriverManager.getConnection(url, "dac106", "welcome");
				
				if(con!=null)
				{
					System.out.println("Connection done");
				}
				else
				{
					System.out.println("connection not done..");
					
				}
				
				
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		return con;
		
	}

}
