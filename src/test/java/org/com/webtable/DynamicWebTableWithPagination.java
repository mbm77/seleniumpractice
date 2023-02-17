package org.com.webtable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableWithPagination {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver","D:\\Webdriver executable\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");
		WebElement password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		String pageDetails = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int totalPages = Integer.valueOf(pageDetails.substring(pageDetails.indexOf("(")+1, pageDetails.lastIndexOf(" ")));
		System.out.println(totalPages);
		for(int p=1; p<=totalPages; p++) {
			
			
			WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
			
			System.out.println("Active Page "+activePage.getText());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//activePage.click();
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
			System.out.println("Num Of Rows :"+rows);
			
			String page = Integer.toString(p+1);
			
			WebElement element = driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+page+"']"));
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
		}
		
		
		
		
		
	}

}
