package TestAutomationConcepts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_005_WindowHandles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String parentWindowHandle = driver.getWindowHandle(); //getWindowHandle()
		System.out.println("ParentWindow Handle ==> " + parentWindowHandle);
		System.out.println("ParentWindow Title ==> " + driver.getTitle());

		driver.findElement(By.xpath("//*[@id='newWindowBtn']")).click();

		Set<String> childWindowHandles = driver.getWindowHandles(); // /getWindowHandles() Includes parent window

		// To exclude parent window and work on only child windows
		for (String childWindowhandle : childWindowHandles) {

			if (!childWindowhandle.equals(parentWindowHandle)) {

				driver.switchTo().window(childWindowhandle); // switchTo.Window()
				System.out.println("ChildWindow Title ==> " + driver.getTitle());
				//Child window code here ..
				driver.close(); // Closes the current child window
			}

		}
		driver.switchTo().window(parentWindowHandle); // Switch to parent window explicitly after close the child window
		System.out.println("ParentWindow Title after switch from child window ==> " + driver.getTitle());

		driver.quit(); // To quit from all browsers and driver
	}

}
