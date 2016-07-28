package com.testngtutorial.MyTestNGTutorial.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testngtutorial.MyTestNGTutorial.data.YandexData;
import com.testngtutorial.MyTestNGTutorial.pages.YandexByStartPage;
import com.testngtutorial.MyTestNGTutorial.pages.YandexMailMainPage;
import com.testngtutorial.MyTestNGTutorial.pages.YandexNewMailPage;
import com.testngtutorial.MyTestNGTutorial.utilities.DriverFactory;

public class YandexMailTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	YandexByStartPage yByStart;
	YandexMailMainPage yMailMain;
	YandexNewMailPage yNewMailPage;

	@BeforeClass(alwaysRun = true)
	public void setup(){		
		this.driver = DriverFactory.getDriver(DriverFactory.getBrowserTypeByProperty());
		wait = new WebDriverWait(driver, 2);
		yByStart = PageFactory.initElements(driver, YandexByStartPage.class);
		yMailMain = PageFactory.initElements(driver, YandexMailMainPage.class);
		yNewMailPage = PageFactory.initElements(driver, YandexNewMailPage.class);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		driver.close();
	}
	
	@Test(groups={"p1", "pageLoads"})
	public void loadPage(){
		yByStart.loadPage();
		Assert.assertEquals(driver.getTitle() , yByStart.getPageTitle());
	}
	
	@Test(groups="p1", dataProviderClass = YandexData.class, dataProvider = "login")
	public void getAddressField(String email, String password, String urlDetails){
		driver.manage().deleteAllCookies();
		yByStart.loadPage();
		yByStart.login(email, password);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		yMailMain.clickNewMailButton();
		yNewMailPage.setTextAdress("dummyaddress");
		Assert.assertEquals(yNewMailPage.getTextAdress().getAttribute("value"), "dummyaddress");
		
	}
	
	@Test(groups="p1", dataProviderClass = YandexData.class, dataProvider = "login")
	public void getBodyBox(String email, String password, String urlDetails){
		driver.manage().deleteAllCookies();
		yByStart.loadPage();
		yByStart.login(email, password);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		yMailMain.clickNewMailButton();
		yNewMailPage.setTextAdress("dummyaddress");
		yNewMailPage.setTextMailBody("Test Body Text");
		Assert.assertEquals(yNewMailPage.getTextMailBody().getAttribute("value"), "Test Body Text");
		
	}

}
