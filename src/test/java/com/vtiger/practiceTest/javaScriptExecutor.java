package com.vtiger.practiceTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js=  (JavascriptExecutor) driver;
		js.executeScript("window.locataion ='http://localhost:8888'");
		js.executeScript("arguments[0].value=argument[1]",driver.findElement(By.name("user_name")),"admin");
		js.executeScript("arguments[0].value=argument[1]", driver.findElement(By.name("user_password")),"admin");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("submitButton")));
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView()");
		
	}

}
