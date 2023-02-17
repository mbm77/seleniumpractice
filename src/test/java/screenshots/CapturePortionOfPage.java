package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CapturePortionOfPage {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver","D:\\Webdriver executable\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//div[@class='RNNXgb']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
		
		//Thread.sleep(4000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshots\\modifiedpage.png");
		FileUtils.copyFile(src, target);
		driver.quit();
		
		
	}

}
