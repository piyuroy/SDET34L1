package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException
	{
		 FileUtilities.openPropertyFileSystem(ConstantPath.PROPERTYFILEPATH) ;
		 String url =FileUtilities.getDataFromPropertyFile("url");
		 String timeout =FileUtilities.getDataFromPropertyFile("timeout");
		 String username =FileUtilities.getDataFromPropertyFile("username");
		 String password =FileUtilities.getDataFromPropertyFile("password");
		 String browser =FileUtilities.getDataFromPropertyFile("browser");
		 String lastname =FileUtilities.getDataFromPropertyFile("lastname");
		 long longTimeOut =JavaLibraries.stringToLong(timeout);
		
		
	/**
	 * 	FileInputStream fis=  new FileInputStream("./src/test/resources/data.properties");
	    Properties p = new Properties();
		p.load(fis);
		String url =p.getProperty("url");
		String timeout =p.getProperty("timeout");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		//String browser =p.getProperty("browser");
		String lastname =p.getProperty("lastname");
		long longTimeOut = Long.parseLong(timeout);[
		
		*/

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		lp.loginAction(username, password);
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(hover).perform();

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}

}
