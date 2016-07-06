package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.testngtutorial.MyTestNGTutorial.webelements.SearchBox;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class YandexSeachResultPage {
	
	private String url = "https://www.yandex.com/search";
	
	@FindBy(xpath = ".//*[@class='input__control']")
	private SearchBox searchBox;

	public SearchBox getSearchBox() {
		return searchBox;
	}

	public YandexSeachResultPage(WebDriver driver) {
		HtmlElementLoader.populatePageObject(this, driver);
		// TODO Auto-generated constructor stub
	}
	
	public void search(String request) {
        searchBox.search(request);
    }
	
	

}
