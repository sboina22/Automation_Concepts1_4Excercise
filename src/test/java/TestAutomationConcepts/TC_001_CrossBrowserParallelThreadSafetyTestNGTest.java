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

public class TC_001_CrossBrowserParallelThreadSafetyTestNGTest {

	//ThreadLocal ensures each parallel thread maintains its own isolated WebDriver instance

	/* If you intend to run this class in parallel using a TestNG XML configuration (e.g., executing Chrome, Firefox, and Safari threads at the same time), different threads will overwrite this single driver instance. This causes NullPointerExceptions and tests crashing each other.
	To make it thread-safe for parallel testing, you should wrap your driver instance in a ThreadLocal. */
	
	//Encapsulate the WebDriver instance inside a ThreadLocal container
	private static ThreadLocal<WebDriver> threadlocaldriver = new ThreadLocal<>();
	
	private String runningbrowser;
	
	// Bind the initialized driver locally to the current running thread
	public void setDriver(WebDriver driver) {
		threadlocaldriver.set(driver);
	}
	
    // Provide a global getter to access the current thread's driver instance
	public WebDriver getDriver(){
		return threadlocaldriver.get();
 
	}
	
	@BeforeTest  
	@Parameters("browserName") //Get the Parameter Name and Value from the TestNG.xml
	public void setUp(String browserName) {
		this.runningbrowser = browserName; // Save to class variable for use in @Test
		
        // Use a localized variable inside the method scope to prevent cross-thread contamination
		//Local (not global) instance variable 'WebDriver driver' to ensure strict thread safety and prevent cross-thread leaks during parallel execution.
		WebDriver driver=null;
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			setDriver(driver);
			//threadlocaldriver.set(driver);
			//driver.manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
			System.out.println("The Browser Name from BeforeTest : " + browserName);
			System.out.println("The Thread ID" + Thread.currentThread().threadId());
		} else if (browserName.equalsIgnoreCase("FireFox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//driver.manage().deleteAllCookies();
			setDriver(driver);
			getDriver().manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("The Browser Name from BeforeTest : " + browserName);
			System.out.println("The Thread ID" + Thread.currentThread().threadId());

		} else if (browserName.equalsIgnoreCase("Safari")) {

			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			setDriver(driver);
			//driver.manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("The Browser Name from @BeforeTest :" + browserName);
			System.out.println("The Thread ID" + Thread.currentThread().threadId());
		}
	}

	@Test
	public void pgChecks() {
		
		getDriver().get("https://www.youtube.com/watch?v=WZfh6v53leA");
		String pgTitle = getDriver().getTitle();
		String pgURL = getDriver().getCurrentUrl();
		String pgSource = getDriver().getPageSource();
		WebElement HTMLLang = getDriver().findElement(By.tagName("html"));
		String pgLang = HTMLLang.getAttribute("lang");
		System.out.println("The Page Title : " + pgTitle);
		System.out.println("The Page URL : " + pgURL);
		System.out.println("The Page Language : " + pgLang);
		//System.out.println("The Page Source : " + pgSource);
		System.out.println("The Browser Name from @Test : " + runningbrowser);
		
		String expTitle = "Selenium Framework";
		Assert.assertEquals(pgTitle.contains("Selenium Framework"), expTitle.contains("Selenium Framework"));

	}

	@AfterTest
	public void tearDown() {
		//Terminate the isolated driver instance if it exists
		if(getDriver()!=null) {
			getDriver().quit();
		System.out.println("drivers quit successfully completed");
		}
		
		//Clean up the thread-local state to strictly avoid memory leaks
		threadlocaldriver.remove();
		System.out.println("thread-local cleaned up successfully completed");
	}

}
