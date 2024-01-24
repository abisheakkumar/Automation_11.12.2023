package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//Rule1
	
	//Rule2: Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement addContactImg;
	
	//Rule3: Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Rule4: Utilization

	public WebElement getAddContactImg() {
		return addContactImg;
	}
	//Rule5: Business Library
	/**
	 * This method will click on create contact look up image of contacts page
	 */
	
	public void clickOnCreateContactlookUpImg()
	{
		addContactImg.click();
	}
	

}
