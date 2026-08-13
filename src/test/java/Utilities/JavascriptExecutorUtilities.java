package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorUtilities {

	// In utilities class, create static methods to call by class

	// Drawing border & Take screenshot
	public static void drawBoarder(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver; // Cast WebDriver to JavascriptExecutor
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}

	// Zoom page
	public static void zoomPage(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.body.style.zoom = '80%' "); //Zoom out to 80%
		//js.executeScript("document.body.style.zoom = '100%' "); //Reset back to normal(100%)
		js.executeScript("document.body.style.zoom = '150%' "); //Zoom in to 150%
	}
	
	
	// Fetching Page Details -Title of the Page
	public static String getPageTitleByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	// Fetching Page Details - URL of the Page
	public static String getPageURLByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = js.executeScript("return window.location.href;").toString();
		return url;
	}

	// Click action
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// Generate alert

	public static void generateJSAlert(String message, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert (' " + message + " ')");
	}

	// Refreshing the page
	
	public static void refreshBroswerByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go[0]");
	}

	// Scroll down a page
	public static void scrollPageDown(WebDriver driver){
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// Scroll up page
	public static void scrollPageup(WebDriver driver){
		
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript ("window.scrollBy(0,-document.body.scrollHeight)"); // Note "-"
	}

	
	// Flash - TBD
	
	// Scroll into element view - Method 1
	public static void scrollInToElementView(WebElement element, WebDriver driver){
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", element); // aligns the top of element with the top of viewport
	
}
	/* // Scroll into element view - Method 1
	Selenium 4+ no need of JavascriptExecutor for Scrolling. We have Actions class methods for the same.
	import org.openqa.selenium.interactions.Actions;

	public static void scrollIntoElementView(WebElement element, WebDriver driver) {
    new Actions(driver)
        .scrollToElement(element)
        .perform();
        
    //Reference: EgZjaHJvbWUyBggAEEUYOTIHCAEQABiABDIHCAIQABiABDIHCAMQABiABDIHCAQQABiABDIGCAUQRRg9MgYIBhBFGD0yBggHEEUYPdIBCTE4MDE2ajBqN6gCALACAA
} */
	
}
