package pricerangeslider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PriceRangeSlider {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location Of Min Slider :"+min_slider.getLocation());
		System.out.println("Height & Width of Min slider :"+min_slider.getSize());
		
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(min_slider, 100, 0).perform();
		System.out.println();
		System.out.println("Location Of Min Slider :"+min_slider.getLocation());
		System.out.println("Height & Width of Min slider :"+min_slider.getSize());
		
		actions.dragAndDropBy(max_slider, -100, 0).perform();
		Thread.sleep(5000);
		System.out.println();
		System.out.println("Location Of Max Slider :"+max_slider.getLocation());
		System.out.println("Height & Width of Max slider :"+max_slider.getSize());
	}

}
