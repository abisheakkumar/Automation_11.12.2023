package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("http:localhost:8888/");
		driver.manage().window().maximize();
		
	}
}
