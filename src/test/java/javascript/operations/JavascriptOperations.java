package javascript.operations;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptOperations{
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "D:\\Webdriver executable\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		WebElement logo= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		//draw border and take screenshot
		JavascriptUtil.drawBorder(logo, driver);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshots\\commerce_logo.png");
		FileUtils.copyFile(src, target);
		Thread.sleep(5000);
		System.out.println("Screenshot captured successfully");
		System.out.println();
		
		//getting title of the page
		String title = JavascriptUtil.getPageTitle(driver);
		Thread.sleep(5000);
		System.out.println(title);
		System.out.println();
		
		//click action
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		JavascriptUtil.clickElementByJs(regLink, driver);
		Thread.sleep(5000);
		System.out.println("clicked successfully");
		System.out.println();
		
		//generate alert
		JavascriptUtil.generateAlert(driver, "This is my alert");
		Thread.sleep(5000);
		System.out.println("alert generated successfully");
		
		//refreshing webpage
		JavascriptUtil.refreshBrowserByJS(driver);
		Thread.sleep(5000);
		System.out.println("refresh successfully");
		
		//scroll page down
		JavascriptUtil.scrollPageDown(driver);
		Thread.sleep(5000);
		
		//scroll page up
		JavascriptUtil.scrollPageUp(driver);
		Thread.sleep(5000);
		
		//zoom page by js
		JavascriptUtil.zoomPageByJS(driver);
		Thread.sleep(5000);
		
		
		//flash
		WebElement element = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavascriptUtil.flash(element, driver);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
