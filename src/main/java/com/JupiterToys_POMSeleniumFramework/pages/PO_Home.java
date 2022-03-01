package com.JupiterToys_POMSeleniumFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.JupiterToys_POMSeleniumFramework.pages.BasePage;

public class PO_Home extends BasePage {
	
	public static final String TXT_USERNAME = "//input[@id='loginUserName']";
	@FindBy (xpath = TXT_USERNAME)
	public WebElement txtUserName;
	
	public static final String TXT_PASSWORD = "//input[@id='loginPassword']";
	@FindBy (xpath = TXT_PASSWORD)
	public WebElement txtPassword;

	public static final String BTN_LOGIN = "//button[@class='btn btn-primary']";
	@FindBy (xpath = BTN_LOGIN)
	public WebElement btnLogin;
	
	public static final String LNK_HOME = "//li[@id='nav-home']//a";
	@FindBy (xpath = LNK_HOME)
	public WebElement lnkHome;
	
	public static final String LNK_SHOP = "//li[@id='nav-shop']//a";
	@FindBy (xpath = LNK_SHOP)
	public WebElement lnkShop;
	
	public static final String LNK_CONTACT = "//li[@id='nav-contact']//a";
	@FindBy (xpath = LNK_CONTACT)
	public WebElement lnkContact;
	
	public static final String LNK_CART = "//li[@id='nav-cart']//a";
	@FindBy (xpath = LNK_CART)
	public WebElement lnkCart;
	
	
	public static void funcLogin(String strUserName, String strPassword) {
		if (isElementDisplayed("[Username] textfield", TXT_USERNAME, XPATH)) {
			funcSetTextElement("[Username] textfield", TXT_USERNAME, strUserName, XPATH);
			funcSetTextElement("[Password] textfield", TXT_PASSWORD, strPassword, XPATH);
			funcClickElement("[Login] button", BTN_LOGIN, XPATH);
			funcWaitTime(5);
		} else {
			logger.info("[Username] textfield is NOT displayed");
		}
	}
		
	public boolean funcNavigate(String strPageName) {
		
		// Initialize result boolean value:
		result = true;
		
		switch(strPageName.toUpperCase()) {
		  case "HOME":
			if (isElementDisplayed("[Home] link", LNK_HOME, XPATH)) {
				funcClickElement("[Home] link", LNK_HOME, XPATH);
			} else {
				result = false;
			}
		    break;
		    
		  case "SHOP":
			if (isElementDisplayed("[Shop] link", LNK_SHOP, XPATH)) {
				funcClickElement("[Shop] link", LNK_SHOP, XPATH);
			} else {
				result = false;
			}
		    break;
		    
		  case "CONTACT":
			if (isElementDisplayed("[Contact] link", LNK_CONTACT, XPATH)) {
				funcClickElement("[Contact] link", LNK_CONTACT, XPATH);
			} else {
				result = false;
			}
			break;

		  case "CART":
			if (isElementDisplayed("[Cart] link", LNK_CART, XPATH)) {
				funcClickElement("[Cart] link", LNK_CART, XPATH);
			} else {
				result = false;
			}
			break;
			
		  default:
			 logger.info("["+strPageName+"] link is INVALID");
			 result = false;
		}
		
		return result;
			
	}
	
}
