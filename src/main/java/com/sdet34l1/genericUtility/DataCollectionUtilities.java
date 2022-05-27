package com.sdet34l1.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all common action related to database
 * @author Priya
 *
 */
public class DataCollectionUtilities {
	static Connection connection;
	static Statement statement;
	/**
	 * This method is used to open the database connection and initialize the connection, statement
	 * @param dBurl
	 * @param dbUserName
	 * @param dbPassword
	 * @param columnName
	 * @param query
	 * @throws SQLException 
	 */
	public static void openDBConnection(String dburl, String dbUserName, String dbPassword) throws SQLException
	{
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		 connection = DriverManager.getConnection(dburl, dbUserName, dbPassword);
		 statement = connection.createStatement();
	}
	/**
	 * This method is used to fetch the data from database/to do the DQL actions on database
	 * @param dBurl
	 * @param dbUserName
	 * @param dbPassword
	 * @param columnName
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDataBase(String query,String columnName) throws SQLException
	
	{
		ArrayList<String> list = new ArrayList<>();
		
	     ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		connection.close();
		return list;
		
	}
	/**
	 * This method is used to validate the data whether it is present in database or not
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean validateTheDataInDatabase(String query, String columnName, String expectedData) throws SQLException
	{
		ArrayList<String> list = getDataFromDataBase(query, columnName);
		boolean flag =false;
		for(String actualData:list)
		{
			if(actualData.equals(expectedData))
			{
				flag = true;
				break;
			}
		}
		return flag;
	}
	/**
	 * This method is used to store/modify/insert/delete the data in database/ to do the dml/ddl actions on database
	 * @throws SQLException 
	 */
	public static void setDataInDataBase(String query) throws SQLException
	{
		int result = statement.executeUpdate(query);
		if(result>=1)
		{
			System.out.println("Data entered/modified successfully");
		}
	}
	/**
	 * This method is used to close the database connection
	 */
	public static void closeDBConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(" While closing the database connection we got exception");
		}
		
	}
	

}
