package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String url;
	private String title;
	
	// Constructor
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}		
	
	// Get/Set methods
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	public String getPageUrl() {
		return url;
	}
	
	public String getPageTitle() {
		return title;
	}
	
	public void setPageUrl(String url) {
		this.url = url;
	}
	
	public void setPageTitle(String title) {
		this.title = title;
	}
	
	// Interaction methods
		
	public void loadPage() {
		getDriver().get(getPageUrl());	
	}	
	
	public void clickElement(WebElement element) {
		element.click();
	}
	
	public void selectValueInDropdown(WebElement dropdown, String value){
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}
	
	public void setElementText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);		
	}

}
