package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexNewMailPage extends BasePage {
	
	@FindBy (xpath = ".//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div/div/input") WebElement mailToAddressField;
	@FindBy (xpath = ".//*[@id='compose-send']") WebElement mailBody;

	public YandexNewMailPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getTextAdress() {
		return mailToAddressField;
	}
	
	public void setTextAdress(String text){
		setElementText(mailToAddressField, text);
	}
	
	public WebElement getTextMailBody() {
		return mailBody;
	}
	
	public void setTextMailBody(String text){
		setElementText(mailBody, text);
	}


}
