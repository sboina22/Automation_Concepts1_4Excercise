package excercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	
	
	public static WebDriver driver;
	
	@BeforeSuite
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}

	@AfterSuite
	public void closeBrowser(){
		driver.quit();
	}
	
	
}
