package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationNewPage {
	@FindBy(name ="accountname")
	private WebElement organisationTxt;
	@FindBy(name ="button")
	private WebElement saveBtn;
	@FindBy(xpath="(//select[@class='small'])[2]")
	private WebElement industrydropdown;
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typedropdown;
	public OrganisationNewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void addOrganisationName(String organisation)
	{
		organisationTxt.sendKeys(organisation);
	}
	public void savingData()
	{
		saveBtn.click();
	}
	public WebElement industryDropdown()
	{
		return industrydropdown;
	}
	public WebElement typeDropdown()
	{
		return typedropdown;
	}
	

}
