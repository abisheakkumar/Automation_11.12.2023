package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {// Rule1
	
	
	//Rule2: Declaration
	@FindBy(linkText="Contacts")
	private WebElement contactsClick;
	
	@FindBy(linkText="Calendar")
	private WebElement calenderClick;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationClick;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesClick;
	
	@FindBy(linkText="Products")
	private WebElement productsClick;
	
	@FindBy(linkText="Documents")
	private WebElement documentClick;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignClick;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	
	


	//Rule3: Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule4: Utilization
	public WebElement getContactsClick() {
		return contactsClick;
	}

	public WebElement getCalenderClick() {
		return calenderClick;
	}

	public WebElement getOrganizationClick() {
		return organizationClick;
	}

	public WebElement getOpportunitiesClick() {
		return opportunitiesClick;
	}

	public WebElement getProductsClick() {
		return productsClick;
	}

	public WebElement getDocumentClick() {
		return documentClick;
	}

	public WebElement getCampaignClick() {
		return campaignClick;
	}
	
	public WebElement getAdministratorLink() {
		return administratorLink;
	}


	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
	//Business Library- Generic Method
	
	public void clickToContacts()
	{
		contactsClick.click();
	}
	
	/**
	 * This method will logout of Application
	 * @param driver
	 * @throws InterruptedException
	 */
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver,administratorLink);
		Thread.sleep(1000);
		signoutLink.click();
	}


//	private void mouseOverAction(WebDriver driver, WebElement administratorLink2) {
//		// TODO Auto-generated method stub
//		
//	}
	

}
