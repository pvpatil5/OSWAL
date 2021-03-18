package com.oswal.android.reports;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.oswal.android.init.PathConstants;
import com.oswal.android.lib.GenericLib;

public class ExtentManager 
{
	public static ExtentReports report;
	public static ExtentTest testlog;
	
	public static void report(ITestContext result )
	{
		ExtentSparkReporter html=new ExtentSparkReporter(PathConstants.extentreport);
		html.config().setDocumentTitle("Appium Framework");
		html.config().setReportName("OSWAL APP");
		html.config().setTheme(Theme.DARK);


		report=new ExtentReports();
		report.attachReporter(html);
		testlog=report.createTest(result.getName());
		

	}
}

