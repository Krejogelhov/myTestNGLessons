package com.testngtutorial.MyTestNGTutorial.data;

import org.testng.annotations.DataProvider;

public class YandexData {
	
	@DataProvider(name="login")
	public static Object[][] login(){
		return new Object[][]{
			{"a.d.black@yandex.by", "d00msday", null},
		};
	}

}
