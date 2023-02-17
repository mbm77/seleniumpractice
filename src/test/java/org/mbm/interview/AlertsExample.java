package org.mbm.interview;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsExample {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.alertIsPresent());
		//Simple Alert
		driver.findElement(By.id("alertBox")).click();
		String alertdata = driver.switchTo().alert().getText();
		//Thread.sleep(3000);
		System.out.println("Alert Box Data: "+alertdata);
		driver.switchTo().alert().accept();
		String output = driver.findElement(By.xpath("//div[@id='output']")).getText();
		System.err.println("Output: "+output);
		
		//Confirmation 
		driver.findElement(By.xpath("//button[@id='confirmBox']")).click();
		alertdata = driver.switchTo().alert().getText();
		//Thread.sleep(3000);
		System.out.println("Confirmation Box Data: "+alertdata);
		driver.switchTo().alert().accept();
		output = driver.findElement(By.xpath("//div[@id='output']")).getText();
		System.err.println("Output: "+output);
		
		//prompt
		driver.findElement(By.id("promptBox")).click();
		alertdata = driver.switchTo().alert().getText();
		//Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Hi bala Murali !!!");
		driver.switchTo().alert().accept();
		System.out.println(alertdata);
		output = driver.findElement(By.xpath("//div[@id='output']")).getText();
		System.err.println("Output: "+output);
		
		driver.quit();
		
		
	}

}
