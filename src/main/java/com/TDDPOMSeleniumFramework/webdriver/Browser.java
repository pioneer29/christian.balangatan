package com.TDDPOMSeleniumFramework.webdriver;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

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

import com.TDDPOMSeleniumFramework.datautil.Common;
import com.TDDPOMSeleniumFramework.datautil.Configuration;
import com.TDDPOMSeleniumFramework.pages.BasePage;
import com.TDDPOMSeleniumFramework.reporter.Log;

public class Browser extends BasePage{
	
	
	public static Integer searchLoop = 30;
	public static Actions action;
	public static Properties prop = new Properties();
	
	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		Browser.prop = prop;
	}

	public static Actions getAction() {
		return action = new Actions(driver);
	}

	public static void setAction(Actions action) {
		Browser.action = action;
	}

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
			
		} else if(strBrowserName.contentEquals("FIREFOX")){
			FirefoxProfile profile = new FirefoxProfile(); 
			profile.setPreference("browser.download.dir", Common.PATH_DOWNLOADS); 
			profile.setPreference("browser.download.folderList", 2);
			driver = new FirefoxDriver(profile);
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
		}

	}
	
	public static void open(String url, String browser) {
		driver.get(url);		
		//funcLogTestStep(TEST_PASSED, "Open "+url+" with "+ browser +" browser");
	}
	
	public static String getPageTitle() {
		String strPgeTitle = driver.getTitle();	
		//funcLogTestStep(TEST_PASSED, "Page Title is" + strPgeTitle);
		return strPgeTitle;
	}
	
	public static void close(){
		try {
			waitForLoadingScreen();
			waitforAngularJS();
			driver.close();
			driver.quit();
		} catch (Exception e) {
		}
		
	}
		
	public static Boolean waitIsElementDisplayed(int waitingtime,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, waitingtime);
		WebElement obj = wait.until(ExpectedConditions.elementToBeClickable(element));
		return obj.isDisplayed();
	}
	
	
	public static void waitforAngularJS() {
		Boolean i = true;
		 while (i) {
			 	waitloading(1);
			 	try {
			 		i = driver.findElement(By.id("loading-bar")).isDisplayed();			 		
				} catch (Exception e) {
					i = false;
				}
			 	
	        }
    }
	
	public static void waitForLoadingScreen() {
		try {
			while (driver.findElement(By.xpath("//div[@id='LoadingScreen']/../div/parent::div")).getCssValue("display")
					.equalsIgnoreCase("block")) {
				Browser.waitloading(3);
			}
		} catch (Exception e) {
		}
	}
	
	public static void waitloading(Integer seconds){
		Integer time = seconds * 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	
	public static WebElement findElement(By by) throws StaleElementReferenceException, WebDriverException {
		WebElement element = null;
		int i = 0;
		
		while (i!=searchLoop && element == null) {
			i+=1;
			try {
				Browser.waitforAngularJS();	
				Browser.waitForLoadingScreen();
				element =  new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(by));
				element.isEnabled();
			} catch (Exception e) {
				element =  null;
			} 
		}
		
		
		
		if(element != null){
				try {
					Actions actions = new Actions(driver);
					actions.moveToElement(element);
					actions.perform();
				} catch (Exception e) {
				}
		}
	
		return element;
	}	
	
	public static void opennewtab(){
		Browser.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	}
	// handle alerts
	public static String getAlertText() throws Exception{
		String result = null;
		boolean i = true;
		Integer ii = 1;
		
		while(i & ii<30){
			waitForLoadingScreen();
			Browser.waitloading(1);
			try {
				result = Browser.getDriver().switchTo().alert().getText();
				i = false;
			} catch (Exception e) {
				i = true;
			}
			ii+=1;
		}
		
		return result;
	}
	
	public static void acceptAlert(){
		driver.switchTo().alert().accept();
	}
	
	public static void switchFrame(){
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("body")));
	}
	
	//
	public static void clickalert() {
		boolean i = true;
		Integer ii = 1;
		while(i & ii<30){
			waitForLoadingScreen();
			Browser.waitloading(1);
			try {
				Browser.getDriver().switchTo().alert().accept();
				i = false;
				Log.testStep("PASSED", "Alert Accepted", "Alert Accepted");
			} catch (Exception e) {
				i = true;
			}
			ii+=1;
		}
		
		if(i){
			Log.testStep("FAILED", "Alert is not displayed", "Alert Accepted");
		}
	}  
	
	public static void cancelAlert() {
		boolean i = true;
		Integer ii = 1;
		while(i & ii<30){
			waitForLoadingScreen();
			Browser.waitloading(1);
			try {
				Browser.getDriver().switchTo().alert().dismiss();
				i = false;
				Log.testStep("PASSED", "Alert dismissed", "Alert dismissed");
			} catch (Exception e) {
				i = true;
			}
			ii+=1;
		}
		
		if(i){
			Log.testStep("FAILED", "Alert is not displayed", "Alert dismissed");
		}
	} 
	
	public static Boolean isAlertDisplayed(){
		Boolean result;
		boolean i = true;
		Integer ii = 1;
		while(i & ii<30){
			waitForLoadingScreen();
			Browser.waitloading(1);
			try {
				Browser.getDriver().switchTo().alert();
				i = false;
			} catch (Exception e) {
				i = true;
			}
			ii+=1;
		}
		
		if(i){
		}
		
		if(i){
			result = false;
		}else{
			result =true;
		}
		
		return result;
	}
	
	public static void authenticateCredentials(String paramStrUsername, String paramStrPassword) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.authenticateUsing(new UserAndPassword(paramStrUsername, paramStrPassword));

	}
	
	public static void dismissAuthenticationAlert() {

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //Press ESC key
	    robot.keyPress(KeyEvent.VK_ESCAPE);
	    robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	/**
	  * <b>FUNCTION NAME:</b> browserAuthentication<br>
	  * <b>DESCRIPTION:</b> This function perform a username and password input from an authentication pop up <br>
	  * <b>DATE CREATED:</b> 02/21/2017<br>
	  * @param paramStrUserName string input data on Username text field.<br>
	  * @param paramStrPassword string input data on Password text field.<br>
	  * @author Mark Salas<br>
	  */
	
	public static void browserAuthentication(String paramStrUsername, String paramStrPassword)
			throws AWTException {

		Robot rb = new Robot();

		// Enter user name by ctrl-v
		StringSelection user = new StringSelection(paramStrUsername);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(user, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		// tab to password entry field
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);

		waitloading(2);

		// Enter password by ctrl-v
		StringSelection pwd = new StringSelection(paramStrPassword);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		// press enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		waitloading(5);
	}
	
	
	// Mark
	public static void verifyCurrentUrl(String paramStrCurrentUrl) {

		boolean isCurrentUrlCorrect = getDriver().getCurrentUrl().contains(paramStrCurrentUrl);
		if (isCurrentUrlCorrect) {
			Log.testStep("PASSED", "Verify user successfully logged in", "Verify user successfully logged in");
		} else {
			Log.testStep("FAILED", "Current URL is "+ getDriver().getCurrentUrl(), "Current URL is "+ getDriver().getCurrentUrl());
			//Assert.assertTrue(isCurrentUrlCorrect, "Current URL is different "+ getDriver().getCurrentUrl());
		}
	}
	
	// Mark
	public static List<WebElement> findDisplayedElements(By locator) {
	    List <WebElement> elementOptions = Browser.getDriver().findElements(locator);
	    List <WebElement> displayedOptions = new ArrayList<WebElement>();
	    for (WebElement option : elementOptions) {
	    	option = new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(locator));
	        if (option.isDisplayed()) {
	            displayedOptions.add(option);
	        }
	    }
	    return displayedOptions;
	}
	
	// Mark
	public static void switchToAnotherFrame(By byTargetLocator) {
		driver.switchTo().frame(driver.findElement(byTargetLocator));
		Browser.waitloading(5);
	}
	
	// Mark
	public static void switchToAnotherFrameByTag() {
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Browser.waitloading(5);
	}
	
	// Mark
	public static void switchToDefaultFrame(){
		driver.switchTo().defaultContent();
		Browser.waitloading(5);
	}
	
	public static void waitForPageToLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	/**
	  * <b>FUNCTION NAME:</b> waitForProcessingToCompleteOP<br>
	  * <b>DESCRIPTION:</b> This function waits for the processing to be completed in My Homepage <br>
	  * <b>DATE CREATED:</b> 03/29/2017<br>
	  * @param paramStrHeaderExpandName string label of the header expander in My Homepage<br>
	  * @author Mark Salas<br>
	  */
	
	public static void waitForProcessingToCompleteOP(String paramStrHeaderExpandName) {
		try {
			while (driver
					.findElement(By.xpath(".//div[@data-expander-header='" + paramStrHeaderExpandName
							+ "']//descendant::div[@class='dataTables_processing']"))
					.getCssValue("visibility").equalsIgnoreCase("visible")) {
				Browser.waitloading(3);
			}
		} catch (Exception e) {
		}
	}
	
	/**
	  * <b>FUNCTION NAME:</b> waitForProcessingToCompleteOP<br>
	  * <b>DESCRIPTION:</b> This function waits for the processing to be completed on Search Result <br>
	  * <b>DATE CREATED:</b> 03/29/2017<br>
	  * @author Mark Salas<br>
	  */
	
	public static void waitForProcessingToCompleteOP() {
		try {
			while (driver
					.findElement(By.xpath("//div[@id='main']//descendant::div[@class='dataTables_processing']"))
					.getCssValue("visibility").equalsIgnoreCase("visible")) {
				Browser.waitloading(3);
			}
		} catch (Exception e) {
		}
	}
			
}
