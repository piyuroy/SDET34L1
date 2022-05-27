package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreatePracticeTest {
	public static void main(String[] args) throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		Statement stat = con.createStatement();
		String query = "Select*from sdet";
		ResultSet result = stat.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getInt(1)+" "+result.getString(2));
		}
		con.close();
	}

}
