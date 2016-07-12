package com.testngtutorial.MyTestNGTutorial.tests;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import com.testngtutorial.MyTestNGTutorial.data.FacebookData;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookLoginPage;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookMainFeed;
import com.testngtutorial.MyTestNGTutorial.pages.FacebookMainPage;
import com.testngtutorial.MyTestNGTutorial.utilities.ClassNameDisplayer;
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
	
	@ClassNameDisplayer
	@Test(groups={"p1", "pageLoads"})
	public void loadPage(){
		fbMainPage.loadPage();
		Assert.assertEquals(driver.getTitle() , fbMainPage.getPageTitle());
	}
	
	
	@Parameters ({"randomEmail"})
	@Test(groups={"p2", "fields"}, dependsOnMethods="loadPage")
	public void filloutEmailFld(@Optional("blabla@gmail.com") String randomEmail){
		fbMainPage.setTextEmailLogin(randomEmail);
		Assert.assertEquals(fbMainPage.getFieldEmailLogin().getAttribute("value"), randomEmail);		
	}
	
	@Parameters ({"randomEmail"})
	@Test(groups={"p2", "fields"}, dependsOnMethods="filloutEmailFld")
	public void filloutPassFld(@Optional("justrandompass") String randomPassword){
		fbMainPage.setTextPasswordLogin(randomPassword);
		Assert.assertEquals(fbMainPage.getFieldPasswordLogin().getAttribute("value"), randomPassword);
	}
	
	@Test(groups="p1", dataProviderClass = FacebookData.class, dataProvider = "login")
	public void testLoginMainPage(String email, String password, String urlDetails){
		driver.manage().deleteAllCookies();
		fbMainPage.loadPage();
		fbMainPage.login(email, password);
		if(!StringUtils.isBlank(urlDetails)){
			boolean result = fbLoginPage.isValidUrl(driver, urlDetails);
			Assert.assertTrue(result, "Valid page displayed");
		}
		else {
			Assert.assertTrue(!fbMainFeed.getUsernameText().isEmpty());
		}
		try {        	
			JAXBContext jc = JAXBContext.newInstance(FacebookMainPage.class);	
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
			marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(fbMainPage, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		
	}
	
}
