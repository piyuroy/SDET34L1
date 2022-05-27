package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addcontactBtn;
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createContact()
	{
		addcontactBtn.click();
	}

}
