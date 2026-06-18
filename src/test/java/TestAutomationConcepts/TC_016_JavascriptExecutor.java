package TestAutomationConcepts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Utilities.JavascriptExecutorUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_016_JavascriptExecutor {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Syntax
		// JavascriptExecutor js =(JavascriptExecutor) driver;
		// js.executeScript(String script, Object args say WebElement obj);

		driver.get("https://www.ebay.com/");
		//driver.get("https://orangehrm.com/30-day-free-trial"); //URL for ScrollDown and ScrollUp
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
/*
		// Drawing border & Take screenshot
		WebElement logo = driver.findElement(By.id("gh-logo"));
		JavascriptExecutorUtilities.drawBoarder(logo, driver); // Call the user defined methods from the Utilities class

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File trgFile = new File("./Screenshots/jsElement1.png");
		FileUtils.copyFile(srcFile, trgFile);

		// Flash

		//Fetching Page Details - Title of the Page
		String title = JavascriptExecutorUtilities.getPageTitleByJS(driver);
		System.out.println("Title of the page ==> " + title);

		//Fetching Page Details -  URL of the Page
		String url = JavascriptExecutorUtilities.getPageURLByJS(driver);
		System.out.println("URL of the page ==> " + url);

		// Generate alert
		JavascriptExecutorUtilities.generateJSAlert("This message is for AI", driver);
		

		// Click action
		WebElement btnSearch = driver.findElement(By.id("gh-search-btn"));
		JavascriptExecutorUtilities.clickElementByJS(btnSearch, driver);

		SoftAssert softassert = new SoftAssert();
		String actTitle = driver.getTitle();
		String expTitle = "Shop by Category | eBay_Fail";
		softassert.assertEquals(expTitle, actTitle, "Mismatched Page title. Actual Page title is ==> ");
		System.out.println("All Categories Page Title ==> "+ actTitle);
		softassert.assertAll();

		// Refreshing the page
		JavascriptExecutorUtilities.refreshBroswerByJS(driver);



		// Scroll down a page
		JavascriptExecutorUtilities.scrollPageDown(driver);
	
		Thread.sleep(4000);
		
		// Scroll up page
		JavascriptExecutorUtilities.scrollPageup(driver);
*/		
		// Zoom page
		//JavascriptExecutorUtilities.zoomPage(driver);
		
		//Scroll into element view
		WebElement linkGetTheCoupon = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/aside[3]/div/div[1]/a"));
		String linkTextGetTheCoupon = linkGetTheCoupon.getText();
		System.out.println("Label Learn More button ==> "+linkTextGetTheCoupon);
		JavascriptExecutorUtilities.scrollInToElementView(linkGetTheCoupon, driver);
		
		//driver.close();
	}

}
