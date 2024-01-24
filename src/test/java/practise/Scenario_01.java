package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario_01 {
	public static void main(String[] args)throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http:localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
//		WebElement ele=driver.findElement(By.xpath("//a[text()='More']"));
//		Actions act=new Actions(driver);
//		
//	    act.moveToElement(ele);
		driver.findElement(By.xpath("//a[text()='More']")).click();
	    
	    driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		
		
	}

}
