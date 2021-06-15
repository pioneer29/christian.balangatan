package com.TDDPOMSeleniumFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class BasePage {
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
	protected boolean result = true;
	protected static final boolean PASSED = true;
	protected static final boolean FAILED = false;

	/**
	 * <h1>isElementDisplayed</h1>
	 * <ul>
	 * This method checks if element is displayed
	 * </ul>
	 * @param strElementName (element name)
	 * @param strXpath (xpath value)
	 * @param strByType (By Type value)
	 * @return boolean - true if element is displayed or false if element is NOT
	 *         displayed
	 **/
	public boolean isElementDisplayed(String strElementName, String strXpath, String strByType) {

		result = true;

		if (Browser.getDriver().findElements(By.xpath(strXpath)).size() != 0) {
			WebElement element = Browser.getDriver().findElement(By.xpath(strXpath));
			if (!element.isDisplayed()) {
				errorDesc = strElementName + MSG_ELEMENT_NOT_DISPLAYED;
				result = false;
			}
		} else {
			errorDesc = strElementName + MSG_ELEMENT_NOT_DISPLAYED;
			result = false;
		}

		return result;

	}
	
	/**
	 * <h1>funcClickElement</h1>
	 * <ul>
	 * This method clicks an element
	 * </ul>
	 * @param strElementName (element name)
	 * @param strXpath (xpath value)
	 * @return none
	 **/
	public static void funcClickElement(String strElementName, String strXpath) {
		WebElement element = Browser.getDriver().findElement(By.xpath(strXpath));
		element.click();
	}
	
	/**
	 * <h1>funcSetTextElement</h1>
	 * <ul>
	 * This method sets a text in element
	 * </ul>
	 * @param strElementName (element name)
	 * @param strXpath (xpath value)
	 * @param strKeyToSend (text to set)
	 * @return none
	 **/
	public static void funcSetTextElement(String strElementName, String strXpath, String strKeyToSend) {
		WebElement element = Browser.getDriver().findElement(By.xpath(strXpath));
		element.sendKeys(strKeyToSend);
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

}
