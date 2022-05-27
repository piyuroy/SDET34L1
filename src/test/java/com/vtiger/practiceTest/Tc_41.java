package com.vtiger.practiceTest;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_41 {
	@Test

	public void tc_41() throws EncryptedDocumentException, IOException, Throwable {
		FileUtilities.openPropertyFileSystem(ConstantPath.PROPERTYFILEPATH);
		ExcelUtilities.OpenExcel(ConstantPath.CONTACTSMODULEEXCELFILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String url =FileUtilities.getDataFromPropertyFile("url");
		String username =FileUtilities.getDataFromPropertyFile("username");
		String password =FileUtilities.getDataFromPropertyFile("password");
		String lastname = FileUtilities.getDataFromPropertyFile("lastname");
		String timeout = FileUtilities.getDataFromPropertyFile("timeout");
		long longTimeOut =JavaLibraries.stringToLong(timeout);
		WebDriverUtilities.navigateApp(url, driver);
		WebDriverUtilities.browserSetting(longTimeOut, driver);
		int randomnumber = JavaLibraries.getRandomNumber(1000);
//		if(driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM"))
//		{
//			ExcelUtilities.createCellInExcel("sheet1",3 ,6, "Login page display");
//			ExcelUtilities.createCellInExcel("sheet1",3,7, "pass");
//			JavaLibraries.printStatement("Login page display");
//
//		}
		LoginPage lp = new LoginPage(driver);
		lp.loginAction(username, password);
		JavaLibraries.printStatement("Home page display");
//		if(driver.getTitle().contains("Home"))
//		{
//			ExcelUtilities.createCellInExcel("sheet1", 4, 6, "Home page display");
//			ExcelUtilities.createCellInExcel("sheet1", 4, 7, "pass");
//
//		}
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='roy356']")).click();
		driver.findElement(By.linkText("More Information")).click();
		driver.findElement(By.xpath("//img[@id='show_Contacts_Products']")).click();
		driver.findElement(By.xpath("//input[@title='Select Products']")).click();
		String parent = driver.getWindowHandle();
		WebDriverUtilities.switchToWindowBasedOnTitle(driver, "Accounts&action");
		//		Set<String> child = driver.getWindowHandles();
		//		for(String b : child )
		//		{
		//
		//			driver.switchTo().window(b);
		//		}
		Thread.sleep(1000);
		driver.findElement(By.id("search_txt")).sendKeys("r");
		driver.findElement(By.name("search")).click();
		Thread.sleep(1000);
		driver.switchTo().window(parent);
		WebElement mousehover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtilities.initializeAcions(driver);
		WebDriverUtilities.mouseHoverOntheElement(mousehover);
		driver.findElement(By.linkText("Sign Out")).click();



	}

}
