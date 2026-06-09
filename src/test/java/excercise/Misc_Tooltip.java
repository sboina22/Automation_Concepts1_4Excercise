package excercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Misc_Tooltip extends BaseTests{

	@Test(priority = 1, description = "tooltip")
	void tooltip() {
		
		WebElement elm = driver.findElement(By.xpath("//ul[@class='navLevel2 Personal show']//a[@title='Better Money Choices®']"));
		String tooltip = elm.getAttribute("title");
		System.out.println("Tooltip ==> "+ tooltip);
	}
	
}
