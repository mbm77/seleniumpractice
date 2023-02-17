package org.mbm.filedownload;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v108.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadTest {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		//Chrome 
		
		  String location = System.getProperty("user.dir")+"\\Downloads\\"; //D:\GitUser\mavenselenium\Downloads 
		  /*HashMap<String, String> preferences =
		 * new HashMap<String, String>(); preferences.put("download.default_directory",
		 * location); ChromeOptions options = new ChromeOptions();
		 * options.setExperimentalOption("prefs", preferences);
		 * 
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(options);
		 * //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * driver.get(
		 * "https://file-examples.com/index.php/sample-documents-download/sample-doc-download/"
		 * ); driver.manage().window().maximize();
		 * driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(
		 * "ad_position_box")));
		 * driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
		 * //driver.switchTo().frame("ad_iframe");
		 * driver.findElement(By.id("dismiss-button")).click();
		 */
		  
		  
		  //firefox
		  
		  	FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.helperApps.neverAsk.saveToDisc", "application/msword");
			profile.setPreference("browser.download.folderList",2);
			profile.setPreference("Browser.download.dir", location);
			
			FirefoxOptions fo = new FirefoxOptions();
			fo.setProfile(profile);
		
		  	WebDriverManager.firefoxdriver().setup(); 
		  	driver = new FirefoxDriver(fo);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
			 driver.manage().window().maximize();
			 driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		  
		
		
		
		
			
		
	}

}
