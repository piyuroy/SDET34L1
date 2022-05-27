package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.sdet34l1.genericUtility.WebDriverUtilities;
import com.vtiger.objectRepository.CreateOrganisationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganisationNewPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationDatabaseTest {
	@Test
	public void createOrganisationDatabaseTest() throws SQLException
	{
		String url = null, username =null, password = null;
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root","root");
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery("select*from lion");
		while(result.next())
		{
			url = result.getString("url");
			username = result.getString("username");
			password = result.getString("password");
			
		}
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverUtilities.browserSetting(10, driver);
		WebDriverUtilities.navigateApp(url, driver);
		LoginPage lp = new LoginPage(driver);
		lp.loginAction(username, password);
		HomePage hp = new HomePage(driver);
		hp.clickOrganisation();
		CreateOrganisationPage co = new CreateOrganisationPage(driver);
		co.addOrganisation();
	OrganisationNewPage op = new OrganisationNewPage(driver);
	op.addOrganisationName("abc");
		
		
     driver.findElement(By.xpath("//input[@class='detailedViewTextBox']"));
	
		driver.findElement(By.name("button")).click();
		String name = driver.findElement(By.id("dtlview_Organization Name")).getText();
	}
}
