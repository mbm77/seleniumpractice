package org.mbm.interview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement element:links) {
			String link = element.getAttribute("href");
			if(link == null || link.isEmpty()) {
				System.out.println("There is no url");
				continue;
			}
			
			URL url = new URL(link);
			
			URLConnection urlconnection = url.openConnection();
			HttpURLConnection httpurlconnection = (HttpURLConnection) urlconnection;
			httpurlconnection.connect();
			if(httpurlconnection.getResponseCode()>=400) {
				System.err.println(httpurlconnection.getResponseCode()+" is "+" Broken Link");
			}else {
				System.out.println(httpurlconnection.getResponseCode() + link +" is valid link" );
			}
			
		}
		
		
	}

}
