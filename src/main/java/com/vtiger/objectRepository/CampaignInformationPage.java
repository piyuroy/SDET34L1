package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	@FindBy(name= "campaignname")
	private WebElement campaignTxt;
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement addproductBtn;
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void addCampaignName(String campaignname)
	{
		campaignTxt.sendKeys(campaignname);
	}
	public void saveCampaignName()
	{
		saveBtn.click();
	}
	public void addProductName()
	{
		addproductBtn.click();
	}
}
