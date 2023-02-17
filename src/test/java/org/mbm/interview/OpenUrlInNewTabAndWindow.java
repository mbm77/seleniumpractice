package org.mbm.interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenUrlInNewTabAndWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.nopcommerce.com/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
