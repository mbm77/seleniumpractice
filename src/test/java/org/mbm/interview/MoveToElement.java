package org.mbm.interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/form/Price-Range-Slider-jQuery-UI.html");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//h3[normalize-space()='Related jQuery Plugins']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		Thread.sleep(5000);
		driver.quit();
	}

}
