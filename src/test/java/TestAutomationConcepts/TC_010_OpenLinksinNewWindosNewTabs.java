package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Open URLs in multiple tabs & Windows

public class TC_010_OpenLinksinNewWindosNewTabs {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.switchTo().newWindow(WindowType.WINDOW); //Open a New window 
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.ebay.com/");
		

	}

}
