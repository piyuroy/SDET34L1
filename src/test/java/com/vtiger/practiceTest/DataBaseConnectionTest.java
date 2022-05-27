package com.vtiger.practiceTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnectionTest {
	public static void main(String[] args) throws SQLException
	{
		//Step1 : Create object for implementation class and import driver from (import java.sql.cj.jdbc.Driver)
		Driver driver = new Driver();
		//Step2 :Register the driver with jdbc
		DriverManager.registerDriver(driver);
		//Step3 :Establish the connection
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		//Step 4 : create the statement
		Statement stat =con.createStatement();
		//Step5 : Execute script
		String query = "Select*from Projects";
		ResultSet result = stat.executeQuery(query);
		//Step6 : validate based on test case
		while(result.next())
		{
			System.out.println(result.getInt(1)+" "+result.getString(2));
		}
		//Step7 : close the connection
		con.close();
	}

}
