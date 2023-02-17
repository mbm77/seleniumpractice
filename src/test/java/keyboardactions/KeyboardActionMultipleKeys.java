package keyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionMultipleKeys {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","D:\\Webdriver executable\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("textPresentInElement");
		
		//select all
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
		Thread.sleep(4000);
		
		//copy
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
		Thread.sleep(4000);
		
		//tab
		actions.sendKeys(Keys.TAB);
		actions.perform();
		Thread.sleep(4000);
		
		//paste
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
		Thread.sleep(4000);
		
		String text1 = driver.findElement(By.xpath("//textarea[@id='inputText1']")).getAttribute("value");
		String text2 = driver.findElement(By.xpath("//textarea[@id='inputText2']")).getAttribute("value");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		if(text1.equals(text2)) {
			js.executeScript("window.alert('text is copied')");
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			System.out.println("text is copied");
		}else {
			js.executeScript("window.alert('text is not copied')");
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			System.out.println("text is not copied");
		}
		
		driver.quit();
	}

}
