package com.vtiger.practiceTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calander {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/flights/?cmp=SEM|D|DF|G|Brand|B_M_Makemytrip_Variants|Brand-Variants-Exact|RSA|Regular|V2|274470846615&s_kwcid=AL!1631!3!274470846615!e!!g!!make%20my%20trip-&ef_id=EAIaIQobChMI75mI4qrD9wIVVR0rCh1dYQ3bEAAYASAAEgJ60PD_BwE:G:s&gclid=EAIaIQobChMI75mI4qrD9wIVVR0rCh1dYQ3bEAAYASAAEgJ60PD_BwE");
		
		  Actions act= new Actions(driver);
		  act.moveByOffset(20, 60).click().perform();
		  driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		driver.findElement(By.xpath("//div[text()='June 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='28']")).click();

	}

}
