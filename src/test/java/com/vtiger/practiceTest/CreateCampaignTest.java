package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.NewProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass{
	@Test
	public void createCampaignTest()  throws IOException
	{
		
		
		String campaignname = ExcelUtilities.getDataFromExcel("sheet1",5 ,1)+ randomnumber;
	//	WebElement dropdown = driver.findElement(By.xpath("//a[.='More']"));
		homepage.clickCampaign(driver,webdriverutilities);
		homepage.campaign();
		CampaignPage campaign = new CampaignPage(driver);
		campaign.AddingCampaign();
		CampaignInformationPage campinfo= new CampaignInformationPage(driver);
		campinfo.addCampaignName(campaignname+randomnumber);
		homepage.signout(driver,webdriverutilities);
		ExcelUtilities.closeExcel();
		WebDriverUtilities.quitBrowser(driver);
	}

}
