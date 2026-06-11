package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_006_iFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Selenium provides 3 overload methods to switch to Frames,
		// driver.switchTo().frame(index, Name/FrameID, WebElement)

		driver.findElement(By.className("frmTextBox")).clear();
		driver.findElement(By.className("frmTextBox")).sendKeys("Hello entered in Main page");
		String txtboxtMainpg = driver.findElement(By.id("name")).getText();
		System.out.println("I am from Textbox in Main Page ==> " + txtboxtMainpg);

		WebElement elmFrame1 = driver.findElement(By.xpath("//*[@id='frm1']"));
		driver.switchTo().frame("elmFrame1"); 
		System.out.println("I am from Frame 1");
		WebElement elmdrpCourseName = driver.findElement(By.xpath("//*[@id='course']"));
		
		Select drpCourseName = new Select(elmdrpCourseName);
		drpCourseName.selectByVisibleText("Java");

		driver.switchTo().parentFrame();

		driver.close();

	}

}
