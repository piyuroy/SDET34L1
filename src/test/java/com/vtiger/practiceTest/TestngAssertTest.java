package com.vtiger.practiceTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngAssertTest {
	@Test(retryAnalyzer =com.sdet34l1.genericUtility.RetryAnalyserImplementation.class)
	public void practice1Test()
	{
		Reporter.log("a-practical",true);
		Reporter.log("b-practical",true);
		Reporter.log("c-practical",true);
		Reporter.log("d-practical",true);
		Reporter.log("e-practical",true);
		Reporter.log("f-practical",true);
	}
	@Test
	public void practice2Test()
	{
		Reporter.log("e-practica2",true);
		Reporter.log("d-practica2",true);
		Reporter.log("c-practica2",true);
		Reporter.log("b-practica2",true);
		Reporter.log("a-practica2",true);
		
	}

}
