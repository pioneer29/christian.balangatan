package com.TDDPOMSeleniumFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.TDDPOMSeleniumFramework.pages.BasePage;
import com.TDDPOMSeleniumFramework.reporter.Log;

public class PO_Login extends BasePage {
	
	public static final String TXT_USERNAME = "//input[@name='userName']";
	@FindBy (xpath = TXT_USERNAME)
	public WebElement txtUserName;
	
	public static final String TXT_PASSWORD = "//input[@name='password']";
	@FindBy (xpath = TXT_PASSWORD)
	public WebElement txtPassword;

	public static final String BTN_SUBMIT = "//input[@name='submit']";
	@FindBy (xpath = BTN_SUBMIT)
	public WebElement btnSubmit;
	
	
	public static void funcLogin(String strUserName, String strPassword) {
		if (isElementDisplayed("[Username] textfield", TXT_USERNAME, XPATH)) {
			funcSetTextElement("[Username] textfield", TXT_USERNAME, strUserName, XPATH);
			funcSetTextElement("[Password] textfield", TXT_PASSWORD, strPassword, XPATH);
			funcClickElement("[Submit] button", BTN_SUBMIT, XPATH);
			funcWaitTime(5);
		} else {
			Log.testStep(TEST_FAILED, errorDesc);
		}
	}
	
}
