package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureSectionFromWebPage {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//section
		//WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-grid']"));
		
		//logo
		WebElement website_logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		//TakesScreenshot ts = (TakesScreenshot) driver;
		File src= website_logo.getScreenshotAs(OutputType.FILE);
		File target =new File(".\\screenshots\\website_logo.png");
		FileUtils.copyFile(src, target);
		driver.quit();
	}

}
