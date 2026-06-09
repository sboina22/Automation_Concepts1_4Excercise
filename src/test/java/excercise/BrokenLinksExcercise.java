package excercise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksExcercise {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		int brokenlinkcount = 0;
		int linkscount;

		List<WebElement> linkelements = driver.findElements(By.tagName("a"));
		linkscount=linkelements.size();
		
		
		for (WebElement linkelement : linkelements) {

			String urllink = linkelement.getAttribute("href");
			
			if(urllink==null || urllink.isEmpty()){
				
				System.out.println("The URL is empty or null");
				continue;
			}
			
			if(urllink.startsWith("javascript:") || urllink.startsWith("mailto:") || urllink.startsWith("tel:")){
				
				System.out.println("The URL is starts with either javascript:, mailto: or tel:");
				continue;
			}
			
	
			URL urlobj = new URL(urllink);

			HttpURLConnection connection = (HttpURLConnection) urlobj.openConnection();
			
			connection.connect();

			int rescode = connection.getResponseCode();
			String resmessage = connection.getResponseMessage();
			String linktext = linkelement.getText();

			if (rescode >= 400) {

				System.out.println(linktext + urllink + " <==> Broken link. The response code & response message ==> "
						+ rescode + " ' " + resmessage);
				brokenlinkcount++;

			} else {
				System.out.println(linktext + urllink + " <==> Valid link. The response code & response message ==> "
						+ rescode + " ' " + resmessage);
			}
			connection.disconnect();
		}
		
				
			}
			
			
		
		System.out.println("Number of links ==> " +linkscount);
		System.out.println("TNumber of broken links ==> " +brokenlinkcount);
	
		
		driver.close();
	}
	
	

}
