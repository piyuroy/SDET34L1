package com.vtiger.documentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;
import com.vtiger.objectRepository.CreateDocumentPage;
import com.vtiger.objectRepository.CreateNewDocumentPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentEnterTitleTest extends BaseClass {
	@Test
	public void createDocumentEnterTitleTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		String detail = ExcelUtilities.getDataFromExcel("sheet1", 3, 6);
		String title =" pollution";
		homepage.clickDocument();
		CreateDocumentPage createdocument = new CreateDocumentPage(driver);
		createdocument.clickDocument();
		CreateNewDocumentPage createnewpage = new CreateNewDocumentPage(driver);
		createnewpage .addTitleName(title);
		WebDriverUtilities.switchToFrame(driver, 0);
		createnewpage .addDataDetail(detail);
		createnewpage .selectingData();
		 WebDriverUtilities.switchBackFromFrame(driver);
		 createnewpage .wordFontBold();
		 createnewpage .wordUnderlining();
		 createnewpage .uploadDocument();
		 createnewpage .savingData();
		JavaLibraries.threadSleepWait(1000);
		 JavaLibraries.printStatement(driver.getTitle());
		
		
		
			
		
		
		
		
		
		
	}

}
