package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;
import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FetchDataFromExcel {
	public static void main(String[] args) throws IOException
	{
		//FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
	    FileUtilities.openPropertyFileSystem(ConstantPath.PROPERTYFILEPATH) ;
		
		//String url =p.getProperty("url");
		String url =FileUtilities.getDataFromPropertyFile("url");
		//String timeout = p.getProperty("timeout");
		String timeout =FileUtilities.getDataFromPropertyFile("timeout");
		//String username =p.getProperty("username");
		 String username =FileUtilities.getDataFromPropertyFile("username");
		//String password =p.getProperty("password");
		 String password =FileUtilities.getDataFromPropertyFile("password");
		//String browser =p.getProperty("browser");
		String browser =FileUtilities.getDataFromPropertyFile("browser");
		//long longTimeOut = Long.parseLong(timeout);
			long longTimeOut =JavaLibraries.stringToLong(timeout);
		
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/TestCase.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Random ran = new Random();
		int randomNumber = ran.nextInt(1000);
		String lastname = wb.getSheet("sheet1").getRow(3).getCell(4).getStringCellValue();
		WebDriver driver =null;
		switch(browser)
		{
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default :
			System.out.println(" please specify proper browser key");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		//driver.findElement(By.name("user_name")).sendKeys(username);
		//driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		if(driver.getTitle().contains(" Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"))
		{
			wb.getSheet("contacts").getRow(6).createCell(5).setCellValue("Home page displayed");
			wb.getSheet("contacts").getRow(6).createCell(6).setCellValue("pass");
		}
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		if(driver.getTitle().contains("Contacts"))
		{
			wb.getSheet("contacts").getRow(7).createCell(5).setCellValue("contacts page is displayed");
			wb.getSheet("contacts").getRow(7).createCell(6).setCellValue("pass");
		}
		WebElement el= driver.findElement(By.name("lastname"));
		el.sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String con = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(con.contains("aiegl"))
		{
			System.out.println("pass");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
