package excercise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TakeScreenshot extends BaseTests {

	@Test(priority = 1, description = "Checks")
	void pageChecks() {

		SoftAssert softassert = new SoftAssert();

		String expectedPgTitle = "Personal Banking & Netbanking Services | HDFC Bank";
		String expectedPgURL = "https://www.hdfc.bank.in/";
		String pgLang;

		String actualPgTitle = driver.getTitle();
		String actualPgURL = driver.getCurrentUrl();

		System.out.println("The Page Title " + actualPgTitle);
		softassert.assertEquals(actualPgTitle, expectedPgTitle, "Page Title not matched");

		System.out.println("The Page URL " + actualPgURL);
		softassert.assertEquals(actualPgURL, expectedPgURL, "Page URL not matched");

		WebElement elmLang = driver.findElement(By.tagName("html"));
		pgLang = elmLang.getAttribute("lang");
		System.out.println("The page language : " + pgLang);
	}

	
	@Test(priority = 2, description = "Take screenshot - Full page")
	void takeScreenshot() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver; // TakesScreenshot is an Interface and can't create Instance of Methods
		File fsource = ts.getScreenshotAs(OutputType.FILE);
		File fdistination = new File("./Screenshots/Page1.png"); // Create an instance of a File with file path and file
																	// name
		FileUtils.copyFile(fsource, fdistination);
	}

	@Test(priority = 3, description = "Take screenshot - Section / portion / element of the page")
	void takeScreenshotSection() throws IOException {

		WebElement elmHeader = driver.findElement(By.xpath("//div[@class=\"navLevel2Wrapp container\"]")); // any portion / element / image / logo
		File srcfile = elmHeader.getScreenshotAs(OutputType.FILE);
		File dstfile = new File("./Screenshots/Section1.png");
		FileUtils.copyFile(srcfile, dstfile);
	}
}
