package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMailMainPage extends BasePage {
	
	@FindBy (xpath = ".//*[@title='Написать (w, c)']") WebElement newLetterButton;

	public YandexMailMainPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getNewLetterButton() {
		return newLetterButton;
	}
	
	public void clickNewMailButton(){
		clickElement(newLetterButton);
	}

}
