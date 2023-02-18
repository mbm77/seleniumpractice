package keyboardactions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(500,500));
		driver.get("https://the-internet.herokuapp.com/key_presses");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(5000);
		actions.sendKeys(Keys.SPACE).perform();
		Thread.sleep(5000);
		actions.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(5000);
		actions.sendKeys("A").perform();  
		Thread.sleep(5000);
		driver.quit();
	}

}
