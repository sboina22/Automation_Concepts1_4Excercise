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

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.navigate().to("http://www.deadlinkcity.com/");
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> links = driver.findElements(By.tagName("a"));
		List<String> goodlinks = new ArrayList<>();
		List<String> badlinks = new ArrayList<>();
		
		// int brokenlinkcount =0 ;
		// int validlinkcount=0;

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
					badlinks.add(href);

				} else {
					/*
					 * System.out.println(textlink + " Valid link.====>>  " + href +
					 * "  - The response code &  message  : " + code + " -  " + resMessage);
					 * validlinkcount++;
					 */
					goodlinks.add(href);
				}
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\n=========== Result Summary ===========");
		// System.out.println("Total broken links ==> "+brokenlinkcount);
		// System.out.println("Total good links ==> "+validlinkcount);
		
		System.out.println("Number of links in page ===> " + links.size()); // size()

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

	}
}
