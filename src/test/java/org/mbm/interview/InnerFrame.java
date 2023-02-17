package org.mbm.interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		WebElement outerframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outerframe);
		WebElement innerframe = driver.findElement(By.xpath("//iframe[normalize-space()='<p>Your browser does not support iframes.</p>']"));
		driver.switchTo().frame(innerframe);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome Inner Frame");
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[normalize-space()='Single Iframe']")).click();
		WebElement singleframe = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(singleframe);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome Single Frame");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[normalize-space()='WebTable']")).click();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
