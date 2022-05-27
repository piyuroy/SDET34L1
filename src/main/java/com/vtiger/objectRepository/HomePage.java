package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtilities;

public class HomePage {
	@FindBy(linkText="More")
	private WebElement moreDropDown;
	@FindBy(linkText="Campaigns")
	private WebElement campainsTab;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;
	//@FindBy(linkText="Products")
	@FindBy(xpath ="//a[@href='index.php?module=Products&action=index']")
	private WebElement productNameBtn;
	//@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	//@FindBy(xpath ="//a[@href='index.php?module=Contacts&action=index']")
	@FindBy(linkText="Contacts")
	private WebElement ContactsTab;
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement OrganisationTab;
	@FindBy(xpath="//a[@href='index.php?module=Documents&action=index']")
	private WebElement documentBtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickCampaign(WebDriver driver,WebDriverUtilities webdriverutilities)
	{
		webdriverutilities.mouseHoverOntheElement(moreDropDown);
	}
	public void campaign()
	{
		campainsTab.click();
	}
	public void signout(WebDriver driver,WebDriverUtilities webdriverutilities)
	{
		webdriverutilities.mouseHoverOntheElement(administratorIcon);
		signOutBtn.click();
	}
	public void createProduct()
	{
		
		productNameBtn.click();
	}
	public void clickContact()
	{
		ContactsTab.click();;
	}
	public void clickOrganisation()
	{
		OrganisationTab.click();
	}
	public void clickDocument()
	{
		documentBtn.click();
	}

	

}
