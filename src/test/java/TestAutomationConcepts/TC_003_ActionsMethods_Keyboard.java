package TestAutomationConcepts;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_003_ActionsMethods_Keyboard {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/client/#/auth/register");
		driver.manage().window().maximize();
		String pgTitle = driver.getTitle();
		String pgURL = driver.getCurrentUrl();
		String pgSource = driver.getPageSource();

		WebElement elmHTML = driver.findElement(By.tagName("html"));
		String pgLang = elmHTML.getAttribute("lang");

		WebElement txtFirstname = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement txtLastname = driver.findElement(By.xpath("///input[@id='lastName']"));
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
		WebElement txtPhoneNumber = driver.findElement(By.xpath("//input[@id='userMobile']]"));
		WebElement rbtnMale = driver.findElement(By.xpath("//input[@value='Male']"));
		WebElement rbtnFemale = driver.findElement(By.xpath("//input[@value='Female']]"));
		WebElement chkAge = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement btnRegister = driver.findElement(By.xpath("//input[@type='checkbox']"));

		System.out.println("The Current Page Title : " + pgTitle);
		System.out.println("The Current Page URL : " + pgURL);
		System.out.println("The Current Page Language : " + pgLang);

		/*
		 * System.out.println("Register button displayed  : "+
		 * btnRegister.isDisplayed()); System.out.println("Register button enabled  : "+
		 * btnRegister.isEnabled()); System.out.println("Male option is selected   : "+
		 * rbtnMale.isSelected()); System.out.println("Female option is selected   : "+
		 * rbtnFemale.isSelected());
		 * System.out.println("'I am 18 year or Older' is selected  : "+
		 * rbtnFemale.isSelected());
		 * 
		 * btnRegister.submit();
		 * 
		 */

		driver.close();
	}

}

//Asserts Assert = new Asserts(driver);

/*
 * 
 * WebDriver driver = new ChromeDriver(); Create an instance of ChromeDriver
 * class (I.e Create an Object) using "New" Keyword and assign/storing in a
 * variable called "driver", which is of type "WebDriver" Interface.
 **** 
 * iSElement Displayed / Enabled / Selected **** .isDisplayed() .isEnabled()
 * isSelected()
 ***** 
 * Actions Keyboard Methods***** Actions act = new Actions(driver);
 * act.sendKeys(Keys.TAB).perform();
 * act.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).
 * build().perform(); act.sendKeys(Keys.TAB).perform();
 * act.keyDown(Keys.CONTROL).sendKeys("v").build().perform(); Control - Windows;
 * Command - MacOS
 **** 
 * Navigate Methods **** driver.navigate().to(pgURL); driver.navigate().back();
 * driver.navigate().forward(); driver.navigate().refresh();
 *** 
 * 
 * Using Select Methods - selectByIndex(), selectByVisibleText(),
 * selectByValue(), getFirstSelectedOption(), getOptions() WebElement
 * drpCurrency =
 * driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); Select
 * clsdrpCurrency = new Select(drpCurrency); clsdrpCurrency.selectByIndex(2);
 * clsdrpCurrency.selectByVisibleText("USD");
 * clsdrpCurrency.selectByValue("INR");
 * System.out.println("The selected option : " +
 * clsdrpCurrency.getFirstSelectedOption().getText());
 */

/*
 * txtUsername.clear(); txtUsername.sendKeys("sboina29"); Actions act = new
 * Actions(driver);
 * act.keyDown(Keys.COMMAND).sendKeys("a").sendKeys("c").keyUp(Keys.COMMAND).
 * build().perform(); act.sendKeys(Keys.TAB).perform();
 * act.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build().perform()
 * ; System.out.println("The name entered into First Name  : "+
 * txtFirstname.getAttribute("value"));
 */
