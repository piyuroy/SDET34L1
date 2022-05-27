package com.sdet34l1.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * 
 * @author Priya
 *
 */
public class JavaLibraries {
	/**
	 * This method is used to convert String value to long data type
	 * @param value
	 * @return
	 */
	public static long stringToLong(String value)
	{
		return Long.parseLong(value);
	}
	/**
	 * This method is used to get the random number
	 * @param limit
	 * @return
	 */
	public static int getRandomNumber(int limit)
	{
		Random ran = new Random();
		return ran.nextInt(limit);
	}
	/**
	 * this method is used to print the message
	 */
	public static void printStatement(String message)
	{
		System.out.println(message);
	}
	public static void threadSleepWait(int number)
	{
		try {
			Thread.sleep(number);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this medhod is used for verification purpose
	 * 
	 * @param actualResult
	 * @param expectedResult
	 * @param testCaseName
	 */
	public static  void assertionThroughIfCondition(String actualResult, String expectedResult, String testCaseName)
	{
		if(actualResult.contains    (expectedResult))
		{
			System.out.println(testCaseName+" created successfully");
			System.out.println(" Tc pass");
		}
		
	}
	public static String getDateTimeInFormat()
	{
		return new SimpleDateFormat("yyyy_MM__DD__HH_mm_ssss").format(new Date());
	}
	/**
	 * this method is used to Create
	 * @param element
	 * @param polingTime
	 * @param duration
	 * @throws InterruptedException
	 */
	public static void customWait(WebElement element, long polingTime, int duration) throws InterruptedException
	{
		int count =0;
		while(count<=duration) {
			element.click();
		
		Thread.sleep(polingTime);
		count++;
		
	}}
	

}
