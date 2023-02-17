package org.mbm.upload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UploadFileTest {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","D:\\Webdriver executable\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		
		//upload file using sendKeys() method
		//driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\user\\Downloads\\murali_testing.docx");
		
		
		//upload file using Robot class methods
		WebElement button = driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", button);
		
		Robot robot = new Robot();
		robot.delay(2000);
		StringSelection ss = new StringSelection("C:\\Users\\user\\Downloads\\murali_testing.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		
		
		
		
		
	}

}
