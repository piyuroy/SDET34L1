package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnectionTest1 {
	static Connection con;
	public static void main(String[] args) throws SQLException
	{
		
		try
		{
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			Statement state = con.createStatement();
			ResultSet result = state.executeQuery("select*from emp");
			while(result.next())
			{
				System.out.println(result.getString(2));
			}
		}
			finally
			{
				System.out.println("Before class");
				con.close();
				System.out.println("After class");
				
			}
			
		}
		
	}


