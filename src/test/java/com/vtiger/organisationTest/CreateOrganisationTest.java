package com.vtiger.organisationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;
import com.vtiger.objectRepository.CreateOrganisationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganisationNewPage;
import com.vtiger.objectRepository.OrganizationInformationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest extends BaseClass {
	@Test
	public void createOrganisationTest() throws InterruptedException {
		
		CreateOrganisationPage organisation = new CreateOrganisationPage(driver);
		homepage.clickOrganisation();
		organisation.addOrganisation();
		String organisation1 = ExcelUtilities.getDataFromExcel("organization", 1, 1)+randomnumber;
		OrganisationNewPage newpage = new OrganisationNewPage(driver);
		newpage.addOrganisationName(organisation1+randomnumber);
		newpage.savingData();
		OrganizationInformationPage orginformationpage = new OrganizationInformationPage(driver);
		JavaLibraries.assertionThroughIfCondition(orginformationpage.getOrganizationName(),organisation1,"Organizations");


	}

}
