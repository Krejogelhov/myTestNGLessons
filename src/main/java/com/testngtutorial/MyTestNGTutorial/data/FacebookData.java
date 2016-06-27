package com.testngtutorial.MyTestNGTutorial.data;

import org.testng.annotations.DataProvider;

public class FacebookData {

	@DataProvider(name="pages")
	public static Object[][] pages (){
		return new Object[][]{
			{"http://www.facebook.com", "Facebook - Log In or Sign Up"},
			{"http://www.google.com", "Google"},
			{"http://www.yahoo.com", "Yahoo"}
			};
	}
	
	@DataProvider(name="login")
	public static Object[][] login(){
		return new Object[][]{
			{"k.i.work@mail.ru", "Feamarth2Facebook", null},
			{"","123456", "login_attempt"}
		};
	}
}
