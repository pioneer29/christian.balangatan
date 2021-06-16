package com.TDDPOMSeleniumFramework.tests;

import org.testng.annotations.Test;

import com.TDDPOMSeleniumFramework.datautil.Common;
import com.TDDPOMSeleniumFramework.datautil.DataRetriever;
import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class SmokeTests_NewTours_Module1 extends BaseTest {

	@Test(priority = 1)
	public void SmokeTests_NewTours_Module1_TC1() {

		try {
			
			// Initialize Data:
			String strFirstName = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
					Common.REFERENCE_VALUE_MODULE1, testCase, Common.FIRSTNAME);
			String strLasttName = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
					Common.REFERENCE_VALUE_MODULE1, testCase, Common.LASTNAME);

			funcLogTestStep(TEST_PASSED, "First Name: " + strFirstName);
			funcLogTestStep(TEST_PASSED, "Last Name: " + strLasttName);
			if (Browser.getPageTitle().contentEquals("Login: Mercury Toursss")) {
				funcLogTestStep(TEST_PASSED, "Page Title is 'Login: Mercury Tourss' ");
			} else {
				funcLogTestStep(TEST_FAILED, "Page Title is NOT 'Login: Mercury Tourss' ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			exception_error = e.getMessage();
			funcLogTestStep(TEST_FAILED, exception_error);
			funcReportTestCaseStatus(testCase, FAILED);
		}
	}

	@Test(priority = 2)
	public void SmokeTests_NewTours_Module1_TC2() {

		try {
			
			// Initialize Data:
			String strFirstName = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
					Common.REFERENCE_VALUE_MODULE1, testCase, Common.FIRSTNAME);
			String strLasttName = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
					Common.REFERENCE_VALUE_MODULE1, testCase, Common.LASTNAME);
			
			funcLogTestStep(TEST_PASSED, "First Name: " + strFirstName);
			funcLogTestStep(TEST_PASSED, "Last Name: " + strLasttName);
			
			if (Browser.getPageTitle().contentEquals("Login: Mercury Tours")) {
				funcLogTestStep(TEST_PASSED, "Page Title is 'Login: Mercury Tours' ");
			} else {
				funcLogTestStep(TEST_FAILED, "Page Title is NOT 'Login: Mercury Tours' ");
			}

		} catch (Exception e) {
			exception_error = e.getMessage();
			funcLogTestStep(TEST_FAILED, exception_error);
			funcReportTestCaseStatus(testCase, FAILED);
		}
	}
}
