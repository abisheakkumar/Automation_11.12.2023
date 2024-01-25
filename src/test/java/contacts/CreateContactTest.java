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
public class CreateContactTest extends BaseClass {
	
	@Test(groups={"SmokeSuite","Smokings","RegressionSuite"})
	public void createContactTest() throws Throwable  {
		//CREATE OBJECT REPOSITORY
//		PropertyFileUtility putil=new PropertyFileUtility();
//		ExcelFileUtility eutil=new ExcelFileUtility();
//		SeleniumUtility sutil=new SeleniumUtility();
		
		//Read all the required data
		
		/* Read the common Data from Property File */
//		String URL=putil.readDataFromPropertyFile("url");
//		String USERNAME=putil.readDataFromPropertyFile("username");
//		String PASSWORD=putil.readDataFromPropertyFile("password");
		
		
		
		/*Read the Test Data from Excel File   */
		 String LASTNAME=eUtil.readDataFromExcel("contact",7 , 0);
		 
		 //Step1: Launch the browser
//		 WebDriverManager.chromedriver().setup();
		 
//		 WebDriver driver=new ChromeDriver();
//		 sutil.maximizeWindow(driver);
//		 sutil.addImplicitlyWait(driver);
		 
		 //Step2: Load the URL
//		 driver.get(URL);
		 
		 //Step3:Login to Application
//		
		 
//		 LoginPage lp=new LoginPage(driver);
//		 lp.loginToApp(USERNAME, PASSWORD);
		 
		 
		 
		 //Step4: Click on contacts link

		 
		 HomePage hp=new HomePage(driver);
		 hp.clickToContacts();
		 

		 
		 //Step5: Click on create_contact_look_Up Image

		 ContactsPage cp=new ContactsPage(driver);
		 cp.clickOnCreateContactlookUpImg();
		 
		 
		 
		 //Step6: Enter mandatory fields and step7:save

		 CreateNewContactPage cncp=new CreateNewContactPage(driver);
		 cncp.createNewContact(LASTNAME, driver);
		 
		 
	
		 //Step8: Validate
		 //Create new contact with mandatory details
		 //Contact is successfully created or not
//		
		 
		 Contacts_InformationPage cip=new Contacts_InformationPage(driver);
		 String contactHeader=cip.captureHeaderText();
		 Assert.assertTrue(contactHeader.contains(LASTNAME));
		 System.out.println(contactHeader);
		 
//		 if(contactHeader.contains(LASTNAME)) {
//			 System.out.println("PASS");
//		 }
//		 else {
//			 System.out.println("FAIL");
//		 }
		 
		 
		 //Step9: Logout of Application
//		
//		 hp.logoutOfApp(driver);
		
		 
		 //Step10: Close the browser
//		 driver.quit();
		 
		
	}
	
	@Test
	public void demoTest()
	{
		//Assert.fail();
		
		//newly pulled
		System.out.println("Hi");
	}
}
