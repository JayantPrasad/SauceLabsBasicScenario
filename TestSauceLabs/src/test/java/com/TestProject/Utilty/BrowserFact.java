package com.TestProject.Utilty;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFact

{
	public static WebDriver driver = null;	
	public static WebDriver selectBrowser(String browserName , String url)
	{
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();	
			ChromeOptions options1 = new ChromeOptions();
			driver = new ChromeDriver(options1);					
			break;

		case "chromeHeadless":
			WebDriverManager.chromedriver().setup();	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1400,800");
			options.addArguments("headless");
			driver = new ChromeDriver(options);

		}
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		return driver;

		
	}
	
	public static WebDriver quitBrowser()
	{
		driver.close();	
		return driver;
	}	

}
