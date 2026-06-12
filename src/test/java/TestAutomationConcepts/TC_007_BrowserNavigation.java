package TestAutomationConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_007_BrowserNavigation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // Instantiate the ChromeDriver

		driver.navigate().to(" ");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

}
