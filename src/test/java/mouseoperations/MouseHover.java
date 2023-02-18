package mouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement product = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		//WebElement second = driver.findElement(By.xpath("//a[normalize-space()='iPhone']"));
		WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(desktop).moveToElement(product).click().perform();
		
	}

}
