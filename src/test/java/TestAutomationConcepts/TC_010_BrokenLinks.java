package TestAutomationConcepts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_010_BrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
      
		// 2. Navigate to your target website
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        // 3. Collect all anchor elements on the page
		List<WebElement> elmlinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of links ==> "+elmlinks.size());  //size()
		
		int brokenlinksCount = 0;
		int validlinksCount = 0;
		
		// 4. Iterate and check each link
		for (WebElement elmLink : elmlinks) {

			String link = elmLink.getAttribute("href");
	      
			// Skip null, empty, or javascript:void(0) void links to avoid runtime crashes 
			if(link==null || link.isBlank()) {
				System.out.println("link is empty or missing href attribute.");
				continue;
			}
			if (link.startsWith("tel:") || link.startsWith("mailto:") || link.startsWith("javascript:"))  {
					System.out.println("non-http link ==>  " + link);
					continue;
				}
			
			
			try { // Wrapping network activity inside try-catch saves the program from crashing

	            // Create a URL object and open a network connection
				URL linkuRL = new URL(link); // convert href value from String to URL object
				HttpURLConnection connection = (HttpURLConnection) linkuRL.openConnection(); // Open connection to the server
				
	            // Optimization: Use HEAD request to save bandwidth (only fetches headers, not page body)
				connection.setRequestMethod("HEAD"); // Optional optimization: faster than GET
				connection.setConnectTimeout(5000); // Stop it from hanging forever if a server is dead
				connection.connect(); // Connect to the server

			int resCode = connection.getResponseCode();
			String resMessage = connection.getResponseMessage();
			String txtLink = elmLink.getText();
			
            // Status codes >= 400 indicate client or server errors (broken links)
			if (resCode >= 400) {
					System.out.println("Broken link, Response code, Respnse message, link text, href ==>   " +resCode
							+ "  , " + resMessage + "  , " + txtLink +" , "+ link);
					brokenlinksCount++;

				} else{
					System.out.println("valid link, Response code, Respnse message, link text, href ==>   " +resCode
							+ "  , " + resMessage + "  , " + txtLink +" , "+ link);
				validlinksCount++;
			} connection.disconnect();
			} catch(Exception e) {
			// If a URL is completely dead, log it as broken and let the loop CONTINUE
			System.out.println(" Network error for link ==> " + link+"  "+ e.getMessage());
			brokenlinksCount++;
			}
			}

	System.out.println("\n=================================");
	System.out.println("FINAL Count of broken links ==> "+brokenlinksCount);
	System.out.println("FINAL Count of valid links ==> "+validlinksCount);
	driver.quit();


	}
	}
