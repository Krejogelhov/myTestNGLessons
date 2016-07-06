package com.testngtutorial.MyTestNGTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.testngtutorial.MyTestNGTutorial.webelements.SearchBox;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class YandexStartPage {
	
	private String url = "https://www.yandex.com/";
	private SearchBox searchBox;

	public YandexStartPage(WebDriver driver) {
		HtmlElementLoader.populatePageObject(this, driver);
	}
	
	public void search(String request) {
        searchBox.search(request);
    }
	
	
	public String getPageUrl() {
		return url;
	}
	

}
