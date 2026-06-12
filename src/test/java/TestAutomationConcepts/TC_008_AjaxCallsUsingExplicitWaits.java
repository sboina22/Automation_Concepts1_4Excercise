package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_008_AjaxCallsUsingExplicitWaits {

	//An AJAX call is a web development technique that allows a website to update a part of its content with out reloading the entire page.
	//AJAX stands for Asynchronous JavaScript and  XML, and it's collection of technologies that make web applications are more responsive for user interactions.
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("loadContent")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elmText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxContent']/h2")));
		
		System.out.println("Dynamic content displayed by Ajax Call ==> " + elmText.getText());
		
		driver.close();
	}

}
