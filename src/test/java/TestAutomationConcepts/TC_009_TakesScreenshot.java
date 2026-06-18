package TestAutomationConcepts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_009_TakesScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//Take screenshot - Full page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefileFullscreen = ts.getScreenshotAs(OutputType.FILE); //getScreenshotAs() method call from TakesScreenshot Interface / on driver
		File targetfileFullscreen = new File("./Screenshots/FullPageImage1.png");
		FileUtils.copyFile(sourcefileFullscreen, targetfileFullscreen);
		
		//Take screenshot - Section / portion / element of the page
		WebElement btnSearch = driver.findElement(By.xpath("//*[@id='gh-search-btn']"));
		File sourcefilebtnSearch = btnSearch.getScreenshotAs(OutputType.FILE); // //getScreenshotAs() method call from WebElement Interface, getScreenshotAs() on WebElement
		//File targetfileElementSection = new File("./Screenshots/ElementSectionImage1.png");
		File targetfileElementSection = new File(System.getProperty("user.dir")+"//Screenshots//ElementSectionImage1.png");
		FileUtils.copyFile(sourcefilebtnSearch, targetfileElementSection);
		
		driver.close();
	}

}
