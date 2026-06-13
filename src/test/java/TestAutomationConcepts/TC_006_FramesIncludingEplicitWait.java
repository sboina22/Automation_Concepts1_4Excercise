package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_006_FramesIncludingEplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Selenium provides 3 overload methods to switch to Frames,
		// driver.switchTo().frame(index, Name/FrameID, WebElement)

		driver.findElement(By.className("frmTextBox")).clear();
		driver.findElement(By.className("frmTextBox")).sendKeys("Hello entered in Main page");

		/*
		 * Why getAttribute("value") instead of getText()? In web automation, the
		 * getText() method only grabs static text visible between HTML tags (like
		 * <p>Hello</p>). When a user types into an input field or textbox, that data is
		 * temporarily stored in the element's value property, which is why you must
		 * explicitly request the "value" attribute
		 */

		String txtEntered = driver.findElement(By.className("frmTextBox")).getAttribute("value");

		System.out.println("I am from Textbox in Main Page before switch to frame  ==> " + txtEntered);

		//1. Using switchTo().frame(int index / String ID/Name, WebElement element) - 
		//A. Always have risk with Synchronization issues 
		//B. Using switchTo().frame(int index) is risky because frames can be added, deleted, or reordered, which changes their index positions
		
		/*
		WebElement elmFrame1 = driver.findElement(By.id("frm1"));
		driver.switchTo().frame(elmFrame1);
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		 */
		
		//2. Using ExplicitWait()
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frm1"))); 
		
		WebElement elmdrpCourseName = driver.findElement(By.id("course"));
		Select drpCourseName = new Select(elmdrpCourseName);
		drpCourseName.selectByVisibleText("Java");

		driver.switchTo().defaultContent(); // Switch back from the frame to the main/default content.
		driver.findElement(By.className("frmTextBox")).clear();
		driver.findElement(By.className("frmTextBox")).sendKeys("I am entered in main page / default content after switch back from frame to main /default contenet");
		
		String txtUpdated = driver.findElement(By.className("frmTextBox")).getAttribute("value");

		System.out.println("I am from Textbox in Main Page after switch back to main / default content  ==> " + txtUpdated);
		
		// 3. Nested frames
		driver.switchTo().frame("frameNameOrIdorIndexorWebElement"); // Switch to a frame using its Name, ID, Index, or WebElement
		driver.switchTo().parentFrame();         // Switch to the immediate parent frame (one level back)
		driver.switchTo().defaultContent();      // Switch completely out of all frames back to the main/top-level page
		
		//driver.close();

	}

}
