package excercise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BL {
static List<String> goodlinks = new ArrayList<>();
static List<String> badlinks = new ArrayList<>();
	//static int goodlinkcount = 0;
	//static int badlinkcount = 0;
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> listLinks= driver.findElements(By.tagName("a"));
		
		int countLinks =listLinks.size();
		
		verifyBrokenLinks(listLinks);
		
		System.out.println("\n---------------- BROKEN LINKS ----------------");
        for (String link : badlinks) {
            System.out.println(link);
        }

        System.out.println("\n---------------- GOOD LINKS ----------------");
        for (String link : goodlinks) {
            System.out.println(link);
        }
        
        
		System.out.println("========== Results Summary ==========");
		System.out.println("Total links ==> "+ countLinks);
		System.out.println("Total good links ==> "+ goodlinks.size());
		System.out.println("Total broken/bad links ==> "+ badlinks.size());
		driver.quit();
	}
	
	public static void verifyBrokenLinks(List<WebElement> listLinks) {
		
		for (WebElement link : listLinks) {
			String href = link.getAttribute("href");
			
			if (href==null || href.isEmpty()) {
				System.out.println("The link is empty"+ href);
				continue;
			}
			if (href.startsWith("javascript") || href.contains("tel") || href.contains("mailto")) {
				System.out.println("Skipping non http links ==> "+ href);
				continue;
			}
			
			try {
			URL url = new URL(href);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			connection.connect();
			int code = connection.getResponseCode();
			String message = connection.getResponseMessage();

			if (code >= 400)
			{
			
				//System.out.println("Broken / bad link ==> "+ link.getText().trim() +" response code ==>   "+ code + "; Response message ==>  "+message);
				goodlinks.add(href);
				//badlinkcount++;
				
			} else{
				//System.out.println("Good link ==> "+ link.getText().trim() +" response code ==>   "+ code + "; Response message ==>  "+message);
				badlinks.add(href);
				//goodlinkcount++;
			}
			connection.disconnect();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
}
