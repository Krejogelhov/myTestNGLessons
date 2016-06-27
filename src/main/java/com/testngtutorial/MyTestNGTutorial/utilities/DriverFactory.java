package com.testngtutorial.MyTestNGTutorial.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public enum BrowserType {
		FIREFOX,
		CHROME,
		EDGE
	}
	
	public static WebDriver getDriver(BrowserType type){
		WebDriver driver = null;
		switch (type){
	//	case FIREFOX:
	//		driver =  new FirefoxDriver();
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
		default:
	//		driver =  new FirefoxDriver();
		}
		return driver;
	}

}
