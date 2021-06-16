package com.TDDPOMSeleniumFramework.tests;

import org.testng.annotations.Test;
import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class SmokeTests_NewTours_Module1 extends BaseTest {

	@Test(priority = 1)
	public void SmokeTests_NewTours_Module1_TC1() {

		try {
			if (Browser.getPageTitle().contentEquals("Login: Mercury Toursss")) {
				funcLogTestStep(TEST_PASSED, "Page Title is 'Login: Mercury Tourss' ");
			} else {
				funcLogTestStep(TEST_FAILED, "Page Title is NOT 'Login: Mercury Tourss' ");
			}

		} catch (Exception e) {
			exception_error = e.getMessage();
			funcLogTestStep(TEST_FAILED, exception_error);
			funcReportTestCaseStatus(testCase, FAILED);
		}
	}
	
	@Test(priority = 2)
	public void SmokeTests_NewTours_Module1_TC2() {

		try {
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
