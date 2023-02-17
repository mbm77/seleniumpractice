package mouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragAndDropImages {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']")));
		WebElement item1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement item2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		WebElement trash = driver.findElement(By.id("trash"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(item1, trash).perform();
		actions.dragAndDrop(item2, trash).perform();
		Thread.sleep(5000);
		driver.quit();
	}

}
