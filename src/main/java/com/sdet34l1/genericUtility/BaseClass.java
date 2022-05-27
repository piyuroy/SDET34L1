package com.sdet34l1.genericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains implementation of all basic configuration annotation
 * @author Priya
 *
 */
public class BaseClass {
	
	public WebDriver driver;
	String url;
	public String browser;
	public String username;
	public String password;
	public long longTimeOut;
	public int randomnumber;
	public LoginPage login;
	public HomePage homepage;
	public WebDriverUtilities webdriverutilities;
	public static WebDriver staticDriver;
	/**
	 * In this annotation we open the database
	 * Open the property file
	 * Open the excel
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@BeforeSuite
	public void beforeSuiteTest() throws EncryptedDocumentException, IOException
	{

		FileUtilities.openPropertyFileSystem(ConstantPath.PROPERTYFILEPATH) ;
		ExcelUtilities.OpenExcel(ConstantPath.EXCELFILEPATH);
	}
	/**
	 * In this annotation we fetch the common data from the property file
	 * Create the instance for all the generic utility
	 * Launch browser
	 * Browser setting
	 * Create the instance for common object
	 */
	//@Parameters("browser") and pass String browser in beforeClass 
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass()
	{
		webdriverutilities = new  WebDriverUtilities();
		String timeout =FileUtilities.getDataFromPropertyFile("timeout");
		// reading data from external resources
		url =FileUtilities.getDataFromPropertyFile("url");
		//username =FileUtilities.getDataFromPropertyFile("username");
		//password =FileUtilities.getDataFromPropertyFile("password");
		//browser =FileUtilities.getDataFromPropertyFile("browser");
		longTimeOut =JavaLibraries.stringToLong(timeout);
		randomnumber = JavaLibraries.getRandomNumber(1000);
		browser = System.getProperty("BROWSER");
		username = System.getProperty("USERNAME");
		password = System.getProperty("PASSWORD");
		
		switch(browser)
		{
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();;
			driver = new FirefoxDriver();
		case "default" :
			System.out.println(" please enter valid browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		staticDriver = driver;

		// navigating the application
		webdriverutilities.navigateApp(url, driver);
		//browser settings
		webdriverutilities.maximizeBrowser(driver);
		// implicit wait initialization
		webdriverutilities.waitTillPageLoad(longTimeOut, driver);
		
		webdriverutilities.initializeAcions(driver);
		
		//create the instance for common object repository class
		login = new LoginPage(driver);
		homepage = new HomePage(driver);
		
	}
	/**
	 * In this annotation we will do login action
	 */
		@BeforeMethod
		public void beforeMethod()
		{
		
		login.loginAction(username, password);
		// homepage.clickCampaign(driver);
		}
	
	/**
	 * This method is used for Mouse hover and sign Out
	 */

	@AfterMethod
	public void afterMethod()
	{
		homepage.signout(driver, webdriverutilities);
	}
	/**
	 * In this annotation we will close the browser instance
	 */
	@AfterClass
	public void afterClassTest()
	{
		WebDriverUtilities.quitBrowser(driver);
	}
	/**
	 * In this annotation close the database
	 * close the excel sheet
	 */
	@AfterSuite
	public void afterSuiteTest()
	{
		ExcelUtilities.closeExcel();
	}
	

}
