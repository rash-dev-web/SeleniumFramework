package com.qa.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success: "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failure: "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed with some Success: "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Start: "+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finished: "+context.getName());
		
	}

}
