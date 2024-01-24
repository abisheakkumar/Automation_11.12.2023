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
public class CreateContactTest1 extends BaseClass {
	
	@Test(groups={"SmokeSuite","Smokings","RegressionSuite"})
	public void createContactTest1() throws Throwable
	{
		//Read all the required data
		//Read the TestData from Excel File
		String LASTNAME=eUtil.readDataFromExcel("contact", 9, 0);
		
		//Step1: Click on contacts link
		HomePage hp=new HomePage(driver);
		hp.clickToContacts();
		
		//Step2: Click on create-contact-look-up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactlookUpImg();
		
		//Step3: Create new Contact with mandatory fields
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, driver);
		
		//Step4: Validate
		Contacts_InformationPage cip=new Contacts_InformationPage(driver);
		String contactHeader=cip.captureHeaderText();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
		
		
	}
	
	@Test
	public void demoTest()
	{
		Assert.fail();
		System.out.println("Hi");
	}
}
