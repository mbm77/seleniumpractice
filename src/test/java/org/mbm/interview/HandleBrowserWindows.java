package org.mbm.interview;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		String parentHandle = driver.getWindowHandle();
		WebElement text = driver.findElement(By.id("name"));
		text.sendKeys("first");
		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String handle:windowHandles) {
			if(!parentHandle.equals(handle)) {
				driver.switchTo().window(handle);
				driver.findElement(By.id("firstName")).sendKeys("Murali");
				driver.findElement(By.id("lastName")).sendKeys("mannepalli");
				driver.findElement(By.id("femalerb")).click();
				driver.findElement(By.id("englishchbx")).click();
				driver.findElement(By.id("hindichbx")).click();
				driver.findElement(By.id("chinesechbx")).click();
				driver.findElement(By.id("chinesechbx")).click();
				driver.switchTo().window(handle);
				driver.findElement(By.id("firstName")).sendKeys("abc@gmail.com");
				driver.findElement(By.id("lastName")).sendKeys("admin@123");
				driver.findElement(By.id("registerbtn")).click();
				String msg = driver.findElement(By.id("msg")).getText();
				System.out.println(msg);
				Thread.sleep(5000);
				driver.findElement(By.id("clearbtn")).click();
				driver.close();
				
			}
		}
		
		driver.switchTo().window(parentHandle);
		text.clear();
		text.sendKeys("second");
		Thread.sleep(5000);
		driver.quit();
	}

}
