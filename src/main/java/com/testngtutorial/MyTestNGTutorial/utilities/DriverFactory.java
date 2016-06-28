package com.testngtutorial.MyTestNGTutorial.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junitx.util.PropertyManager;

public class DriverFactory {
	
	public enum BrowserType {
		
		FIREFOX("firefox"),
        CHROME("chrome"),
        IE("internet_explorer"),
        SAFARI("safari");

        private String value;

        BrowserType(String value){
            this.value = value;
        }

        public String getBrowserName(){
            return this.value;
        }
	}
	/*
	 * For some reason was unable to launch firefox driver with FF47
	 */
	
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
	
	public static BrowserType getBrowserTypeByProperty(){
		BrowserType type = null;
		String browserName = PropertyManager.getProperty("BROWSER");
		for (BrowserType btype : BrowserType.values()){
			if(btype.getBrowserName().equalsIgnoreCase(browserName)){
				type = btype;
			}
			 System.out.println("BROWSER = " + type.getBrowserName());
		}
		return type;
	}

}
