package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_015_ChromeOptions {

	// Headless Testing - With out UI, runs in backend /apis, only can see the results. Faster, Can perform Parallel activities(since execution happens in backend)
	// Tests are completed, Build is stable, execution is happening properly in QA environment, push the code to remote repositories, run the automation in devops environment, many phases /cycles
	// To execute the scripts in (CI/CD) devops environment on Jenkins, as they won't need UI. Faster
	
	public static void main(String[] args) {
		
	
		//Chrome is being controlled by automated test software

		ChromeOptions options = new ChromeOptions(); // based on the browser/driver
		// FirefoxOptions options = new FirefoxOptions();
		// EdgeOptions options = new EdgeOptions();

		options.addArguments("--headless=new"); // Executes the scripts in headless mode
		// options.addArguments("--disable-notifications", "--start-maximized", "--incognito"); //Disable browser notifications, start maximized, open incognito mode
		// options.setAcceptInsecureCerts(true); // Web site accepts SSL Certificates
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		
		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver = new FirefoxDriver(options);

		// WebDriverManager.edgedriver().setup();
		// WebDriver driver = new EdgeDriver(options);

		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String pgTitle = driver.getTitle();
		String pgURL = driver.getCurrentUrl();

		System.out.println("The Page title, URL ==> " + pgTitle + " ' " + pgURL);

		driver.close();
	}

}
