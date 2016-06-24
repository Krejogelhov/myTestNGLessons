package com.testngtutorial.MyTestNGTutorial;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.testngtutorial.MyTestNGTutorial.data.FacebookData;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookLoginPage;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookMainFeed;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookMainPage;

public class LoginTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	FacebookMainPage fbMainPage;
	FacebookLoginPage fbLoginPage;
	FacebookMainFeed fbMainFeed;

	@BeforeClass(alwaysRun = true)
	public void setup(){		
		this.driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 2);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
		fbLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class);
		fbMainFeed = PageFactory.initElements(driver, FacebookMainFeed.class);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		driver.close();
	}
	
	@Test(groups={"p1", "pageLoads"})
	public void loadPage(){
		fbMainPage.loadPage();
	}
	
	@Test(groups={"p2", "fields"}, dependsOnMethods="loadPage")
	public void filloutEmailFld(){
		fbMainPage.setText_EmailLogin("anthony.vito11@hotmail.com");		
	}
	
	@Test(groups={"p2", "fields"}, dependsOnMethods="filloutEmailFld")
	public void filloutPassFld(){
		fbMainPage.setText_PasswordLogin("123456");
	}
	
	@Test(groups="p1", dataProviderClass = FacebookData.class, dataProvider = "login")
	public void testLoginMainPage(String email, String password, String errorType){
		driver.manage().deleteAllCookies();
		fbMainPage.loadPage();
		fbMainPage.login(email, password);
		if(!StringUtils.isBlank(errorType)){
			boolean result = fbLoginPage.checkErrorMessage(errorType);
			Assert.assertTrue(result, "Valid message displayed");
		}
		else {
			Assert.assertTrue(!fbMainFeed.getUsernameText().isEmpty());
		}

		
	}
	
}
