package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookMainFeed extends BasePage{
	
	@FindBy(className = "fbxWelcomeBoxName ") WebElement welcomeUsername;
	
	public FacebookMainFeed(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getUsernameText(){
		return welcomeUsername.getText();
	}

}
