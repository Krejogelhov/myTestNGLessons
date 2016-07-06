package com.testngtutorial.MyTestNGTutorial;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testngtutorial.MyTestNGTutorial.data.FacebookData;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookLoginPage;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookMainFeed;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookMainPage;
import com.testngtutorial.MyTestNGTutorial.utilities.DriverFactory;

public class LoginTest {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	FacebookMainPage fbMainPage;
	FacebookLoginPage fbLoginPage;
	FacebookMainFeed fbMainFeed;

	@BeforeClass(alwaysRun = true)
	public void setup(){		
		this.driver = DriverFactory.getDriver(DriverFactory.getBrowserTypeByProperty());
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
	
	
	@Parameters ({"randomEmail"})
	@Test(groups={"p2", "fields"}, dependsOnMethods="loadPage")
	public void filloutEmailFld(@Optional("blabla@gmail.com") String randomEmail){
		fbMainPage.setText_EmailLogin(randomEmail);		
	}
	
	@Parameters ({"randomEmail"})
	@Test(groups={"p2", "fields"}, dependsOnMethods="filloutEmailFld")
	public void filloutPassFld(@Optional("justrandompass") String randomPassword){
		fbMainPage.setText_PasswordLogin(randomPassword);
	}
	
	@Test(groups="p1", dataProviderClass = FacebookData.class, dataProvider = "login")
	public void testLoginMainPage(String email, String password, String urlDetails){
		driver.manage().deleteAllCookies();
		fbMainPage.loadPage();
		fbMainPage.login(email, password);
		if(!StringUtils.isBlank(urlDetails)){
			boolean result = fbLoginPage.checkUrlDetails(driver, urlDetails);
			Assert.assertTrue(result, "Valid page displayed");
		}
		else {
			Assert.assertTrue(!fbMainFeed.getUsernameText().isEmpty());
		}

		
	}
	
}
