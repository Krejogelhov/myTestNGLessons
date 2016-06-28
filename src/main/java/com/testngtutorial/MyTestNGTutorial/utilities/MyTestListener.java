package com.testngtutorial.MyTestNGTutorial.utilities;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult testResult){
		System.out.println(testResult.getName() + " was successfull!");
	}
	
	@Override
	public void onTestFailure(ITestResult testResult){
		System.out.println(testResult.getName() + " was a failure. \n Throwable: " + testResult.getThrowable().getMessage());
	}
	
	@Override
	public void onTestSkipped(ITestResult testResult){
		System.out.println(testResult.getName() + " was skipped!");
	}
	
}
