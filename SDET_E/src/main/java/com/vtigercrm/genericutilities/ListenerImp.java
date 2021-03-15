package com.vtigercrm.genericutilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ListenerImp implements ITestListener {
	public ExtentReports report;
	public ExtentTest test;
	public void onStart(ITestResult result)
	{
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./ExtentReport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("VTiger App");
		htmlReporter.config().setReportName("Smoke");
		report =new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Platform","Windows");
		report.setSystemInfo("OS","Windows 10 Pro");
		report.setSystemInfo("Environment","Testing Environment");
		report.setSystemInfo("Reporter","Victor");
	}
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL,result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL,result.getThrowable());
		WebDriverUtility wUtil=new WebDriverUtility();
		try {
			String path=wUtil.takeScreenShot(BaseClass.staticdriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	}
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP,result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP,result.getThrowable());
	}
	public void onTestStart(ITestResult result)
	{
		test=report.createTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,result.getMethod().getMethodName()+" is passed");
	}
	public void onFinish(ITestResult result)
	{
		report.flush();
	}
}
