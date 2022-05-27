package com.vtiger.campaignTest;

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
import com.vtiger.objectRepository.SearchProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductName extends BaseClass {
	@Test

	public void createCampaignWithProductName() throws Throwable {
		String campaignname = ExcelUtilities.getDataFromExcel("sheet1",5 ,1)+randomnumber;
		String productName = ExcelUtilities.getDataFromExcel("sheet1",6,1)+ randomnumber;
		System.out.println(productName);
		homepage.createProduct();
		NewProductPage newproductpage = new NewProductPage(driver);
		newproductpage.ClickProduct();
		newproductpage.AddingProduct(productName);
		newproductpage.saveData();

		homepage.clickCampaign(driver,webdriverutilities);
		homepage.campaign();
		CampaignPage campaignpage = new CampaignPage(driver);
		campaignpage.AddingCampaign();
		CampaignInformationPage campaigninfo = new CampaignInformationPage(driver);
		campaigninfo.addProductName();
		NewProductPage productpage = new NewProductPage(driver);
		SearchProductPage searchproductpage = new SearchProductPage(driver);
		WebDriverUtilities.switchToWindowBasedOnTitle(driver, "Products&action");
		searchproductpage.searchProduct(productName);
		searchproductpage.clicksearchBtn();
		searchproductpage.Clickproduct();
		WebDriverUtilities.switchToWindowBasedOnTitle(driver, "DetailView&parenttab=Inventory");
		campaigninfo.addCampaignName(campaignname);
		campaigninfo.saveCampaignName();
		




	}

}
