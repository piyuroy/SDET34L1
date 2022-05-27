package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsWithOrganisationTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		 FileUtilities.openPropertyFileSystem(ConstantPath.PROPERTYFILEPATH) ;
		 String url =FileUtilities.getDataFromPropertyFile("url");
		 String timeout =FileUtilities.getDataFromPropertyFile("timeout");
		 String username =FileUtilities.getDataFromPropertyFile("username");
		 String password =FileUtilities.getDataFromPropertyFile("password");
		 String browser =FileUtilities.getDataFromPropertyFile("browser");
		// String lastname =FileUtilities.getDataFromPropertyFile("lastname");
		 long longTimeOut =JavaLibraries.stringToLong(timeout);
		 int randomnumber = JavaLibraries.getRandomNumber(1000);
		//String lastname = wb.getSheet("sheet1").getRow(3).getCell(4).getStringCellValue();
		FileInputStream fis = new FileInputStream("./src/test/resources/TestCase.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String organization = wb.getSheet("sheet1").getRow(3).getCell(5).getStringCellValue();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(organization+randomnumber);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		//driver.navigate().to("http://localhost:8888/index.php?module=Contacts&action=index");
		WebElement ele = driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().perform();
		//driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		Thread.sleep(1000);
	     driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String b : child )
		{
			driver.switchTo().window(b);
		}
		driver.findElement(By.id("search_txt")).sendKeys("yoyo"+randomnumber);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		driver.close();
		WebElement hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(hover).perform();

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		

	}

}
