package com.obsqura.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReoprterNG {

	
	public static ExtentReports GenerateExtentReport() {
		String path =System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Grocery Mart Automation");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports  extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Sugesh");
		extent.setSystemInfo("Environment", "QA");
		return extent;
	}
}
