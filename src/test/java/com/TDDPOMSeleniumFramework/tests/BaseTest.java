package com.TDDPOMSeleniumFramework.tests;

import java.lang.reflect.Method;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.TDDPOMSeleniumFramework.pages.BasePage;
import com.TDDPOMSeleniumFramework.pages.PO_Login;
import com.TDDPOMSeleniumFramework.webdriver.Browser;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class BaseTest extends BasePage {

	protected static final Logger logger = LogManager.getLogger(BaseTest.class);
	


	@Parameters({ "browser_name" })
	@BeforeClass
	public void BeforeClass(String strBrowserName) {
		initializeLogger();
		String strUserName = "automationuser";
		String strPassword = "password";
		String strURL = "http://demo.guru99.com/test/newtours/index.php";
		Browser.funcInitializeBrowser(strBrowserName);
		funcInitializeExtentReport();
		logger.info("Opening: " + strURL);
		Browser.open(strURL, strBrowserName);
		funcWaitTime(5);
		PO_Login.funcLogin(strUserName, strPassword);
		
	}

	@BeforeMethod
	public void BeforeMethod(Method m) {
		testCase = m.getName();
		extentTest = report.createTest(testCase);
		logger.info("Created Test Case: " + testCase);
	}

	@AfterMethod
	public void AfterMethod(ITestResult result) {
		
		funcReportTestCaseStatus(testCase, TEST_STATUS);
		
		logger.info(result.toString());

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, MarkupHelper.createLabel("[" + result.getTestClass().getName() + "]" + " |"
					+ "[" + result.getName() + "]" + " Test case FAILED", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.INFO, MarkupHelper.createLabel("[" + result.getTestClass().getName() + "]" + " |"
					+ "[" + result.getName() + "]" + " Test case EXECUTED", ExtentColor.BLUE));
		} else {
			extentTest.log(Status.SKIP, MarkupHelper.createLabel("[" + result.getTestClass().getName() + "]" + " |"
					+ "[" + result.getName() + "]" + " Test case SKIPPED", ExtentColor.ORANGE));
			extentTest.skip(result.getThrowable());
		}
	}

	@AfterClass
	public void AfterClass() {

		report.flush();
		Browser.close();
	}

	
	
}
