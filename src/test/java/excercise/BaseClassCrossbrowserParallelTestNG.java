package excercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassCrossbrowserParallelTestNG {

	private static ThreadLocal<WebDriver> threadlocaldrivecontainer = new ThreadLocal<>();

	

	public void setThreadLocal(WebDriver driver) {
		threadlocaldrivecontainer.set(driver);
	}

	public WebDriver getThreadLocal() {
		return threadlocaldrivecontainer.get();
	}

	@BeforeMethod
	@Parameters({"browserName", "siteURL"})
	// Pass both parameters into the TestNG annotation array
	
	public void launchApp(String browserName) {

		WebDriver driver;

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			setThreadLocal(driver);
			getThreadLocal().manage().window().maximize();
			getThreadLocal().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getThreadLocal().get("siteURL");
			System.out.println("Current ThreadId >> "+Thread.currentThread().threadId() + " ; "+ "Current ThreadName >>  "+ Thread.currentThread().getName());	
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			setThreadLocal(driver);
			getThreadLocal().manage().window().maximize();
			getThreadLocal().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getThreadLocal().get("siteURL");
			System.out.println("Current ThreadId >> "+Thread.currentThread().threadId() + " ; "+ "Current ThreadName >>  "+ Thread.currentThread().getName());	
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			setThreadLocal(driver);
			getThreadLocal().manage().window().maximize();
			getThreadLocal().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getThreadLocal().get("siteURL");
			System.out.println("Current ThreadId >> "+Thread.currentThread().threadId() + " ; "+ "Current ThreadName >>  "+ Thread.currentThread().getName());	
		} else {
			System.out.println("Invalid browser >> " + browserName);
		}
	}

	@AfterMethod
	public void tearDownApp(WebDriver driver) {
		if (getThreadLocal() != null) {
			getThreadLocal().quit();
			System.out.println("drivers quit successfully completed");
		}
		threadlocaldrivecontainer.remove();
		System.out.println("thread-local cleaned up successfully completed");
	}
}
