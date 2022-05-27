package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsModulePage {
	@FindBy(name="lastname")
	private WebElement lastnameTxt;
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addcontatctBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savecontactBtn;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgnisationsrcBtn;
	public ContactsModulePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addLastName(String lastname)
	{
		lastnameTxt.sendKeys(lastname);
	}
	public void clickContactDetail()
	{
		addcontatctBtn.click();
	}
	public void clickOrganisation()
	{
		orgnisationsrcBtn.click();
	}
	public void saveContactDetail()
	{
		savecontactBtn.click();
	}

}
