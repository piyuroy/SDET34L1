package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProductPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addproductBtn;
	@FindBy(name="productname")
	private WebElement productNameTxt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement addingBtn;
	public NewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	public void ClickProduct()
	{
		addproductBtn.click();
	}
	public void AddingProduct(String productName)
	{
		productNameTxt.sendKeys(productName);
	}
	public void saveData()
	{
		saveBtn.click();
	}
	public void addData()
	{
		addingBtn.click();
	}
	

}
