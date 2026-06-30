package TestAutomationConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_002_HandlingMultipleBootstrapDropdowns {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.hdfc.bank.in/"); 
		driver.manage().window().maximize();
/*
1. Click the dropdown button to make options visible
driver.findElement(By.xpath("//div[@class=\"selector-wraplist productType option-box\"]/div")).click();
		 
2. Capture all dropdown options into a List, Usually, options are 'li' or 'a' tags inside a 'ul' 
List<WebElement> listProductType = driver.findElements(By.xpath("//div[@class='selector-wraplist productType option-box']//ul[@class='options']//li/a")); 
List<WebElement> listProductType = driver.findElements(By.xpath("//ul[@class='options']//li/a"));
System.out.println("Number of Product Type Items : " + listProductType.size());

3. Iterate through the list and click the desired option 
for (WebElement listItem : listProductType) { 
if (listItem.getText().equals("Credit Cards")) { 
System.out.println("The selected list item : " + listItem.getText());
listItem.click(); 
break; 
}
*/

		driver.get("https://www.hdfc.bank.in/");
		// driver.manage().window().maximize();

		driver.findElement(By.xpath("//div[@class='selector-wraplist productType option-box']//div[@role='button']")).click();
		//driver.findElement(By.xpath("//div[@class=\"selector-wraplist productType option-box\"]/div")).click();
		List<WebElement> listProductType = driver.findElements(By.xpath("//ul[@class='options']//li/a"));
		System.out.println("Number of Product Type Items : " + listProductType.size());
		selectListItemfromDropdowns(listProductType, "Life Insurance");
		
		driver.findElement(By.xpath("//div[@class='selector-wraplist products option-box']")).click();
		
		List<WebElement> listProduct = driver.findElements(
				By.xpath("//div[@class='selector-wraplist products option-box']//ul[@class='options']//li/a"));
		System.out.println("Number of Product Type Items : " + listProduct.size());
		selectListItemfromDropdowns(listProduct, "Term Insurance");

	}
	

	public static void selectListItemfromDropdowns(List<WebElement> options, String value) {
		for (WebElement listItem : options) {
			if (listItem.getText().equals(value)) {
				System.out.println("The selected list item : " + listItem.getText());
				listItem.click();
				break;
			}

		}
	}
}
