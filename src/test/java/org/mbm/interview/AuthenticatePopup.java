package org.mbm.interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatePopup {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");// actual url is https://the-internet.herokuapp.com/basic_auth
	}

}
