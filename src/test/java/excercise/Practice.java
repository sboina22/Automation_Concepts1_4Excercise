package excercise;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.swing.text.Document;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice extends BaseTests{
	

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

//Screenshot, Broken links

		driver.get("https://birdeatsbug.com/blog/data-driven-framework-in-selenium");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "/Screenshots/practiceSS.png");
		FileUtils.copyFile(sourcefile, targetfile);
		System.out.println("**** Find the screenshot in screenshot folder ****");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linkscount = links.size();
		
		int brokenlinkcount =0 ;
		int validlinkcount=0;
		
		for (WebElement link : links) {

			String linkref = link.getAttribute("href");
			if(linkref==null||linkref.isEmpty()) {
			System.out.println("URL is empty or missing href attribute.");
			continue;
			}
			try {
			URL url1 = new URL(linkref);
			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			
			int respcode = connection.getResponseCode();
			String respmessage = connection.getResponseMessage();
			String textlink = link.getText();
			boolean isdisplayed = link.isDisplayed();
			
			if (respcode>=400) {
				System.out.println(textlink + "is displayed ? : "+ isdisplayed+ " and the "+" link is broken ==>  "+ linkref+ " ; " + respcode +" ; "+ respmessage );
				brokenlinkcount++;
			}
			
			if (respcode<400) {
				System.out.println(textlink + " Valid link ==> "+ linkref+ " ; " + respcode +" ; "+ respmessage );
				validlinkcount++;
			}
			connection.disconnect();
		} catch (IOException e) {
				e.printStackTrace();
			}
			
			}
		System.out.println("Links count ==> "+linkscount);
		System.out.println("Broken links count ==> "+brokenlinkcount);
		System.out.println("Valid links count ==> "+validlinkcount);
		driver.close();
		}

	}
