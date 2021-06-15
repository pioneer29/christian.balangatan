package com.TDDPOMSeleniumFramework.object;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.TDDPOMSeleniumFramework.reporter.Log;
import com.TDDPOMSeleniumFramework.webdriver.Browser;



public class CheckBox {//implements ElementBase{

	private By by;
	private String name;
	private WebElement element;
	
	public CheckBox(String name, By by){
		this.by = by;
		this.name = name;
	}

	public void verifyDisplayed(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" CheckBox is displayed");
		}else{
			Log.testStep("PASSED", name+" CheckBox is displayed", name+" CheckBox is displayed");
		}
		
	}

	public void verifyNotDisplayed(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("PASSED", name+" CheckBox is NOT displayed", name+" CheckBox is NOT displayed");
		}else{
			Log.testStep("FAILED", name+" CheckBox is displayed", name+" CheckBox is NOT displayed");
		}
		
	}

	public void tick(Boolean value){
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" CheckBox is displayed");
		}else{
			if(value){
				if(element.isSelected()==false){
					try {
						element.click();
					} catch (Exception e) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
						}
						JavascriptExecutor executor = (JavascriptExecutor)Browser.getDriver();
						executor.executeScript("arguments[0].click();", element);
					}
				}
			}else if(!value){
				if(element.isSelected()==true){
					try {
						element.click();
					} catch (Exception e) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
						}
						JavascriptExecutor executor = (JavascriptExecutor)Browser.getDriver();
						executor.executeScript("arguments[0].click();", element);
					}
				}
			}
			Log.testStep("PASSED", name+" CheckBox value is set to "+ value, name+" CheckBox value is set to "+ value);
		}
	}
	
	public void click() {
		
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" CheckBox is displayed");
		}else{
			try {
				element.click();
			} catch (Exception e) {
				element.click();
			}
			Log.testStep("PASSED", name+" CheckBox is clicked", name+" CheckBox is clicked");
		}
	}
	
	
	public String getValue(){

		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
			return "";
		}else{
			return element.getAttribute("value");
		}
		
	}
	

	public void submit() {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
		}else{
			Log.testStep("PASSED", name+" CheckBox is submitted", name+" Element is submitted");
			element.submit();
		}
		
	}

	public void sendKeys(CharSequence... keysToSend) {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
		}else{
			Log.testStep("PASSED", name+" CheckBox is populated with " + keysToSend, name+" Element is populated with " + keysToSend);
			element.sendKeys(keysToSend);
		}
		
	}

	public void clear() {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
		}else{
			Log.testStep("PASSED", name+" CheckBox is cleared ", name+" Element is cleared");
			element.clear();
		}
	}

	public String getTagName() {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
			return null;
		}else{
			Log.testStep("PASSED", name+" CheckBox TagName  is " +element.getTagName(),  name+" Element TagName  is " +element.getTagName());
			return element.getTagName();
		}
	}

	public String getAttribute(String aname) {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
			return null;
		}else{
			Log.testStep("PASSED", name+" CheckBox '"+name+"' Attribute  is " +element.getAttribute(aname),  name+" Element '"+name+"' Attribute  is " +element.getAttribute(aname));
			return element.getAttribute(aname);
		}
	}

	public boolean isSelected() {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
			return false;
		}else{
			Log.testStep("PASSED", name+" CheckBox selection is "+element.isSelected(),   name+" Element selection is "+element.isSelected());
			return element.isSelected();
		}
	}

	public boolean isEnabled() {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
			return false;
		}else{
			Log.testStep("PASSED", name+" CheckBox enable property is "+element.isEnabled(),   name+" Element enable property is "+element.isEnabled());
			return element.isEnabled();
		}
	}

	public String getText() {
		element = Browser.findElement(by);
		
		if(element == null){
//			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" Element is displayed");
			return null;
		}else{
//			Log.testStep("PASSED", name+" CheckBox text is "+element.getText(),   name+" Element text is "+element.getText());
			return element.getText();
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

	public boolean isDisplayed() {
		element = Browser.findElement(by);
		
		if(element == null){
			return false;
		}else{
			return element.isDisplayed();
		}
	}

	public Integer getYCoordinate() {
		element = Browser.findElement(by);
		
		Point coordinates = element.getLocation();
		
		if(element == null){
			return 0;
		}else{
			return coordinates.getY();
		}
	}
	
	public Integer getXCoordinate() {
		element = Browser.findElement(by);
		
		Point coordinates = element.getLocation();
		
		if(element == null){
			return 0;
		}else{
			return coordinates.getX();
		}
	}
	
	public Integer getHeight() {
		element = Browser.findElement(by);
		
		
		if(element == null){
			return 0;
		}else{
			return element.getSize().height;
		}
	}
	
	public Integer getWidth() {
		element = Browser.findElement(by);
		
		
		if(element == null){
			return 0;
		}else{
			return element.getSize().width;
		}
	}
	
	public void verifyDisplayedBySize(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" CheckBox is displayed");
		}else if(element.getSize().height==0 | element.getSize().width==0){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" CheckBox is displayed");
		}else{
			Log.testStep("PASSED", name+" CheckBox is displayed", name+" CheckBox is displayed");
		}
		
	}

	public void verifyNOTDisplayedBySize(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("PASSED", name+" CheckBox is NOT displayed", name+" CheckBox is NOT displayed");
		}else if(element.getSize().height==0 | element.getSize().width==0){
			Log.testStep("PASSED", name+" CheckBox is NOT displayed", name+" CheckBox is NOT displayed");
		}else{
			Log.testStep("FAILED", name+" CheckBox is displayed", name+" CheckBox is NOT displayed");
		}
		
	}
	
	public void verifyIsSelectedByValue(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("FAILED", name+" CheckBox is NOT displayed", name+" CheckBox is NOT displayed");
		}else if(element.isSelected()){
			Log.testStep("PASSED", name+" CheckBox is selected", name+" CheckBox should be selected");
		}else{
			Log.testStep("FAILED", name+" CheckBox is not selected", name+" ChecBox should NOT be selected");
		}
	}
}
