package com.JupiterToys_POMSeleniumFramework.webdriver;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.JupiterToys_POMSeleniumFramework.datautil.Common;
import com.JupiterToys_POMSeleniumFramework.pages.BasePage;

public class Browser extends BasePage{
	
	public static WebDriver getDriver(){
		return driver;
	}
	
	public static void funcInitializeBrowser(String strBrowserName){
		
		if(strBrowserName.contentEquals("IE")){
			System.setProperty("webdriver.ie.driver", Common.PATH_WEBDRIVERS + "IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);  
            ieCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
            ieCapabilities.setCapability("requireWindowFocus", true);
            ieCapabilities.setCapability("enablePersistentHover", false);
            ieCapabilities.setCapability("javascriptEnabled", true);
            ieCapabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			
		} else if(strBrowserName.contentEquals("FIREFOX")){
			FirefoxProfile profile = new FirefoxProfile(); 
			profile.setPreference("browser.download.dir", Common.PATH_DOWNLOADS); 
			profile.setPreference("browser.download.folderList", 2);
			driver = new FirefoxDriver(profile);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		}else{
			System.setProperty("webdriver.chrome.driver", Common.PATH_WEBDRIVERS + "chromedriver.exe");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", Common.PATH_DOWNLOADS);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("disable-extensions");
			options.addArguments("--start-maximized");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			
		}

	}
	
	public static void open(String url, String browser) {
		driver.get(url);		
		logger.info("Successfully opened "+url+" with "+ browser +" browser.");
	}
	
	public static String getPageTitle() {
		String strPgeTitle = driver.getTitle();	
		funcLogTest(TEST_PASSED, "Page Title is" + strPgeTitle);
		return strPgeTitle;
	}
	
	public static void close(){
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
		}
		
	}
	
	
}
