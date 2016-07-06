package com.testngtutorial.MyTestNGTutorial.utilities;

import org.apache.commons.cli.Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	private static WebDriver driver = null;
	
	public static WebDriver getDriver(BrowserType type){
		
		if(driver == null){
		
			switch (type){
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case FIREFOX:
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver(capabilities);				
					break;
				default:
					System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
					driver = new ChromeDriver();
					break;
			}
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
		// System.out.println("BROWSER = " + type.getBrowserName());
		}
		return type;
	}
	
	public static BrowserType getBrowserTypeFromCLI(){
		BrowserType type = null;
		Options options = new Options();
		options.addOption("c", "CHROME", false, "Chrome browser");
		options.addOption("f", "FIREFOX", false, "Firefox browser");
		
		type = CLIParser.parse(options);
		return type;
	}

	

}
