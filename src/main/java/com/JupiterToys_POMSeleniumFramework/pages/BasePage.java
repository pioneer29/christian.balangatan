package com.JupiterToys_POMSeleniumFramework.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.JupiterToys_POMSeleniumFramework.datautil.Common;
import com.JupiterToys_POMSeleniumFramework.datautil.DataRetriever;
import com.JupiterToys_POMSeleniumFramework.reporter.Screenshot;
import com.JupiterToys_POMSeleniumFramework.webdriver.Browser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class BasePage {
	protected static final Logger logger = LogManager.getLogger(BasePage.class);
	
	public static WebDriver driver;
	protected static final String ID = "id";
	protected static final String NAME = "name";
	protected static final String CSS = "css";
	protected static final String XPATH = "xpath";

	protected static final String MSG_ELEMENT_NOT_DISPLAYED = "is not displayed.";
	protected static final String MSG_ELEMENT_NOT_ENABLED = "is not enabled.";
	protected static final String MSG_ELEMENT_NOT_SELECTED = "is not selected.";
	protected static final String MSG_ELEMENT_NOT_TEXTVALUE_NOT_EMPTY = "is not empty.";

	protected static String errorDesc = "";
	protected static boolean result = true;
	protected static final String TEST_PASSED = "PASSED";
	protected static final String TEST_FAILED = "FAILED";
	protected static final String TEST_INFO = "INFO";
	protected static boolean TEST_STATUS = true;
	protected static final boolean PASSED = true;
	protected static final boolean FAILED = false;
	
	public static ExtentTest extentTest;
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;
	protected String testCase;
	protected String extentReportFilePath;
	protected String reportName;
	public static String exception_error = "";
	
	public static String screenshotName;

	/**
	 * <h1>getBy</h1>
	 * <ul>
	 * This method returns the element locator type
	 * </ul>
	 * @param elementLocator (locator value)
	 * @param strByType (By Type value)
	 * @return byValue - element locator type
	 **/
	public static By getBy (String elementLocator, String byType) {
		By byValue = null;
		switch (byType.toLowerCase()) {
		case "id":
			byValue = By.id(elementLocator);
			break;
		case "name":
			byValue = By.name(elementLocator);
			break;
		case "css":
			byValue = By.cssSelector(elementLocator);
			break;
		case "xpath":
			byValue = By.xpath(elementLocator);
			break;
			
		}
		
		
		
		return byValue;
		
	}
	/**
	 * <h1>isElementDisplayed</h1>
	 * <ul>
	 * This method checks if element is displayed
	 * </ul>
	 * @param strElementName (element name)
	 * @param strLocator (locator value)
	 * @param strByType (By Type value)
	 * @return boolean - true if element is displayed or false if element is NOT
	 *         displayed
	 **/
	public static boolean isElementDisplayed(String strElementName, String strLocator, String strByType) {

		result = true;

		try {
			WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
			if (!element.isDisplayed()) {
				errorDesc = strElementName + MSG_ELEMENT_NOT_DISPLAYED;
				result = false;
			}
		} catch (Exception e) {
			errorDesc = strElementName + MSG_ELEMENT_NOT_DISPLAYED + " Excepton: " + e;
			result = false;
		}

		return result;

	}
	
	
	/**
	 * <h1>isElementNotDisplayed</h1>
	 * <ul>
	 * This method checks if element is NOT displayed
	 * </ul>
	 * @param strElementName (element name)
	 * @param strLocator (locator value)
	 * @param strByType (By Type value)
	 * @return boolean - true if element is displayed or false if element is NOT
	 *         displayed
	 **/
	public static boolean isElementNotDisplayed(String strElementName, String strLocator, String strByType) {

		result = true;

		List<WebElement> element = driver.findElements(By.xpath(strLocator));
		if (element.size() > 0) {
			errorDesc = strElementName + " is displayed";
			result = false;
		}

		return result;

	}
	
	public static WebElement getElement(By by) {
		return Browser.getDriver().findElement(by);
	}
	
	public static int getSize(By by) {
		return Browser.getDriver().findElements(by).size();
	}
	
	
	/**
	 * <h1>funcClickElement</h1>
	 * <ul>
	 * This method clicks an element
	 * </ul>
	 * @param strElementName (element name)
	 * @param strLocator (locator value)
	 * @param strByType (By Type value)
	 * @return none
	 **/
	public static void funcClickElement(String strElementName, String strLocator, String strByType) {
		WebElement element = getElement(getBy(strLocator, strByType));
		element.click();
	}
	
	/**
	 * <h1>funcSetTextElement</h1>
	 * <ul>
	 * This method sets a text in element
	 * </ul>
	 * @param strElementName (element name)
	 * @param strLocator (locator value)
	 * @param strKeyToSend (text to set)
	 * @param strByType (By Type value)
	 * @return none
	 **/
	public static void funcSetTextElement(String strElementName, String strLocator, String strKeyToSend,String strByType) {
		WebElement element = getElement(getBy(strLocator, strByType));
		element.clear();
		element.sendKeys(strKeyToSend);
	}
	

	/**
	 * <h1>funcGetTextElement</h1>
	 * <ul>
	 * This method gets a text in element
	 * </ul>
	 * @param strElementName (element name)
	 * @param strLocator (locator value)
	 * @param strByType (By Type value)
	 * @return 
	 * @return none
	 **/
	public static String funcGetTextElement(String strElementName, String strLocator, String strByType) {
		WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
		System.out.println(strElementName + "text value: " + element.getText());
		return element.getText();
	}
	
	/**
	 * <h1>funcWaitTime</h1>
	 * <ul>
	 * This method sets a specific wait time
	 * </ul>
	 * @param intTime (time in seconds)
	 * @return none
	 **/
	public static void funcWaitTime(int intTime) {
		try {
			Thread.sleep(intTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <h1>funcInitializeExtentReport</h1>
	 * <ul>
	 * This method initiates the creation of Extent Html report
	 * </ul>
	 * 
	 * @return Html Report
	 **/
	public void funcInitializeExtentReport() {

		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		Date dateobj = new Date();

		new File(Common.PATH_REPORT).mkdir();

		reportName = "TestNG-JupiterToys_SeleniumFramework-Report_" + df.format(dateobj) + ".html";

		logger.info("Creating extent report: " + reportName);

		extentReportFilePath = Common.PATH_REPORT + reportName;

		htmlReporter = new ExtentHtmlReporter(extentReportFilePath);

		report = new ExtentReports();

		report.attachReporter(htmlReporter);

		report.setSystemInfo("Environment", "QA");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("JupiterToys_SeleniumFramework");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

		logger.info("Completed creating extent report: " + reportName);
	}

	/**
	 * <h1>funcLogTest</h1>
	 * <ul>
	 * This method logs test details and status in Extent Report
	 * </ul>
	 * @param tag - PASSED, FAILED, INFO, WARNING, SKIP
	 * @param Actual - actual result message
	 * @return none
	 **/
	public static void funcLogTest(String tag, String Actual) {

		SoftAssert soft = new SoftAssert();
		if (tag.toUpperCase() == "PASSED") {
			extentTest.log(Status.PASS, "[ACTUAL RESULT]: " + Actual);
			logger.info(tag + " | [ACTUAL RESULT]: " + Actual);
			TEST_STATUS = PASSED;
			soft.assertTrue(PASSED);
		} else if (tag.toUpperCase() == "FAILED") {

			try {
				Screenshot.capture("FAILED");
				extentTest.addScreenCaptureFromPath(Common.PATH_SCREENSHOTS + screenshotName, "[" + tag + "]");
			} catch (IOException e) {
				e.printStackTrace();
			}

			extentTest.log(Status.FAIL, "[ACTUAL RESULT]: " + Actual);
			logger.info(tag + " | [ACTUAL RESULT]: " + Actual);
			soft.assertFalse(FAILED);

		} else if (tag.toUpperCase() == "WARNING") {
			extentTest.log(Status.WARNING, "[ACTUAL RESULT]: " + Actual);
			logger.info(tag + " | [ACTUAL RESULT]: " + Actual);

		} else if (tag.toUpperCase() == "INFO") {
			extentTest.log(Status.INFO, "[INFO]: " + Actual);
			logger.info(tag + " | [INFO]: " + Actual);

		} else if (tag.toUpperCase() == "SKIP") {
			extentTest.log(Status.SKIP, "[SKIP]: " + Actual);
			logger.info(tag + " | [SKIP]: " + Actual);

		} else {
			logger.info(tag + " is an invalid Status tag.");
		}
	}
	
	
	/**
	 * <h1>funcReportTestCaseStatus</h1>
	 * <ul>
	 * This method set the test case status
	 * </ul>
	 * @param testCaseName
	 * @param blnStatus
	 * @return none
	 **/
	public static void funcReportTestCaseStatus(String testCaseName, boolean blnStatus) {
		
		if(blnStatus) {
			funcLogTest(TEST_PASSED, testCaseName + " passed.");
		} else {
			if(!exception_error.isEmpty()) {
				funcLogTest(TEST_FAILED, "Exception Error: " + exception_error);
			}
			
			funcLogTest(TEST_FAILED, testCaseName + " failed.");
		}
		
	}
	
	/**
	 * <h1>initializeLogger</h1>
	 * <ul>
	 * This method initializes the logger
	 * </ul>
	 * @param none
	 * @return none
	 **/
	protected void initializeLogger() {
        Properties logProperties = new Properties();
 
        try {
            // load log4j properties configuration file
            logProperties.load(new FileInputStream(Common.LOG_PROPERTIES_FILE));
            PropertyConfigurator.configure(logProperties);
            logger.info("Logging initialized.");
        } catch (IOException e) {
            logger.error("Unable to load logging property :", e);
        }
    }
	

}
