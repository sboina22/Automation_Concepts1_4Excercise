package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_003_ActionsMethods_Mouse {

	public static void main(String[] args) {
		// contextClick(); doubleClick(); DragAndDrop();moveontoElement();
		// perform() is a Mandatory method

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Actions act = new Actions(driver); // Create object of Actions class and pass driver reference to Actions
											// Constructor.

		WebElement elmElectronicsMenu = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[4]/a"));

		// Mouse hover ==>  moveToElement()
		act.moveToElement(elmElectronicsMenu).perform();

		// Right click / Context Click ==> contextClick();
		act.contextClick(elmElectronicsMenu).perform(); 
		
		//Double Click ==> doubleClick();
		act.doubleClick(elmElectronicsMenu).perform();
		
		//Drag And Drop ==> dragAndDrop();
		act.dragAndDrop(WebElement source, WebElement target).perform();
	
	}

}
