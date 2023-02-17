package mouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Double-click me']"));
		Actions actions = new Actions(driver);
		actions.doubleClick(button).perform();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
