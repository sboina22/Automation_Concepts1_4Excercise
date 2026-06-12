package TestAutomationConcepts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_008_Coockies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//Capture cookies from the browser
		Set<Cookie> coockies = driver.manage().getCookies();
		System.out.println("Number of browser cookies ==> " + coockies.size());

		
		//Print details(Name, Value, Expiration) of each cookie 
		for (Cookie cookie : coockies) {

			System.out.println("Cookie Name, Value and Expire ==> " + cookie.getName() + " : " + cookie.getValue()
					+ " : " + cookie.getExpiry());
		}

		//Add a cookie to the browser
		Cookie customCookie = new Cookie("MyCustomCookies", "1234"); //Create a cookie object
		driver.manage().addCookie(customCookie);
		//driver.navigate().refresh();
		coockies = driver.manage().getCookies(); // Re-fetch the cookies again
		System.out.println("Number of browser cookies after add Custom Cookie ==> " + coockies.size());
		System.out.println("Custom's Cookie Name, Value and Expire ==> " + customCookie.getName() + " : "
				+ customCookie.getValue() + " : " + customCookie.getExpiry());

		//Delete a cookie from the browser using cookie object
		driver.manage().deleteCookie(customCookie);
		coockies = driver.manage().getCookies(); //Re-fetch the cookies again
		System.out.println("Number of browser cookies after delete Custom Cookie ==> " + coockies.size());

		//Delete a cookie from the browser using cookie name
		driver.manage().deleteCookieNamed("__uzmfj2");
		coockies = driver.manage().getCookies(); //Re-fetch the cookies again
		System.out.println("Number of browser cookies after delete named Cookie ==> " + coockies.size());
		
		driver.close();
	}

}
