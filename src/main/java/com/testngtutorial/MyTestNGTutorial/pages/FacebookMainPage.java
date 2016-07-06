package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookMainPage extends BasePage {
	
	@FindBy (id = "email") WebElement fieldEmailLogin;
	@FindBy (id = "pass") WebElement fieldPasswordLogin;
	@FindBy (css = "#loginbutton>input") WebElement buttonLogin;
	
	@FindBy (id = "day") WebElement dropdownDay;
	@FindBy (id = "month") WebElement dropdownMonth;
	@FindBy (id = "year") WebElement dropdownYear;
	
	private String title = "Facebook - Log In or Sign Up";
	private String url = "http://www.facebook.com";
	
	// Get methods	

	public WebElement getFieldEmailLogin() {
		return fieldEmailLogin;
	}

	public WebElement getFieldPasswordLogin() {
		return fieldPasswordLogin;
	}

	public WebElement getButtonLogin() {
		return buttonLogin;
	}

	public WebElement getDropdownDay() {
		return dropdownDay;
	}

	public WebElement getDropdownMonth() {
		return dropdownMonth;
	}

	public WebElement getDropdownYear() {
		return dropdownYear;
	}
	
	// Constructor

	public FacebookMainPage(WebDriver driver){
		super(driver);
		setPageUrl(url);
		setPageTitle(title);		
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
	
	public void selectBDayDay(String value){
		selectValueInDropdown(dropdownDay, value);
	}
	
	public void selectBDayMonth(String value){
		selectValueInDropdown(dropdownMonth, value);
	}
	
	public void selectBDayYear(String value){
		selectValueInDropdown(dropdownYear, value);
	}
}
