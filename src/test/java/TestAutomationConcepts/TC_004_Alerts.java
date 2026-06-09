package TestAutomationConcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_004_Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	/*	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		// Simple Alert - one button,Say Ok
		driver.findElement(By.id("alertbtn")).click();
		String alrtMsg1 = driver.switchTo().alert().getText();
		System.out.println("Alert Message ==> " + alrtMsg1);
		Thread.sleep(3000);
		driver.switchTo().alert().accept(); // accept()

		//Confirmation Alert - Two buttons say Ok, Cancel

		driver.findElement(By.xpath("//input[@value=\"Confirm\"]")).click();
		String alrtMsg2 = driver.switchTo().alert().getText(); //getText()
		System.out.println("Alert Message ==> " + alrtMsg2);
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss(); // accept(), dismiss()
		
		*/
		//Prompt Alert - Input Text box , buttons
		
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.findElement(By.id("promptBox")).click();
		Thread.sleep(3000);
		Alert promptalert = driver.switchTo().alert();
		String  alrtMsg3 = promptalert.getText();
		System.out.println("Alert Message ==> " + alrtMsg3);
		promptalert.sendKeys("Boina"); //sendKeys();
		promptalert.accept();
		String msgbox = driver.findElement(By.id("output")).getText();
		System.out.println("Alert Message ==> " + msgbox);
		
		driver.close();
	}

}
