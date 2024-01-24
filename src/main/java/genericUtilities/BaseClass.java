package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations of TestNG
 * @author Abisheak Kumar V
 *
 */
public class BaseClass {
	
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	
	
	
	public WebDriver driver;
	
	//for listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(groups={"SmokeSuite","Smokings","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("======DB Connection Successful ======");
	}
	
	@BeforeClass(alwaysRun=true)
//	@Parameters("Browser")
//	@BeforeTest
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		String URL=pUtil.readDataFromPropertyFile("url");
		
		driver=new ChromeDriver();
//		if(BROWSER.equalsIgnoreCase("Chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("Edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("Firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		System.out.println("======Browser Launch Successful======");
		
		//For Listeners
		sdriver=driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable
	{
		
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("======Login to App Successfully======");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("======Logout of App Successfully======");
	}
	
	@AfterClass(alwaysRun=true)
//	@AfterTest
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("======Browser closed Successfully======");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("======DB DisConnections Successfully======");
	}

}
