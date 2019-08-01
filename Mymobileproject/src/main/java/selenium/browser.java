package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class browser {
	public void initiatebrowser() {

	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.get("http://www.google.com");
	System.out.println(driver.getTitle());
	
}
}