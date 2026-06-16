package TestAutomationConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_012_SizeAndLocationOfElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
		//WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
				
		//Location - Method 1
		
		System.out.println("Location - Method 1 =====> ");
		System.out.println("location(x,y) ==>  "+ logo.getLocation()); //Top left corner of the element
		System.out.println("location(x) ==>  " + logo.getLocation().getX());
		System.out.println("location(y) ==>  " + logo.getLocation().getY());
		
		//Location - Method 2 
		System.out.println("Location - Method 2 =====> ");
		System.out.println("location(x) ==>  " + logo.getRect().getX());
		System.out.println("location(y) ==>  " + logo.getRect().getY());
		
		//Size Method 1
		System.out.println("Size - Method 1 =====> ");
		System.out.println("Size (Width,Height) ==>  "+ logo.getSize());
		System.out.println("Size (Width) ==>  " + logo.getSize().getWidth());
		System.out.println("Size (Height) ==>  " + logo.getSize().getHeight());
		
		
		//Size Method 2
		System.out.println("Size - Method 2 =====> ");
		System.out.println("Size (Width,Height) ==>  "+ logo.getRect().getDimension());
		System.out.println("Size (Width) ==>  " + logo.getRect().getDimension().getWidth());
		System.out.println("Size (Height) ==>  " + logo.getRect().getDimension().getHeight());
		
		driver.close();
	}

}
