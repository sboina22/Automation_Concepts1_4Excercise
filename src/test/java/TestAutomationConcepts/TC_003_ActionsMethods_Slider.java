package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_003_ActionsMethods_Slider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement slider_min = driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));
		WebElement slider_max = driver.findElement(By.xpath("//*[@id='slider-range']/span[2]"));

		System.out.println("Size (Height & Width) of slider_min ==> " + slider_min.getSize());
		System.out.println("Location of slider_min before drag and drop  ==> " + slider_min.getLocation());
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider_min, 100, 0).perform();
		System.out.println("Location of slider_min after drag and drop ==> " + slider_min.getLocation());
		
		act.dragAndDropBy(slider_max, -100, 0).perform();
		System.out.println("Location of slider_max after drag and drop ==> " + slider_max.getLocation());
		
	}

}
