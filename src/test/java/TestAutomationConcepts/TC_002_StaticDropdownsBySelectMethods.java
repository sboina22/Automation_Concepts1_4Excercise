package TestAutomationConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_002_StaticDropdownsBySelectMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement drpCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select clsdrpCurrency = new Select(drpCurrency);
		
		/* Using Select Methods - selectByIndex(), selectByVisibleText(), selectByValue() */
		//clsdrpCurrency.selectByIndex(2);
		//clsdrpCurrency.selectByVisibleText("USD");
		//clsdrpCurrency.selectByValue("INR");
		//System.out.println("The selected option : " + clsdrpCurrency.getFirstSelectedOption().getText());
		
		/* Without using Select Methods - using getOptions() of WebElement  */
		List<WebElement> options = clsdrpCurrency.getOptions();
		
		 for (WebElement option : options) {
			 if (option.getText().equals("USD")) {
				 option.click();
				 //System.out.println("The selected option : " + clsdrpCurrency.getFirstSelectedOption().getText());
				 System.out.println("The selected option : " + option.getText());
				 break;
			 }
		 }	
		driver.close();		
	}

}
