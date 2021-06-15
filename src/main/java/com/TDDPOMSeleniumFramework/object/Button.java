package com.TDDPOMSeleniumFramework.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TDDPOMSeleniumFramework.reporter.Log;
import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class Button {

	private By by;
	private String name;
	private WebElement element;
	private List<WebElement> listElement;

	public Button(String name, By by) {
		this.by = by;
		this.name = name;
	}

	public void click() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Button is NOT displayed", name + " Button is displayed");
		} else {
			try {
				element.click();
			} catch (Exception e) {
				element.click();
			}
			Log.testStep("PASSED", name + " Button is clicked", name + " Button is clicked");
		}
	}

	public void doubleClick() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Button is NOT displayed", name + " Button is displayed");
		} else {
			Actions action = new Actions(Browser.getDriver());
			action.moveToElement(element);
			action.doubleClick();
			action.perform();
			Log.testStep("PASSED", name + " Button is double clicked", name + " Button is double clicked");
		}
	}
	
	public boolean isDisplayed() {
		element = Browser.findElement(by);
		
		if(element == null){
			return false;
		}else{
			return element.isDisplayed();
		}
	}
	
	public boolean isPresent() {
		listElement = Browser.findDisplayedElements(by);
		
		if(listElement == null){
			return false;
		}else if(listElement.size() == 0){
			return false;
		}else if(listElement.size() > 0){
			return true;
		}
		return false;
	}
	
	public String getAttribute(String aname) {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" Element is NOT displayed", name+" Element is displayed");
			return null;
		}else{
			Log.testStep("PASSED", name+" Element '"+name+"' Attribute  is " +element.getAttribute(aname),  name+" Element '"+name+"' Attribute  is " +element.getAttribute(aname));
			return element.getAttribute(aname);
		}
	}
	
	public String getCssValue(String propertyName) {
		element = Browser.findElement(by);
		
		if(element == null){
			return null;
		}else{
			return element.getCssValue(propertyName);
		}
	}
	
	public void verifyElementPresent() {

		listElement = Browser.findDisplayedElements(by);

		if (listElement == null) {
			Log.testStep("FAILED", name + " Element is NOT present", name + " Element is NOT present");
		} else if (listElement.size() > 0) {
			Log.testStep("PASSED", name + " Element is present", name + " Element is present");
		} else {
			Log.testStep("FAILED", name + " Element is NOT present", name + " Element is NOT present");
		}
	}
}
