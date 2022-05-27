package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsDatabaseTest {
	public static void main(String[] args) throws SQLException
	{
		String url = null, username =null, password = null,timeout=null;
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root","root");
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery("select*from lion");
		while(result.next())
		{
			url = result.getString("url");
			username = result.getString("username");
			password = result.getString("password");
			timeout =result.getString("timeout");
		}
		long longTimeout = Long.parseLong(timeout);
		WebDriver d=null;
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get(url);
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.name("user_name")).sendKeys(username);
		d.findElement(By.name("user_password")).sendKeys(password);
		d.findElement(By.id("submitButton")).click();
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 WebElement el= d.findElement(By.name("lastname"));
		 el.sendKeys("aiegl");
		d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();




	}

}
