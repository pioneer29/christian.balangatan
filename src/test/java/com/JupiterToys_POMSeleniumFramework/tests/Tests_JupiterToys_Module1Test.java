package com.JupiterToys_POMSeleniumFramework.tests;

import org.testng.annotations.Test;

import com.JupiterToys_POMSeleniumFramework.datautil.Common;
import com.JupiterToys_POMSeleniumFramework.datautil.DataRetriever;
import com.JupiterToys_POMSeleniumFramework.pages.PO_Contact;
import com.JupiterToys_POMSeleniumFramework.pages.PO_Home;
import com.JupiterToys_POMSeleniumFramework.pages.PO_Shop;
import com.JupiterToys_POMSeleniumFramework.webdriver.Browser;

public class Tests_JupiterToys_Module1Test extends BaseTest {
//
//	@Test(priority = 1)
//	public void Tests_JupiterToys_Module1_TC1() {
//
//		try {
//			
//			// Initialize Page/s:
//			PO_Home Home = new PO_Home();
//			PO_Contact Contact = new PO_Contact();
//			
//			// Initialize Data:
//			String strForename = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.FORNAME_VALID);
//			String strSurname = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.SURNAME_VALID);
//			String strEmail = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.EMAIL_VALID);
//			String strTelephone = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.TELEPHONE_VALID);
//			String strMessage = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.MESSAGE);
//			
//			//	1.	From the home page go to contact page
//			funcLogTest(TEST_INFO, "Step 1: From the home page go to contact page");
//			if (Home.funcNavigate("Contact")) {
//				funcLogTest(TEST_PASSED, "Step 1: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 1: FAILED " + errorDesc);
//			}
//			
//			//	2.	 Click submit button
//			funcLogTest(TEST_INFO, "Step 2: Click submit button");
//			if (Contact.funcClickSubmit()) {
//				funcLogTest(TEST_PASSED, "Step 2: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 2: FAILED " + errorDesc);
//			}
//			
//			//	3.	Validate errors
//			funcLogTest(TEST_INFO, "Step 3: Validate errors");
//			if (Contact.funcValidateErrorsForRequiredFieldsExist()) {
//				funcLogTest(TEST_PASSED, "Step 3: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 3: FAILED " + errorDesc);
//			}
//			
//			//	4.	Populate mandatory fields
//			funcLogTest(TEST_INFO, "Step 4: Populate mandatory fields");
//			if (Contact.funcPopulateContactPageFields(strForename, "", strEmail, "", strMessage)) {
//				funcLogTest(TEST_PASSED, "Step 4: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 4: FAILED " + errorDesc);
//			}
//			
//			//	5. 	Validate errors are gone
//			funcLogTest(TEST_INFO, "Step 5: Validate errors are gone");
//			if (Contact.funcValidateErrorsForRequiredFieldsNotDisplayed()) {
//				funcLogTest(TEST_PASSED, "Step 5: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 5: FAILED" + errorDesc);
//			}
//			
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			exception_error = e.getMessage();
//			funcLogTest(TEST_FAILED, exception_error);
//			funcReportTestCaseStatus(testCase, FAILED);
//		}
//	}
//	
//
//	@Test(priority = 2)
//	public void Tests_JupiterToys_Module1_TC2() {
//
//		try {
//			
//			// Initialize Page/s:
//			PO_Home Home = new PO_Home();
//			PO_Contact Contact = new PO_Contact();
//			
//			// Initialize Data:
//			String strForename = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.FORNAME_VALID);
//			String strEmail = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.EMAIL_VALID);
//			String strMessage = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.MESSAGE);
//			
//			//	1.	From the home page go to contact page
//			funcLogTest(TEST_INFO, "Step 1: From the home page go to contact page");
//			if (Home.funcNavigate("Home") && Home.funcNavigate("Contact")) {
//				funcLogTest(TEST_PASSED, "Step 1: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 1: FAILED " + errorDesc);
//			}
//
//			//	2.	Populate mandatory fields
//			funcLogTest(TEST_INFO, "Step 2: Populate mandatory fields");
//			if (Contact.funcPopulateContactPageFields(strForename, "", strEmail, "", strMessage)) {
//				funcLogTest(TEST_PASSED, "Step 2: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 2: FAILED " + errorDesc);
//			}
//			
//			//	3.	 Click submit button
//			funcLogTest(TEST_INFO, "Step 3: Click submit button");
//			if (Contact.funcClickSubmit()) {
//				funcLogTest(TEST_PASSED, "Step 3: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 3: FAILED " + errorDesc);
//			}
//			
//			//	4. 	Validate successful submission message
//			funcLogTest(TEST_INFO, "Step 4: Validate successful submission message");
//			if (Contact.funcValidateSuccessfulSubmissionMessage("Thanks " + strForename + ", we appreciate your feedback.")) {
//				funcLogTest(TEST_PASSED, "Step 4: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 4: FAILED" + errorDesc);
//			}
//			
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			exception_error = e.getMessage();
//			funcLogTest(TEST_FAILED, exception_error);
//			funcReportTestCaseStatus(testCase, FAILED);
//		}
//	}
//
//
//	@Test(priority = 3)
//	public void Tests_JupiterToys_Module1_TC3() {
//
//		try {
//			
//			// Initialize Page/s:
//			PO_Home Home = new PO_Home();
//			PO_Contact Contact = new PO_Contact();
//			
//			// Initialize Data:
//			String strForename = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.FORNAME_INVALID);
//			String strSurname = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.SURNAME_VALID);
//			String strEmail = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.EMAIL_INVALID);
//			String strTelephone = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.TELEPHONE_VALID);
//			String strMessage = DataRetriever.funcGetDataFromExcel(Common.TESTDATA_EXCEL, Common.TESTDATA_MODULE1,
//					Common.REFERENCE_VALUE_MODULE1, testCase, Common.MESSAGE);
//			
//			//	1.	From the home page go to contact page
//			funcLogTest(TEST_INFO, "Step 1: From the home page go to contact page");
//			if (Home.funcNavigate("Home") && Home.funcNavigate("Contact")) {
//				funcLogTest(TEST_PASSED, "Step 1: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 1: FAILED " + errorDesc);
//			}
//			
//			//	2.	Populate mandatory fields with invalid data
//			funcLogTest(TEST_INFO, "Step 2: Populate mandatory fields with invalid data");
//			if (Contact.funcPopulateContactPageFields("", "", strEmail, "", "")) {
//				funcLogTest(TEST_PASSED, "Step 2: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 2: FAILED " + errorDesc);
//			}
//			
//			//	3.	 Click submit button
//			funcLogTest(TEST_INFO, "Step 3: Click submit button");
//			if (Contact.funcClickSubmit()) {
//				funcLogTest(TEST_PASSED, "Step 3: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 3: FAILED " + errorDesc);
//			}
//			
//			//	4.	Validate errors
//			funcLogTest(TEST_INFO, "Step 4: Validate errors");
//			if (Contact.funcValidateErrorsForInvalidData()) {
//				funcLogTest(TEST_PASSED, "Step 4: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 4: FAILED " + errorDesc);
//			}
//			
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			exception_error = e.getMessage();
//			funcLogTest(TEST_FAILED, exception_error);
//			funcReportTestCaseStatus(testCase, FAILED);
//		}
//	}
//	

	@Test(priority = 4)
	public void Tests_JupiterToys_Module1_TC4() {

		try {
			
			// Initialize Page/s:
			PO_Home Home = new PO_Home();
			PO_Shop Shop = new PO_Shop();
			
			//	1.	From the home page go to shop page
			funcLogTest(TEST_INFO, "Step 1: From the home page go to shop page");
			if (Home.funcNavigate("Home") && Home.funcNavigate("Shop")) {
				funcLogTest(TEST_PASSED, "Step 1: PASSED");
			} else {
				funcLogTest(TEST_FAILED, "Step 1: FAILED " + errorDesc);
			}
			
			//	2.	Click buy button 2 times on “Funny Cow”
			funcLogTest(TEST_INFO, "Step 2: Click buy button 2 times on “Funny Cow”");
			if (Shop.funcClickBuy("Funny Cow")) {
				funcLogTest(TEST_PASSED, "Step 2: PASSED");
			} else {
				funcLogTest(TEST_FAILED, "Step 2: FAILED " + errorDesc);
			}
			
			if (Shop.funcClickBuy("Funny Cow")) {
				funcLogTest(TEST_PASSED, "Step 2: PASSED");
			} else {
				funcLogTest(TEST_FAILED, "Step 2: FAILED " + errorDesc);
			}
			
			//	3.	 Click buy button 1 time on “Fluffy Bunny”
			funcLogTest(TEST_INFO, "Step 3: Click buy button 1 time on “Fluffy Bunny”");
			if (Shop.funcClickBuy("Fluffy Bunny")) {
				funcLogTest(TEST_PASSED, "Step 2: PASSED");
			} else {
				funcLogTest(TEST_FAILED, "Step 2: FAILED " + errorDesc);
			}
			
			//	4.	Click the cart menu
			funcLogTest(TEST_INFO, "Step 4: Click the cart menu");
			if (Home.funcNavigate("Cart")) {
				funcLogTest(TEST_PASSED, "Step 4: PASSED");
			} else {
				funcLogTest(TEST_FAILED, "Step 4: FAILED " + errorDesc);
			}
			
//			//	5.	Verify the items are in the cart - Funny Cow
//			funcLogTest(TEST_INFO, "Step 5: Verify the items are in the cart - Funny Cow");
//			if (Shop.funcValiateCartTable("Item", "Funny Cow", "Quantity", "2")) {
//				funcLogTest(TEST_PASSED, "Step 5: PASSED");
//			} else {
//				funcLogTest(TEST_FAILED, "Step 5: FAILED " + errorDesc);
//			}
			
			//	5.	Verify the items are in the cart - Fluffy Bunny
			funcLogTest(TEST_INFO, "Step 5: Verify the items are in the cart - Fluffy Bunny");
			if (Shop.funcValiateCartTable("Item", "Fluffy Bunny", "Quantity", "2")) {
				funcLogTest(TEST_PASSED, "Step 5: PASSED");
			} else {
				funcLogTest(TEST_FAILED, "Step 5: FAILED " + errorDesc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			exception_error = e.getMessage();
			funcLogTest(TEST_FAILED, exception_error);
			funcReportTestCaseStatus(testCase, FAILED);
		}
	}
	
}
