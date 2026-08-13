package excercise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BrokenLinks2 {

	static List<String> goodlinks = new ArrayList<>();
	static List<String> badlinks = new ArrayList<>();

	public static void main(String[] args) {
		long startime = System.currentTimeMillis();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.navigate().to("http://www.deadlinkcity.com/");
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		verifyBrokenLinks(links);

		System.out.println("\n=========== Result Summary ===========");

		System.out.println("Number of links o page ===> " + links.size()); // size()
	

		System.out.println("\n--------------------------------------");
		System.out.println("          GOOD / VALID LINKS          ");
		System.out.println("--------------------------------------");
		System.out.println("Total good links ==> " + goodlinks.size());
		if (goodlinks.isEmpty()) {
			System.out.println("No good links found.");
		} else {
			for (String link : goodlinks) {
				System.out.println("[Good] " + link);

			}
		}

		System.out.println("\n--------------------------------------");
		System.out.println("         BAD / BROKEN LINKS           ");
		System.out.println("--------------------------------------");
		System.out.println("Total broken links ==> " + badlinks.size());
		if (badlinks.isEmpty()) {
			System.out.println("No broken links found.");
		} else {
			for (String link : badlinks) {
				System.out.println("[Bad/Broken]  " + link);
			}
		}

		driver.quit();
		// End timer and calculate execution time
		long endTime = System.currentTimeMillis();
		long totalTimeMillis = endTime - startime;
		double totalTimeSeconds = totalTimeMillis / 1000.0;

		System.out.println("\n======================================");
		System.out.println("Total Execution Time: " + totalTimeSeconds + " seconds (" + totalTimeMillis + " ms)");
		System.out.println("======================================");
	}

	public static void verifyBrokenLinks(List<WebElement> links) {
		for (WebElement element : links) {
			String href = element.getAttribute("href");
			
			if (href == null || href.isEmpty()) {

				System.out.println("Skipped] Missing or empty href for:  " + href);
			
				continue;
			}

			if (href.startsWith("javascript:") || href.startsWith("mailto:") || href.startsWith("tel:")) {
				System.out.println("[Skipped] Non-HTTP link: " + href);
      
				continue;
			}

			try {

				URL url = new URL(href); // convert href value from String to URL object
				HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open connection to the
																							// server
				connection.setRequestMethod("HEAD"); // Optional optimization: faster than GET
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				connection.connect();// Connect to the server

				int code = connection.getResponseCode();
				String resMessage = connection.getResponseMessage();
				String textlink = element.getText();

				if (code >= 400) {
					/*
					 * System.out.println(textlink + " Broken link.====>>  " + href +
					 * "  - The response code &  message  : " + code + " -  " + resMessage);
					 * 
					 * brokenlinkcount++;
					 */
					// badlinks.add(href);
					badlinks.add(href + " (Response Code: " + code + ")");
				} else {
					/*
					 * System.out.println(textlink + " Valid link.====>>  " + href +
					 * "  - The response code &  message  : " + code + " -  " + resMessage);
					 * validlinkcount++;
					 */
					// goodlinks.add(href);
					goodlinks.add(href + " (Response Code: " + code + ")");
				}
				connection.disconnect();
			} catch (IOException e) {
				badlinks.add(href + " (Exception: " + e.getMessage() + ")");
				// e.printStackTrace();
			}
		}

	}

}
