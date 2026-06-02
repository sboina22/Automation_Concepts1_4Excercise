package TestAutomationConcepts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001_CrossBrowserAndParallelTestNGTest {
	WebDriver driver = null;
	@BeforeTest  
	@Parameters("browserName")

	public void setUp(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("The Browser Name from BeforeTest : " + browserName);
			System.out.println("The Thread ID" + Thread.currentThread().threadId());
		} else if (browserName.equalsIgnoreCase("FireFox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("The Browser Name from BeforeTest : " + browserName);
			System.out.println("The Thread ID" + Thread.currentThread().threadId());

		} else if (browserName.equalsIgnoreCase("Safari")) {

			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			//driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("The Browser Name from BeforeTest :" + browserName);
			System.out.println("The Thread ID" + Thread.currentThread().threadId());
		}
	}

	@Test
	
	public void pgChecks() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://www.youtube.com/watch?v=WZfh6v53leA");
		String pgTitle = driver.getTitle();
		String pgURL = driver.getCurrentUrl();
		String pgSource = driver.getPageSource();
		WebElement HTMLLang = driver.findElement(By.tagName("html"));
		String pgLang = HTMLLang.getAttribute("lang");
		System.out.println("The Page Title : " + pgTitle);
		System.out.println("The Page URL : " + pgURL);
		System.out.println("The Page Language : " + pgLang);
		//System.out.println("The Page Source : " + pgSource);
		//System.out.println("The Browser Name from Test : " + browserName); ??
		
		String expTitle = "Selenium Framework";
		Assert.assertEquals(pgTitle.contains("Selenium Framework"), expTitle.contains("WRONGSelenium Framework"));

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test completed successfully ");
	}
	
	
}
