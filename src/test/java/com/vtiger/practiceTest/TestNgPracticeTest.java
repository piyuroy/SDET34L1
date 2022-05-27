package com.vtiger.practiceTest;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Parameters("browser")
public class TestNgPracticeTest {
	@BeforeSuite(groups="sanity")
	public void beforesuite1Test()
	{
		Reporter.log("beforesuite1",true);
	}
	@AfterSuite(groups="regression")
	public void afterresult1Test()
	{
		Reporter.log("aftersuite1",true);
	}
	@BeforeClass
	public void beforeClass1Test()
	{
	   Reporter.log("beforeClass1",true);
	}
	@AfterClass(groups="sanity")
	public void afterClass1Test()
	{
		Reporter.log("afterClass1",true);
	}
	@BeforeTest(groups="regression")
	public void beforeTest1Test()
	{
		Reporter.log("beforeTest1",true);
	}
	@AfterTest
	public void afterTest1Test()
	{
		Reporter.log("afterTest1",true);
	}
	@BeforeMethod
	public void beforeMethod1Test()
	{
		Reporter.log("beforeMethod1",true);
	}
	@BeforeMethod
	public void beforeMethod2Test()
	{
		Reporter.log("beforeMethod2",true);
	}
	@AfterMethod
	public void afterMethod1Test()
	{
		Reporter.log("afterMethod1",true);
	}
	@Test
	public void testMethod1()
	{
		Reporter.log("TestMethod1", true);
	}
	@Test
	public void testMethod2()
	{
		Reporter.log("TestMethod2", true);
	}
	

}
