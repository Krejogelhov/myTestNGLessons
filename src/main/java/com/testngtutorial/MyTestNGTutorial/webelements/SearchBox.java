package com.testngtutorial.MyTestNGTutorial.webelements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;


@FindBy(xpath = "//form")
public class SearchBox extends HtmlElement {
	

    //@Name("Search request input")
    @FindBy(xpath = ".//*[@id='text']")
    private TextInput requestInput;

    //@Name("Search button")
    @FindBy(xpath = "html/body/div[1]/div[3]/div[2]/table/tbody/tr/td[2]/form/div[2]/button")
    private Button searchButton;
    
    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }
    
}
