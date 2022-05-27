package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

		@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement AddCampaignTab;
		@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Search.gif']")
		private WebElement SearchCampaignTab;
		public CampaignPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		public void AddingCampaign()
		{
			AddCampaignTab.click();
		}
		public void SearchingCampaign()
		{
			SearchCampaignTab.click();
		}
		

	

}
