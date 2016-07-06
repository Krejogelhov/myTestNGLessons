package com.testngtutorial.MyTestNGTutorial.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testngtutorial.MyTestNGTutorial.pages.YandexSeachResultPage;
import com.testngtutorial.MyTestNGTutorial.pages.YandexStartPage;
import com.testngtutorial.MyTestNGTutorial.utilities.DriverFactory;

public class YandexSearchTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	YandexStartPage yandexSP;
	YandexSeachResultPage yandexSRP;
	
	@BeforeClass(alwaysRun = true)
	public void setup(){		
		this.driver = DriverFactory.getDriver(DriverFactory.getBrowserTypeByProperty());
		wait = new WebDriverWait(driver, 2);
		
		yandexSP = new YandexStartPage(driver);
		driver.get(yandexSP.getPageUrl());
		yandexSRP = new YandexSeachResultPage(driver);		
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		driver.close();
	}
	
	@Parameters ({"randomPassword"})
	@Test
	public void searchBoxEntry(@Optional("test") String request){
		yandexSP.search(request);
		Assert.assertEquals(yandexSRP.getSearchBox().getAttribute("value"), request);
	}

}
