package com.vtiger.contactsTest;


import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.ExcelUtilities;
import com.sdet34l1.genericUtility.JavaLibraries;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactsModulePage;



public class CreateContactsTest extends BaseClass{
	@Test(groups ="sanity")

	public void createContactsTest() throws IOException {
		String lastname = ExcelUtilities.getDataFromExcel("sheet1", 3, 4)+randomnumber;

		ContactsModulePage contact = new ContactsModulePage(driver);
		ContactInformationPage contactinformationpage = new ContactInformationPage(driver);
		
		homepage.clickContact();
		contact.clickContactDetail();
		contact.addLastName(lastname+randomnumber);
		contact.saveContactDetail();
		
		JavaLibraries.assertionThroughIfCondition(contactinformationpage.contactLastNameVerify(), lastname, "Contact last name verified");


	}

}
