package com.vtiger.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDocumentPage {
	@FindBy(name ="notes_title")
	private WebElement titleTxt;
	@FindBy(xpath ="//body[@class='cke_show_borders']")
	private WebElement dataTxt;
	@FindBy(xpath ="//a[@title='Bold']")
	private WebElement boldBtn;
	@FindBy(xpath ="//a[@title='Underline']")
	private WebElement underlineBtn;
	@FindBy(xpath ="filename_I__")
	private WebElement uploadBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(id="filename_I__")
	private WebElement sendTxt;
	public CreateNewDocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void addTitleName(String title)
	{
		titleTxt.sendKeys(title);
	}
	public void addDataDetail(String detail)
	{
		dataTxt.sendKeys(detail);
	}
	public void selectingData()
	{
		
		dataTxt.sendKeys(Keys.CONTROL+"a");
	}
	public void wordFontBold()
	{
		boldBtn.click();
	}
	public void wordUnderlining()
	{
		underlineBtn.click();
	}
	public void uploadingDocument(String path)
	{
		uploadBtn.sendKeys(path);
	}
	public void savingData()
	{
		saveBtn.click();
	}
	public void uploadDocument()
	{
		sendTxt.sendKeys("C:\\Users\\Avinash\\Desktop\\yoyo\\epfo1\\Application Form Preview.pdf");
	}
	
	
	
	
	

}
