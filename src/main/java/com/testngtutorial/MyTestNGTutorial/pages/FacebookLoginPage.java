package com.testngtutorial.MyTestNGTutorial.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BasePage{
	
	public FacebookLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String PAGE_TITLE = "Войдите на Facebook";
	public static final String PAGE_URL = "http://www.facebook.com/login.php";
	
	@FindBy(xpath = ".//*[@id='globalContainer']/div[3]/div/div/div/div[2]") WebElement errorMessage;
	
	public boolean checkErrorMessage(String text){
		try{
			return StringUtils.contains((CharSequence)errorMessage.getText(), text);
		}
		catch(NoSuchElementException e){
			return false;			
		}
		
	}

}
