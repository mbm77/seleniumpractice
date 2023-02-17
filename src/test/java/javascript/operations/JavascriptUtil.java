package javascript.operations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil {

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
		
	}
	
	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static void clickElementByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void generateAlert(WebDriver driver, String msg) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.alert('"+msg+"')");
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.location.reload()");
		//js.executeScript("history.go[0]");
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollPageUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	public static void zoomPageByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		String bgcolor = element.getCssValue("background-color");
		for(int i=0;i<=20; i++) {
			changeColor("#48beca",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	
	public static void changeColor(String color,WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
	}

}










