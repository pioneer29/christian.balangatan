package com.TDDPOMSeleniumFramework.tests;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import com.TDDPOMSeleniumFramework.datautil.Common;
import com.TDDPOMSeleniumFramework.pages.BasePage;
import com.TDDPOMSeleniumFramework.webdriver.Browser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest extends BasePage {
	
	protected static final Logger logger = LogManager.getLogger(BaseTest.class);
	public static ExtentTest extentTest;
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;
	protected String testCase;
	protected String extentReportFilePath;
	protected String reportName;
	
	
	
	
	@Parameters({"browser_name"})
	@BeforeClass
	public void BeforeClass(String strBrowserName) {
		String strURL = "http://demo.guru99.com/test/newtours/index.php";
		Browser.funcInitializeBrowser(strBrowserName);
		Browser.open(strURL);
		funcWaitTime(10);
		
		funcInitializeExtentReport();
	}
	
	@BeforeMethod
	public void BeforeMethod(Method m) {
		testCase = m.getName();
		extentTest = report.createTest(testCase);
		logger.info("Created Test Case: " + testCase);
	}
	
	public void funcInitializeExtentReport() {
		
		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		Date dateobj = new Date();
		
		
		new File (Common.PATH_REPORT).mkdir();
		
		reportName = "TestNG-" + df.format(dateobj) + ".html";
		
		logger.info("Creating extent report: " + reportName);
		
		extentReportFilePath = Common.PATH_REPORT + reportName;
		
		htmlReporter = new ExtentHtmlReporter(extentReportFilePath);
		
		report = new ExtentReports();
		
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("Environment", "QA");
		
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("TDDPOMSeleniumFramework");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		logger.info("Completed creating extent report: " + reportName);
	}
}
