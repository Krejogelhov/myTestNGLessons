package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YandexByStartPage extends BasePage{
	
	// Find elements
	
	@FindBy (xpath = ".//*[@name='login']") WebElement fieldEmailLogin;
	@FindBy (xpath = ".//*[@name='passwd']") WebElement fieldPasswordLogin;
	@FindBy (xpath =  "html/body/div[1]/div[1]/div/div/div/div[3]/div/div/div[3]/div/div[2]/div/div/div/form/div/div[2]/div[2]/button") WebElement buttonLogin;
	
	private String url = "https://yandex.by/";
	private String title = "Яндекс";
	
	//Constructor

	public YandexByStartPage(WebDriver driver) {
		super(driver);
		setPageUrl(url);
		setPageTitle(title);
	}
	
	//Get Methods
	
	public WebElement getFieldEmailLogin() {
		return fieldEmailLogin;
	}

	public WebElement getFieldPasswordLogin() {
		return fieldPasswordLogin;
	}

	public WebElement getButtonLogin() {
		return buttonLogin;
	}
	
	// Interaction methods
	
	public void login(String email, String password) {
		getWait().until(ExpectedConditions.elementToBeClickable(fieldEmailLogin));
		setTextEmailLogin(email);
		setTextPasswordLogin(password);
		clickLoginMain();
	}
		
	public void setTextEmailLogin(String text){
		setElementText(fieldEmailLogin, text);
	}
		
	public void setTextPasswordLogin(String text){
		setElementText(fieldPasswordLogin, text);
	}
		
	public void clickLoginMain(){
		clickElement(buttonLogin);
	}

}
