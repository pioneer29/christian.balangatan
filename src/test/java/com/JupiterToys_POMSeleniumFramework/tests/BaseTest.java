package com.JupiterToys_POMSeleniumFramework.tests;

import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.JupiterToys_POMSeleniumFramework.datautil.Common;
import com.JupiterToys_POMSeleniumFramework.datautil.DataRetriever;
import com.JupiterToys_POMSeleniumFramework.pages.BasePage;
import com.JupiterToys_POMSeleniumFramework.pages.PO_Home;
import com.JupiterToys_POMSeleniumFramework.webdriver.Browser;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class BaseTest extends BasePage {

	protected static final Logger logger = LogManager.getLogger(BaseTest.class);


	@Parameters({ "browser_name" })
	@BeforeClass
	public void BeforeClass( @Optional("browser_name")String strBrowserName) throws Exception {
		
		initializeLogger();
		
		String strURL = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_LOGIN,
				Common.REFERENCE_VALUE_LOGIN, "QA", Common.URL);
		
		Browser.funcInitializeBrowser(strBrowserName);
		
		funcInitializeExtentReport();
		
		logger.info("Opening: " + strURL);
		
		Browser.open(strURL, strBrowserName);
		
		funcWaitTime(5);
		
		
	}

	@BeforeMethod
	public void BeforeMethod(Method m) {
		testCase = m.getName();
		extentTest = report.createTest(testCase);
		logger.info("Created Test Case: " + testCase);
		
	}

	@AfterMethod
	public void AfterMethod(ITestResult result) {
		
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
