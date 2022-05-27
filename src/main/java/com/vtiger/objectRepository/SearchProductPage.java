package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtilities;

public class SearchProductPage {
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement addproductTxt;
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchproductBtn;
	@FindBy(xpath ="(//a[@href='javascript:window.close();'])[2]")
	private WebElement clickproduct;
	public SearchProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	public void searchProduct(String productName)
	{
		addproductTxt.sendKeys(productName);
	}
	public void clicksearchBtn()
	{
		searchproductBtn.click();
	}
	public void Clickproduct()
	{
		clickproduct.click();
	}

}
