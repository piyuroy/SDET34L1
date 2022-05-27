package com.vtiger.practiceTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_42 {

	public static void main(String[] args) throws IOException {
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
		if(driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			ExcelUtilities.createCellInExcel("sheet1",3 ,6, "Login page display");
			ExcelUtilities.createCellInExcel("sheet1",3,7, "pass");
			JavaLibraries.printStatement("Login page display");

		}
		LoginPage lp = new LoginPage(driver);
		lp.loginAction(username, password);
		if(driver.getTitle().contains("Home"))
		{
			ExcelUtilities.createCellInExcel("sheet1", 4, 6, "Home page display");
			ExcelUtilities.createCellInExcel("sheet1", 4, 7, "pass");
			JavaLibraries.printStatement("Home page display");

		}
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='roy356']")).click();
  driver.findElement(By.linkText("More Information")).click();
  driver.findElement(By.xpath("//img[@id='show_Contacts_Documents']")).click();
  driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
  driver.findElement(By.name("notes_title")).sendKeys("pollution");
  driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
  driver.findElement(By.id("filename_I__")).sendKeys("C:\\Users\\Avinash\\Desktop\\yoyo\\epfo1\\Application Form Preview.pdf");
  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
  WebElement mousehover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	WebDriverUtilities.initializeAcions(driver);
	WebDriverUtilities.mouseHoverOntheElement(mousehover);
	driver.findElement(By.linkText("Sign Out")).click();

	}

}
