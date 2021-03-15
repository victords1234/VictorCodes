package com.vtigercrm.genericutilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryAnalyzer implements IRetryAnalyzer {
	public boolean retry(ITestResult result) {

		int counter=0;
		int uptoCounter=1;
		while(counter<uptoCounter)
		{
			counter++;
			return true;
		}
		return false;
	}
}
