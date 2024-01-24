package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility{//Rule1:
	
	//Rule2:
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	//Rule3:
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule4:

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	//Business Logic
	/**
	 * This method will create a new Contact with Mandatory details
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME,WebDriver driver)
	{
	   LastNameEdt.sendKeys(LASTNAME);
	   scrollActionsDown(driver);
	   saveBtn.click();
	}
	/**
	 * This method will create a new Contact with lead source drop down
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContact(String LASTNAME,String LEADSOURCE,WebDriver driver)
	{
		LastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourceDropDown, LEADSOURCE);
		scrollActionsDown(driver);
		saveBtn.click();
	}
	
	
	

}
