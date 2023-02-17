package org.mbm.interview;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13 256gb blue", Keys.ENTER);
		driver.findElement(By.xpath("//img[@alt='iPhone 13 Pro Max, 256GB, Sierra Blue - Unlocked (Renewed Premium)']")).click();
		
	}

}
