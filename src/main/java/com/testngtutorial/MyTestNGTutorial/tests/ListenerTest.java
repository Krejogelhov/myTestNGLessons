package com.testngtutorial.MyTestNGTutorial.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testngtutorial.MyTestNGTutorial.utilities.MyTestListener;

@Listeners(MyTestListener.class)
public class ListenerTest {
	
	@Test
	public void Test1Succcess(){
		Assert.assertTrue(true);
	}
	
	@Test
	public void Test2Fail(){
		Assert.assertTrue(false, "I'm asserting false");
	}
	
	@Test(dependsOnMethods="Test2Fail")
	public void Test2Skip(){
		//throw new SkipException("I'm skipping it, pal.");
		Assert.assertTrue(true);
	}

}
