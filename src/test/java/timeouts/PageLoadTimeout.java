package timeouts;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeout {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		Instant startTime = Instant.now();
		driver.get("https://www.google.com/");
		Instant endTime = Instant.now();
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("Pageload Time"+duration.toMillis());
	}

}
