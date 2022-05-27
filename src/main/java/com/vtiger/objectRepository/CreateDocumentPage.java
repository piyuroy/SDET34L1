package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocumentPage {
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addBtn;
	public CreateDocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickDocument()
	{
		addBtn.click();
	}

}
