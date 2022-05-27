package com.vtiger.practiceTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.ExcelUtilities;

public class TestngPractice3Test {
	@Test(dataProvider ="loginData")
	public void practice2Test(String username, String password)
	{
		Reporter.log(username+"       --- - ---"+password,true);
	}
	@DataProvider
	public Object[][] loginData() throws EncryptedDocumentException, IOException{

		return ExcelUtilities.getMultipleDataFromExcel("loginData", 0, 0);
}
	

}
