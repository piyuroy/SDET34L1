package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtilities;

public class OrganizationInformationPage {
	@FindBy(id="dtlview_Organization Name")
	private WebElement organizationNameTxt;
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String getOrganizationName()
	{
		return organizationNameTxt.getText();
	}
	 public void waitUntilvisible(WebDriver driver,WebDriverUtilities webdriverutilities) {
		 webdriverutilities.explicitWaitUntillElementvisible(driver,10 , organizationNameTxt);
		 
	 }

}
