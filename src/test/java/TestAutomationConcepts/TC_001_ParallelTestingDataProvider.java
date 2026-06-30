package TestAutomationConcepts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001_ParallelTestingDataProvider {

	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password){

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        
		try {
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();		
		
		WebElement linkLogout = driver.findElement(By.xpath("//a[normalize-space()='Log out']"));
		
		boolean stateLogout;
		stateLogout = linkLogout.isDisplayed();
		
		// Let TestNG handle the assertion failure naturally			
		softAssert.assertTrue(stateLogout, "Login failed or Logout link not visible for user: " + username+" , "+ password);
		softAssert.assertAll();
		} finally {
			
			if(driver!=null)
				driver.quit();		
		}
		
	}
	

	@DataProvider(parallel = true, indices= {0,1})
	public String[][] loginData(){
		String[][] data = {
		{"boina.dharmaraju@gmail.com", "Test123@"},
		{"boina.dharmaraju@gmail.com", "Test132@"},
		{"boina.dharmaraju@gmail.com", "Test231@"},
		{"boina.dharmaraju@gmail.com", "Test123@"},
		{"boina.dharmaraju@gmail.com", "Test132@"},
		{"boina.dharmaraju@gmail.com", "Test231@"}
		};
		return data;
	}
	
	
}
