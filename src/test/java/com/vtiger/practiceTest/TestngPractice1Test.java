package com.vtiger.practiceTest;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngPractice1Test extends TestNgPracticeTest{
	
	@Test(groups="sanity")
	public void pratice1Test()
	{
		Reporter.log("TestngPracticeTest-----Test1",true);
	}
	@Test(groups ="regression")
	public void practice2Test()
	{
		Reporter.log("TestngPractice1Test------------Test2",true);
	}
	@Test(groups={"sanity","regression"})
	public void practice3Test()
	{
		Reporter.log("TestngPractice2Test---------------Test3",true);
	}

}
