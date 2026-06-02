package TestAutomationConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_002_HandlingMultipleStaticDropdowns {
	static WebDriver driver; // As driver is using in other methods, make the driver as Global Variable and
							// define inside the class, main() is a static method, define driver as a static

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // Instantiate the ChromeDriver
		driver.get("https://spiceclub.spicejet.com/signup");
		driver.manage().window().maximize();

		WebElement drpTitle =driver.findElement(By.xpath("(//select[@class='form-control form-select '])[1]"));
		drpOptionSelection(drpTitle, "Mrs" );

		//WebElement drpCountry = driver.findElement(By.xpath("//*[@id=\\\"react-root\\\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/select"));
		//drpOptionSelection(drpCountry, "United Kingdom");

	}

	public static void drpOptionSelection(WebElement lstEle, String lstItem) {

		Select sltElm = new Select(lstEle);
		List<WebElement> Options = sltElm.getOptions();
		for (WebElement Option : Options) {
			if (Option.getText().equals(lstItem))
			//if (Option.getText().trim().equals(lstItem.trim())) 
			//if (Option.getAttribute("textContent").equals(lstItem)) 
			{
				Option.click();
				System.out.println("The selected option : " + Option.getText());
				break;
			}
		}

	}

}
