package com.TDDPOMSeleniumFramework.datautil;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TDDPOMSeleniumFramework.reporter.Log;
import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class ActionsUtil {
	
	private static Actions builder = Browser.getAction();
	//private static List<WebElement> listElements;
	
	public static void mouseOver(WebElement element){
		
		if(element == null){
			Log.testStep("FAILED", "Element NOT found", "Element NOT found");
		} else {
			builder.moveToElement(element).build().perform();
			Log.testStep("PASSED", "Element mouse hovered", "Element should be present");
		}
		
	}

}
