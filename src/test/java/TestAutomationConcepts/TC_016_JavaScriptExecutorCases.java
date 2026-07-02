package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_016_JavaScriptExecutorCases {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;

//Title
		String script = "return document.title;";
		String title = (String) js.executeScript(script);
		System.out.println("Page title >> " + title);

//Click
		driver.switchTo().frame("iframeResult");
		js.executeScript("myFunction();");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

//border
		WebElement btnTryit = driver.findElement(By.xpath("/html/body/button"));
		js.executeScript("arguments[0].style.border = '5px solid green'", btnTryit);

//scrollToView
		driver.navigate().to("https://www.w3schools.com/");
		WebElement btnLearnHowTo = driver.findElement(By.xpath("//*[@id=\"howto_padding\"]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", btnLearnHowTo);
	}

}
