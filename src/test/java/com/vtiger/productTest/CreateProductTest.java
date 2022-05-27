package com.vtiger.productTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.NewProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass
{
	@Test
	public void createProductTest() throws IOException
	{
		 String productname =FileUtilities.getDataFromPropertyFile("productname");
		homepage.createProduct();
		NewProductPage productpage = new NewProductPage(driver);
		productpage.ClickProduct();
		productpage.AddingProduct(productname+randomnumber);
		productpage.saveData();
		productpage.addData();
		
	}
	

}
