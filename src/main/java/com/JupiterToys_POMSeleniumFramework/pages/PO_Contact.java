package com.JupiterToys_POMSeleniumFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.JupiterToys_POMSeleniumFramework.pages.BasePage;

public class PO_Contact extends BasePage {

	public static final String TXT_FORENAME = "//input[@id='forename']";
	@FindBy(xpath = TXT_FORENAME)
	public WebElement txtForename;

	public static final String TXT_SURNAME = "//input[@id='surname']";
	@FindBy(xpath = TXT_SURNAME)
	public WebElement txtSurame;

	public static final String TXT_EMAIL = "//input[@id='email']";
	@FindBy(xpath = TXT_EMAIL)
	public WebElement txtEmail;

	public static final String TXT_TELEPONE = "//input[@id='telephone']";
	@FindBy(xpath = TXT_TELEPONE)
	public WebElement txtTelephone;

	public static final String TXT_MESSAGE = "//textarea[@id='message']";
	@FindBy(xpath = TXT_MESSAGE)
	public WebElement txtMessage;

	public static final String BTN_SUBMIT = "//a[@class='btn-contact btn btn-primary']";
	@FindBy(xpath = BTN_SUBMIT)
	public WebElement btnSubmit;

	public static final String LBL_MAIN_ERROR_MESSAGE = "//div[@class='alert alert-error ng-scope']";
	@FindBy(xpath = LBL_MAIN_ERROR_MESSAGE)
	public WebElement lblMainErrorMessage;

	public static final String LBL_MAIN_SUCCESS_MESSAGE = "//div[@class='alert alert-success']";
	@FindBy(xpath = LBL_MAIN_SUCCESS_MESSAGE)
	public WebElement lblMainSuccessMessage;
	
	public static final String LBL_FORENAME_ERROR_MESSAGE = "//span[@id='forename-err']";
	@FindBy(xpath = LBL_FORENAME_ERROR_MESSAGE)
	public WebElement lblForenameErrorMessage;

	public static final String LBL_EMAIL_ERROR_MESSAGE = "//span[@id='email-err']";
	@FindBy(xpath = LBL_EMAIL_ERROR_MESSAGE)
	public WebElement lblEmailErrorMessage;

	public static final String LBL_MESSAGE_ERROR_MESSAGE = "//span[@id='message-err']";
	@FindBy(xpath = LBL_MESSAGE_ERROR_MESSAGE)
	public WebElement lblMessageErrorMessage;

	public boolean funcPopulateContactPageFields(String strForename, String strSurname, String strEmail,
			String strTelephone, String strMessage) {

		// Initialize result boolean value:
		result = true;

		// For Forename
		if (!strForename.isEmpty()) {
			if (isElementDisplayed("[Forename] textfield", TXT_FORENAME, XPATH)) {
				funcSetTextElement("[Forename] textfield", TXT_FORENAME, strForename, XPATH);
			} else {
				result = false;
			}
		}

		// For Surname
		if (!strSurname.isEmpty()) {
			if (isElementDisplayed("[Surname] textfield", TXT_SURNAME, XPATH)) {
				funcSetTextElement("[Surname] textfield", TXT_SURNAME, strSurname, XPATH);
			} else {
				result = false;
			}
		}

		// For Email
		if (!strEmail.isEmpty()) {
			if (isElementDisplayed("[Email] textfield", TXT_EMAIL, XPATH)) {
				funcSetTextElement("[Email] textfield", TXT_EMAIL, strEmail, XPATH);
			} else {
				result = false;
			}
		}

		// For Telephone
		if (!strTelephone.isEmpty()) {
			if (isElementDisplayed("[Telephone] textfield", TXT_TELEPONE, XPATH)) {
				funcSetTextElement("[Telephone] textfield", TXT_TELEPONE, strTelephone, XPATH);
			} else {
				result = false;
			}
		}

		// For Message
		if (!strMessage.isEmpty()) {
			if (isElementDisplayed("[Message] textfield", TXT_MESSAGE, XPATH)) {
				funcSetTextElement("[Message] textfield", TXT_MESSAGE, strMessage, XPATH);
			} else {
				result = false;
			}
		}

		return result;

	}
	
	public boolean funcClickSubmit() {
		
		// Initialize result boolean value:
		result = true;
		
		if (isElementDisplayed("[Submit] buton", BTN_SUBMIT, XPATH)) {
			funcClickElement("[Submit] button", BTN_SUBMIT, XPATH);
		} else {
			result = false;
		}
		
		return result;
	}

	public boolean funcValidateErrorsForRequiredFieldsExist() {

		// Initialize result boolean value:
		result = true;
		
		// For Forename
		if (isElementDisplayed("[Forename] Required label", LBL_FORENAME_ERROR_MESSAGE, XPATH)) {
			if(!funcValidateText("[Forename] Required label", LBL_FORENAME_ERROR_MESSAGE, "Forename is required")) {
				result = false;
			}
		} else {
			result = false;
		}

		// For Email
		if (isElementDisplayed("[Email] Required label", LBL_EMAIL_ERROR_MESSAGE, XPATH)) {
			if(!funcValidateText("[Email] Required label", LBL_EMAIL_ERROR_MESSAGE, "Email is required")) {
				result = false;
			}
		} else {
			result = false;
		}
		
		// For Message
		if (isElementDisplayed("[Message] Required label", LBL_MESSAGE_ERROR_MESSAGE, XPATH)) {
			if(!funcValidateText("[Message] Required label", LBL_MESSAGE_ERROR_MESSAGE, "Message is required")) {
				result = false;
			}
		} else {
			result = false;
		}
		
		return result;

	}
	
	public boolean funcValidateErrorsForInvalidData() {

		// Initialize result boolean value:
		result = true;
		
		// For Forename
		if (isElementDisplayed("[Forename] Required label", LBL_FORENAME_ERROR_MESSAGE, XPATH)) {
			if(!funcValidateText("[Forename] Required label", LBL_FORENAME_ERROR_MESSAGE, "Forename is required")) {
				result = false;
			}
		} else {
			result = false;
		}

		// For Email
		if (isElementDisplayed("[Email] Required label", LBL_EMAIL_ERROR_MESSAGE, XPATH)) {
			if(!funcValidateText("[Email] Required label", LBL_EMAIL_ERROR_MESSAGE, "Please enter a valid email")) {
				result = false;
			}
		} else {
			result = false;
		}
		
		// For Message
		if (isElementDisplayed("[Message] Required label", LBL_MESSAGE_ERROR_MESSAGE, XPATH)) {
			if(!funcValidateText("[Message] Required label", LBL_MESSAGE_ERROR_MESSAGE, "Message is required")) {
				result = false;
			}
		} else {
			result = false;
		}
		
		return result;

	}
	
	public boolean funcValidateErrorsForRequiredFieldsNotDisplayed() {

		// Initialize result boolean value:
		result = true;
		
		// For Forename
		if (!isElementNotDisplayed("[Forename] Required label", LBL_FORENAME_ERROR_MESSAGE, XPATH)) {
			result = false;
			return result;
		}

		// For Email
		if (!isElementNotDisplayed("[Email] Required label", LBL_EMAIL_ERROR_MESSAGE, XPATH)) {
			result = false;
			return result;
		}
		
		// For Message
		if (!isElementNotDisplayed("[Message] Required label", LBL_MESSAGE_ERROR_MESSAGE, XPATH)) {
			result = false;
			return result;
		}
		
		return result;

	}
	
	public boolean funcValidateSuccessfulSubmissionMessage(String strExpectedMessage) {

		// Initialize result boolean value:
		result = true;
		
		if (isElementDisplayed("[Sucess] message label", LBL_MAIN_SUCCESS_MESSAGE, XPATH)) {
			if(!funcValidateText("[Sucess] message label", LBL_MAIN_SUCCESS_MESSAGE, strExpectedMessage)) {
				result = false;
			}
		} else {
			result = false;
		}
		
		return result;

	}
	
	private static boolean funcValidateText(String strElementName, String strLocator, String strExpectedText)
	{
		
		String strActualText = funcGetTextElement(strElementName, strLocator, XPATH);
		
		if(strActualText.equalsIgnoreCase(strExpectedText)) {
			return true;
		} else {
			errorDesc = strElementName + " text valued is not: [" + strExpectedText + "] Actual is: [" + strActualText + "]";
			return false;
		}
	}
}
