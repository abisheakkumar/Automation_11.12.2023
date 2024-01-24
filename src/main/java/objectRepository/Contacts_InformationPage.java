package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts_InformationPage {

	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement ContactHeaderText;
	
	public Contacts_InformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	//Business Library
	/**
	 * This method capture the contact header and return it to caller
	 * @return
	 */
	public String captureHeaderText()
	{
		return ContactHeaderText.getText();
	}
}
