package excercise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class BaseTests {

	public WebDriver driver;
	public Properties prop = new Properties();

	@BeforeTest
	public void launchBrowser() throws IOException {

		// load config.properties file; FileInputStream / FileReader class to read the
		// files.
		FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");// Load the file and read
																								// the values from the
																								// variables from the
																								// Base class.
		prop.load(fis);

		String br = prop.getProperty("browsername");
		String url = prop.getProperty("url");
		System.out.println("Browser Name from BaseTests ==>   "+br);
		System.out.println("URL from BaseTests ==>   "+url);

		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("Browser Name from If..else ==>   "+br);
			System.out.println("URL from If..else ==>   "+url);
			
		} else if (br.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("Browser Name from If..else ==>   "+br);
			System.out.println("URL from If..else ==>   "+url);

		} else if (br.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else {

			System.out.println("Invalid browser name: ");
		}

	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("Browser closed.");
		driver.quit();
	}

}
