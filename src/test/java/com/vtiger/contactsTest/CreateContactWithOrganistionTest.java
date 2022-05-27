package com.vtiger.contactsTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.sdet34l1.genericUtility.WebDriverUtilities;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactsModulePage;
import com.vtiger.objectRepository.CreateContactPage;
import com.vtiger.objectRepository.CreateOrganisationPage;
import com.vtiger.objectRepository.OrganisationNewPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.SearchOrganisationPage;

public class CreateContactWithOrganistionTest extends BaseClass{
	@Test
	public void createContactWithOrganisatinTest()throws IOException, InterruptedException
	{
		String organisation= ExcelUtilities.getDataFromExcel("sheet1", 3, 5);
		String lastname = ExcelUtilities.getDataFromExcel("sheet1", 3, 4);

		CreateOrganisationPage createorganizastion = new CreateOrganisationPage(driver);
		OrganisationNewPage orgnewpage = new OrganisationNewPage(driver);
		ContactsModulePage contactmodule = new ContactsModulePage(driver);
		OrganizationInformationPage organisationinformationpage = new OrganizationInformationPage(driver);
		CreateContactPage createnewcontact = new CreateContactPage(driver);
		ContactInformationPage contactinformationpage = new ContactInformationPage(driver);
		SearchOrganisationPage searchorganisattionpage = new SearchOrganisationPage(driver);
		
		homepage.clickOrganisation();
		createorganizastion.addOrganisation();
		orgnewpage .addOrganisationName(organisation+randomnumber);
		orgnewpage .savingData();
		organisationinformationpage .waitUntilvisible(driver,webdriverutilities);
		homepage.clickContact();
		createnewcontact.createContact();
		contactmodule .clickContactDetail();
		contactmodule .addLastName(lastname+randomnumber);
		contactmodule.clickOrganisation();
		WebDriverUtilities.switchToWindowBasedOnTitle(driver, "Accounts&action");
	//	searchorganisattionpage.selectOrganisation(organisation, driver);
		searchorganisattionpage.srchOrganisationName(organisation+randomnumber);
		searchorganisattionpage.clickSrchButton();
		searchorganisattionpage.clickOrganisationName();
		WebDriverUtilities.switchToWindowBasedOnTitle(driver, "Contacts&actio");
		contactmodule.saveContactDetail();
		
		JavaLibraries.assertionThroughIfCondition(contactinformationpage.contactLastNameVerify(), lastname, "Contact last name verified");
	}
}


