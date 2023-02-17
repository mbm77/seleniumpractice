package mouseoperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDropAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		WebElement city = driver.findElement(By.id("box1"));
		WebElement country = driver.findElement(By.id("box101"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(city,country).perform();
		driver.quit();
	}

}
