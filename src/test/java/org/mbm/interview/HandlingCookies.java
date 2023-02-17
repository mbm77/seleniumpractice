package org.mbm.interview;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;

public class HandlingCookies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of cookies :"+cookies.size());
		
		for(Cookie cook:cookies) {
			System.out.println(cook.getName()+" : "+cook.getValue());
		}
		
		//add cookie
		Cookie cookie = new Cookie("name","Bala Murali");
		driver.manage().addCookie(cookie);
		cookies = driver.manage().getCookies();
		System.out.println("size of cookies :"+cookies.size());
		
		for(Cookie ck:cookies) {
			System.out.println(ck.getName()+" : "+ck.getValue());
		}
		
		driver.manage().deleteCookieNamed(".Nop.Antiforgery");
		//driver.manage().deleteCookie(cookie);
		cookies = driver.manage().getCookies();
		System.out.println("size of cookies after deletion :"+cookies.size());
		
		for(Cookie ck1:cookies) {
			System.out.println(ck1.getName()+" : "+ck1.getValue());
		}
		
		driver.manage().deleteCookieNamed("name");
		cookies = driver.manage().getCookies();
		System.out.println("size of cookies after deletion :"+cookies.size());
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("size of cookies after deletion :"+cookies.size());
		driver.quit();
	}

}
