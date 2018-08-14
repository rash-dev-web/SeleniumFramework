package com.qa.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer{

	int minRetryCount=0;
	int maxRetryCount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(minRetryCount<maxRetryCount){
			System.out.println("Failed TC: "+result.getName());
			System.out.println("Count to run: "+(minRetryCount+1));
			minRetryCount++;
			return true;
		}
		return false;
	}

}
