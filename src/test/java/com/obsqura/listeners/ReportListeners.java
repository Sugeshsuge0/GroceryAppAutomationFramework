package com.obsqura.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obsqura.utilities.ExtentReoprterNG;
import com.obsqura.utilities.PageUtility;

public class ReportListeners implements ITestListener {
    WebDriver driver;


	ExtentReports extent =ExtentReoprterNG.GenerateExtentReport();
	ExtentTest test ;
	
	
	@Override
	public void onTestStart(ITestResult result) {
	    String testName = result.getMethod().getMethodName();
		test=extent.createTest(testName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			test.addScreenCaptureFromPath(PageUtility.getScreenshot(), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

	@Override
	public void onFinish(ITestContext context) {
	
		extent.flush();
	}

	
	
}
