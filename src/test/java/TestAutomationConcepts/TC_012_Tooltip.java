package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_012_Tooltip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
				
		driver.switchTo().frame(0);
		String ttipTooltip;
		String ttipThemeRoller;
		String ttipYourage;
		
		// Tool tip 
		ttipTooltip =driver.findElement(By.xpath("/html/body/p[1]/a")).getAttribute("title");
		ttipThemeRoller = driver.findElement(By.xpath("/html/body/p[2]/a")).getAttribute("title");
		ttipYourage = driver.findElement(By.id("age")).getAttribute("title");
		
		System.out.println("Tooltip of link ToolTips ==> "+ttipTooltip);
		System.out.println("Tooltip of link ThemeRoller ==> "+ttipThemeRoller);
		System.out.println("Tooltip of input box Your Age ToolTips ==> "+ttipYourage);
		
		driver.quit();
	}

}
