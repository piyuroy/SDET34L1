package com.rmgyantra.projectTest;

import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.DataCollectionUtilities;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class validateProjectNameInDatabaseWRTGUI {

	public static void main(String[] args) throws SQLException, IOException
	{
		FileUtilities.openPropertyFileSystem(ConstantPath.RMGYANTRAPROPERTYFILEPATH);
		ExcelUtilities.OpenExcel(ConstantPath.RMGYANTRAEXCELFILEPATH);
		int randomNumber =JavaLibraries.getRandomNumber(1000);
		String projectName =ExcelUtilities.getDataFromExcel("projects", 1, 1)+"_"+randomNumber;
		System.out.println(projectName);
		DataCollectionUtilities.openDBConnection(ConstantPath.DATABASEURL+FileUtilities.getDataFromPropertyFile("dbName"), FileUtilities.getDataFromPropertyFile("dbUserName"), FileUtilities.getDataFromPropertyFile("dbPassword"));
		//DataCollectionUtilities.setDataInDataBase("insert into project values(Ty_PRO_"+randomNumber+"",Piyu,20/04/2022,+"+projectName+");
		WebDriverManager.chromedriver().setup();
		WebDriverUtilities webdriverutilties = new WebDriverUtilities();
		WebDriver driver= new ChromeDriver();
		 webdriverutilties.browserSetting(10, driver);
		 webdriverutilties.navigateApp("http://localhost:8084", driver);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("tr");;

		driver.findElement(By.name("createdBy")).sendKeys("piyu");
		WebElement dropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		WebDriverUtilities.dropDown(2, dropdown);
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		DataCollectionUtilities.openDBConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		DataCollectionUtilities.getDataFromDataBase("select*from project", projectName);
		WebDriverUtilities.quitBrowser(driver);



	}

}
