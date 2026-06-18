package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//SSL - Secure Socket Layer - Certificate

public class TC_015_ChromeOptions_SSL {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); // Used setAcceptInsecureCerts() method

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String pgTitle = driver.getTitle();
		String pgURL = driver.getCurrentUrl();

		System.out.println("The Page title, URL ==> " + pgTitle + " ' " + pgURL);

		driver.close();

	}

}
