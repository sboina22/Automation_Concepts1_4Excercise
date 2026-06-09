package excercise;

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
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links in page ===> " + links.size()); //size()
		
		int brokenlinkcount =0 ;
		
		for (WebElement element : links) {
			String href = element.getAttribute("href");
			if (href == null || href.isEmpty()) {

				System.out.println("URL is empty or missing href attribute.");
				continue;
			}

			if (href.startsWith("javascript:") || href.startsWith("mailto:") || href.startsWith("tel:")) {
				System.out.println("Skipping non-HTTP link: " + href);
				continue;
			}

			try {

				URL linkuRL = new URL(href); // convert href value from String to URL object
				HttpURLConnection connection = (HttpURLConnection) linkuRL.openConnection(); // Open connection to the
																								// server
				connection.setRequestMethod("HEAD"); // Optional optimization: faster than GET
				connection.connect();// Connect to the server

				int code = connection.getResponseCode();
				String resMessage = connection.getResponseMessage();
				String textlink = element.getText();

				if (code >= 400) {
					System.out.println(textlink + " Broken link.====>>  " + href + "  - The response code &  message  : " + code
							+ " -  " + resMessage);
					
				brokenlinkcount++;
				
					
				} else {
					System.out.println(textlink + " Valid link.====>>  " + href + "  - The response code &  message  : " + code
							+ " -  " + resMessage);
				}
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Number of broken links ===>  " + brokenlinkcount);
		
		driver.close();

	}

	
}
