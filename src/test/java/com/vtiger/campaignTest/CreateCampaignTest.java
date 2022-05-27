package com.vtiger.campaignTest;

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
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateCampaignTest extends BaseClass{

	@Test(groups ="sanity" ,description ="testng: Create Campaign Test")
	@Description("Description:- Create Campaign Test")
			@Epic("Epic :- CreateCampaignTest")
			@Story("Story :- Create campaign Test")
			@Step("Step :- Create Campaign Test")
			@Severity(SeverityLevel.BLOCKER)

			public void createCampaignTest()  throws IOException
			{

				ExcelUtilities.OpenExcel(ConstantPath.EXCELFILEPATH);
				String campaignname = ExcelUtilities.getDataFromExcel("sheet1",5 ,1)+randomnumber;
				homepage.clickCampaign(driver, webdriverutilities);
				System.out.println(driver.getTitle());
				JavaLibraries.assertionThroughIfCondition( driver.getTitle(),"Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM", " campaign title is displayed");
				homepage.campaign();
				CampaignPage campaign = new CampaignPage(driver);
				campaign.AddingCampaign();
				CampaignInformationPage campinfo= new CampaignInformationPage(driver);
				campinfo.addCampaignName(campaignname+randomnumber);

			}

}
