package excercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	
	
	public static WebDriver driver;
	
	@BeforeSuite
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	
	@Test(priority =1,description ="Launch Application")
	public void launchApplication() {
		driver.get("https://www.hdfc.bank.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterSuite
	public void closeBrowser(){
		driver.quit();
	}
	
	
}
