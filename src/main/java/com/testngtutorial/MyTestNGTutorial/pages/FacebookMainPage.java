package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookMainPage extends BasePage {
	
	@FindBy (id = "email") WebElement field_EmailLogin;
	@FindBy (id = "pass") WebElement field_PasswordLogin;
	@FindBy (css = "#loginbutton>input") WebElement button_Login;
	
	@FindBy (id = "day") WebElement dropdown_Day;
	@FindBy (id = "month") WebElement dropdown_Month;
	@FindBy (id = "year") WebElement dropdown_Year;
	
	public FacebookMainPage(WebDriver driver){
		super(driver);
		this.PAGE_TITLE = "Facebook - Log In or Sign Up";
		this.PAGE_URL = "http://www.facebook.com";
	}
	
	public void login(String email, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(field_EmailLogin));
		setText_EmailLogin(email);
		setText_PasswordLogin(password);
		clickLoginMain();
	}
	
	public void setText_EmailLogin(String text){
		setElementText(field_EmailLogin, text);
	}
	
	public void setText_PasswordLogin(String text){
		setElementText(field_PasswordLogin, text);
	}
	
	public void clickLoginMain(){
		clickElement(button_Login);
	}
	
	public void selectBDayDay(String value){
		selectValueInDropdown(dropdown_Day, value);
	}
	
	public void selectBDayMonth(String value){
		selectValueInDropdown(dropdown_Month, value);
	}
	
	public void selectBDayYear(String value){
		selectValueInDropdown(dropdown_Year, value);
	}
}
