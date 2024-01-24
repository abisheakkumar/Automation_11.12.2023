package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactsPage;
import objectRepository.Contacts_InformationPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Scenario1WithDdtAndGenericUtility {
	
	public static void main(String[] args) throws Throwable  {
		//CREATE OBJECT REPOSITORY
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		SeleniumUtility sutil=new SeleniumUtility();
		
		//Read all the required data
		
		/* Read the common Data from Property File */
		String URL=putil.readDataFromPropertyFile("url");
		String USERNAME=putil.readDataFromPropertyFile("username");
		String PASSWORD=putil.readDataFromPropertyFile("password");
		
		
		
		/*Read the Test Data from Excel File   */
		 String LASTNAME=eutil.readDataFromExcel("contact",7 , 0);
		 
		 //Step1: Launch the browser
		 WebDriverManager.chromedriver().setup();
		 
		 WebDriver driver=new ChromeDriver();
		 sutil.maximizeWindow(driver);
		 sutil.addImplicitlyWait(driver);
		 
		 //Step2: Load the URL
		 driver.get(URL);
		 
		 //Step3:Login to Application
//		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		 driver.findElement(By.id("submitButton")).click();
		 
		 LoginPage lp=new LoginPage(driver);
		 lp.loginToApp(USERNAME, PASSWORD);
		 
//		 lp.getUsernameEdt().sendKeys(USERNAME);
//		 lp.getPasswordEdt().sendKeys(PASSWORD);
//		 lp.getLoginButtonEdt().click();
		 
		 
		 //Step4: Click on contacts link
//		 driver.findElement(By.linkText("Contacts")).click();
		 
		 HomePage hp=new HomePage(driver);
		 hp.clickToContacts();
		 
//		 hp.getContactsClick().click();
		 
		 //Step5: Click on create_contact_look_Up Image
//		 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 ContactsPage cp=new ContactsPage(driver);
		 cp.clickOnCreateContactlookUpImg();
		 
		 
		 
		 //Step6: Enter mandatory fields
//		 driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		 CreateNewContactPage cncp=new CreateNewContactPage(driver);
		 cncp.createNewContact(LASTNAME, driver);
		 
		 
		 //Step7: Save
//		 sutil.scrollActionsDown(driver);
//		 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		 
		 //Step8: Validate
		 //Create new contact with mandatory details
		 //Contact is successfully created or not
//		 String contactHeader=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
//		 System.out.println(contactHeader);
		 
		 Contacts_InformationPage cip=new Contacts_InformationPage(driver);
		 String contactHeader=cip.captureHeaderText();
		 System.out.println(contactHeader);
		 
		 if(contactHeader.contains(LASTNAME)) {
			 System.out.println("PASS");
		 }
		 else {
			 System.out.println("FAIL");
		 }
		 
		 //Step9: Logout of Application
//		 WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		 sutil.mouseOverAction(driver, ele);
//		 Thread.sleep(1000);
//		 driver.findElement(By.linkText("Sign Out")).click();
		 hp.logoutOfApp(driver);
		 
		 
		 //Step10: Close the browser
		 driver.quit();
		 
		
	}
}
