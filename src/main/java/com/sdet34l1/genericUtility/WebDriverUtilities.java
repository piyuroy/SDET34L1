 package com.sdet34l1.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to maintain all webDriver common actions
 *
 * @author priya
 *
 */
public class WebDriverUtilities {
	 public  Actions action;
    static Select select;
	static JavascriptExecutor js;
	/**
	 * This method is used to navigate to this application
	 * @param url
	 * @param driver
	 */
	public void navigateApp(String url,WebDriver driver)
	{
		driver.get(url);
		
	}
	/**
	 * This method is used to maximize the browser and implicitly wait
	 */
	public  void browserSetting(long longTimeOut, WebDriver driver)
	{
		maximizeBrowser(driver);
		waitTillPageLoad(longTimeOut , driver);
	}
	/**
	 * This method is used to maximize the browser 
	 */
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to implicitly wait till page load
	 * @param longTimeOut
	 * @param driver
	 */
	public void waitTillPageLoad(long longTimeOut, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	/**
	 * this method is usesd to initialize wait instance until element is visible
	 * @param driver
	 * @param longTimeOut
	 * @param element
	 */
	public void explicitWaitUntillElementvisible(WebDriver driver, long longTimeOut, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to initialize wait instance until element is clickable
	 * @param driver
	 * @param longTimeOut
	 * @param element
	 */
	public void explicitWaitUntilElementClickable(WebDriver driver, long longTimeOut, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public  void explicitWaitUntilTitleContains(WebDriver driver, long longTimeOut, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.titleContains(title));
	}
	//}
	/**
	 * This method is used to initialize the actions class
	 */
	public void initializeAcions(WebDriver driver)
	{
		action= new Actions(driver);
	}
	/**
	 * perform mouse hover on the element
	 * @param moreLink
	 */
	public   void mouseHoverOntheElement(WebElement moreLink)
	{

		action.moveToElement(moreLink).perform();

	}
	/**
	 * This method is used for dragAndDrop of the element
	 * @param source
	 * @param target
	 */
	public  void dragAndDropOntheElement(WebElement source, WebElement target)
	{
		action.dragAndDrop(source, target).perform();
	}
	/**
	 * perform double click action on webpage
	 * @param moreLink
	 */
	public void doubleClickOntheElement(WebElement moreLink)
	{

		action.doubleClick(moreLink).perform();

	}
	/**
	 * This method is used to perform right click on webpage
	 * @param moreLink
	 */
	public void righClickOntheElement(WebElement moreLink)
	{
		action.contextClick(moreLink).perform();
	}
	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver, String partialText)
	{
		Set<String> sessionID = driver.getWindowHandles();
		for(String id: sessionID)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}

	/**
	 * This method is used for dropdown
	 * @param element
	 * @param value
	 */
	public static void dropDown(WebElement element, String value)
	{
		select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used for dropdown
	 * @param index
	 * @param element
	 */
	public static void dropDown(int index, WebElement element )
	{
		select = new Select(element);
		select.selectByIndex(index);
	}
	public static void dropDown(String visible, WebElement element)
	{
		select = new Select(element);
		select.selectByVisibleText(visible);
	}
	/**
	 * This method is used for switching frames
	 * @param driver
	 * @param index
	 */
	public static void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public static void switchToFrame(WebDriver driver, String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	public static void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to take control back from frame
	 * @param driver
	 */
	public static void switchBackFromFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to initialize javascriptExecutor
	 * @param driver
	 */
	public static void initializeJs(WebDriver driver)
	{
		js = (JavascriptExecutor) driver;
	}
	/**
	 * This method is used to click element through javascriptExecutor
	 * @param element
	 */
	public static void clickThroughJs(WebElement element)
	{
		js.executeScript("argument[0],click()", element);
	}
	public static void enterDataThroughJs(WebDriver driver, WebElement element, String data, String url)
	{
		js.executeScript("argument[0].value =argument[1]",element, data);
	}
	/**
	 * this method is used to navigate to url
	 * @param url
	 */
	public static void navigateToAllAppThrough(String url)
	{
		js.executeScript("window.location =argument[0]",url);
	}
	/**
	 * this method is used to scroll the page 
	 * @param height
	 */
	public static void scrollToSpecificHeight(String height)
	{
		js.executeScript("window.scrollBy(0,"+height+")");
	}
	public static void scrolltoBottomHeight(String height)
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * This method is used to scroll the page till a particular webElement 
	 * @param element
	 */
	public static void scrollTillElement(WebElement element)
	{
		js.executeScript("argument[0].scrollIntoView()", element);
	}
	/**
	 * this method is used to take screenshot and storing it at the specified path
	 * @param driver
	 * @return 
	 */
	public static String takesScreenshot(WebDriver driver,String fileName)
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot"+fileName +""+JavaLibraries.getDateTimeInFormat()+".png");
		//System.out.println(dest.getAbsolutePath());
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
		

	}
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public static void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static void getalertText(WebDriver driver, String data)
	{
		driver.switchTo().alert().getText();
	}
	/**
	 * This medhod is used for sending data in alert
	 * @param driver
	 * @param data
	 */
	public static void send(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * this method is used to close all the tabs
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}


}
