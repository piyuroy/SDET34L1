package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOrganisationPage {
	@FindBy(xpath ="//input[@class='txtBox']")
	private WebElement searchboxTxt;
	@FindBy(xpath ="//input[@class='crmbutton small create']")
	private WebElement searchBtn;
	@FindBy(linkText ="Org_name_")
	private WebElement orgnameBtn;
	public SearchOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	public void selectOrganisation(String organisation , WebDriver driver)
//	{
//		searchboxTxt.sendKeys(organisation);
//		searchBtn.click();
//		driver.findElement(By.xpath("//a[text()='"+organisation+"']")).click();
//	}
	public void srchOrganisationName(String organisation)
	{
		searchboxTxt.sendKeys(organisation);
	}
	public void clickSrchButton()
	{
		searchBtn.click();
	}
	public void clickOrganisationName()
	{
		orgnameBtn.click();
	}

}
