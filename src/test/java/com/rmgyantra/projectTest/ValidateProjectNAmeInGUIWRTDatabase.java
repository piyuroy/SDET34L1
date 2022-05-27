package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.DataCollectionUtilities;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNAmeInGUIWRTDatabase {

	public static void main(String[] args) throws SQLException, IOException {

		FileUtilities.openPropertyFileSystem(ConstantPath.RMGYANTRAPROPERTYFILEPATH);
		ExcelUtilities.OpenExcel(ConstantPath.RMGYANTRAEXCELFILEPATH);
		String projectName =ExcelUtilities.getDataFromExcel("projects", 1, 1)+"_"+JavaLibraries.getRandomNumber(1000);
		System.out.println(projectName);
		DataCollectionUtilities.openDBConnection(ConstantPath.DATABASEURL+FileUtilities.getDataFromPropertyFile("dbName"), FileUtilities.getDataFromPropertyFile("dbUserName"), FileUtilities.getDataFromPropertyFile("dbPassword"));
		DataCollectionUtilities.setDataInDataBase("insert into project values('Ty_PRO_"+JavaLibraries.getRandomNumber(1000)+"','Piyu','20/04/2022',+'"+projectName+"','On Going',12)");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverUtilities.maximizeBrowser(d);
		WebDriverUtilities webdriverutilities = new WebDriverUtilities();
		webdriverutilities.navigateApp("http://localhost:8084/", driver);
		webdriverutilities.browserSetting(10, driver);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> listofprojects = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for(WebElement project:listofprojects)
		{
			if(project.getText().equalsIgnoreCase(projectName));
			{
				System.out.println("project name is visible in gui");
				System.out.println("TC pass");
				break;
			}
		}
		WebDriverUtilities.quitBrowser(driver);
		

	}

}
