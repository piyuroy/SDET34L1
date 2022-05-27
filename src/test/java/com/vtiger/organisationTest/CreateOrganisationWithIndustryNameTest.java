package com.vtiger.organisationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ConstantPath;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.FileUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;
import com.vtiger.objectRepository.CreateOrganisationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganisationNewPage;
import com.vtiger.objectRepository.OrganizationInformationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationWithIndustryNameTest extends BaseClass {
	@Test
	public void createOrganisationWithIndustryNameTest() throws IOException, InterruptedException
	{
		String organization = ExcelUtilities.getDataFromExcel("organization", 1, 1)+randomnumber;
		homepage.clickOrganisation();
	    CreateOrganisationPage organisation = new CreateOrganisationPage(driver);
	    organisation.addOrganisation();
	    OrganisationNewPage newpage = new OrganisationNewPage(driver);
		newpage.addOrganisationName("organisation"+randomnumber);
		WebDriverUtilities.dropDown(newpage.industryDropdown(),"Education");
		WebDriverUtilities.dropDown(newpage.typeDropdown(), "Press");
		newpage.savingData();
		OrganizationInformationPage orginformationpage = new OrganizationInformationPage(driver);
		JavaLibraries.assertionThroughIfCondition(orginformationpage.getOrganizationName(),organization , "Organization");
		
	
	}

}
