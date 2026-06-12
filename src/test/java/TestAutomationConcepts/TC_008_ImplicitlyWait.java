package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_008_ImplicitlyWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		// Implicit Wait: Directs the WebDriver to wait for a specified duration for elements to appear before throwing a NoSuchElementException. 
		//Applicable for all elements in the script.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		Actions act = new Actions(driver);
		WebElement elmElectronicsMenu = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[4]/a"));
		act.moveToElement(elmElectronicsMenu).perform();
		
	
		
	}

}
