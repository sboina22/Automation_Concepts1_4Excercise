package TestAutomationConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Authentication Pop-Ups

//These HTTP Authentication pop ups are from browsers and are not from the Web application, so standard Selenium WebDriver alert handling or element interaction will not work on them. Instead, we bypass the pop-up by passing the credentials directly into the URL.
		
public class TC_004_Alerts_AuthenticationPopUps {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); // Syntax : driver.get(http://UserName:Password@URL); bypasses the pop-up
		driver.manage().window().maximize();
		String txtSuccessMessage = driver.findElement(By.xpath("//*[@id='content']/div/p")).getText();
		System.out.println("Success message ==> "+ txtSuccessMessage);
		driver.close();
	}

}
