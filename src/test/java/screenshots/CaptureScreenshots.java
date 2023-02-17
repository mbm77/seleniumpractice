package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {

	public static void main(String[] args) throws IOException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","D:\\Webdriver executable\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\homepage.png");
		FileUtils.copyFile(src, trg);
		driver.close();
	}

}
