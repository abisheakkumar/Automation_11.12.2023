package contacts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsPage;
import objectRepository.Contacts_InformationPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactWithLeadSource1 extends BaseClass {
	@Test(groups={"SmokeSuite","Smokings","RegressionSuite"})
	public void createContactWithLeadSource1() throws Throwable
	{
		//Read all the required data
		//Read the Test data from excel file
		String LASTNAME=eUtil.readDataFromExcel("contact", 10, 0);
		String LEADSOURCE=eUtil.readDataFromExcel("contact", 1, 1);
		
		
		//Step1: Click on contacts link
		HomePage hp=new HomePage(driver);
		hp.clickToContacts();
		
		//Step2: Click on create-contact-lookup-image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactlookUpImg();
		
		//Step3: Create New Contact with Mandatory fields
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE, driver);
		
		//Step4: Validate
		Contacts_InformationPage cip=new Contacts_InformationPage(driver);
		String contactHeader=cip.captureHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
		
	}
	
	@Test
	public void demoTest()
	{
		//Assert.fail();
		System.out.println("Hi");
	}
}
