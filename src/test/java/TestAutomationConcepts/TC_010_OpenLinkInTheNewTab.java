package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Opens a link in new tab
public class TC_010_OpenLinkInTheNewTab {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//div[@class=\"constrain\"]/ul[2]/li[1]/a")).click(); // Opens in the same window
		
		String newtab = Keys.chord(Keys.COMMAND,Keys.RETURN); //using chord() method of keys
		driver.findElement(By.xpath("//div[@class=\"constrain\"]/ul[2]/li[1]/a")).sendKeys(newtab); // Opens in new Tab

	}

}
