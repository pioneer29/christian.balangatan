package com.TDDPOMSeleniumFramework.object;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TDDPOMSeleniumFramework.reporter.Log;
import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class TextBox {//implements ElementBase{
	private By by;
	private String name;
	private WebElement element;
	
	public TextBox(String name, By by){
		this.by = by;
		this.name = name;
	}
	
	public void verifyDisplayed(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" TextBox is displayed");
		}else{
			Log.testStep("PASSED", name+" TextBox is displayed", name+" TextBox is displayed");
		}
		
	}

	public void verifyNotDisplayed(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("PASSED", name+" TextBox is NOT displayed", name+" TextBox is NOT displayed");
		}else{
			Log.testStep("FAILED", name+" TextBox is displayed", name+" TextBox is NOT displayed");
		}
		
	}

	public void doubleClick(){
		
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" TextBox is displayed");
		}else{
			Actions action = new Actions(Browser.getDriver());
			action.moveToElement(element);
			action.doubleClick();
			action.perform();
			Log.testStep("PASSED", name+" TextBox is double clicked", name+" TextBox is double clicked");
		}
	}
	
	public void setText(String text){
		
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" TextBox is displayed");
		}else{
			element.clear();
			element.sendKeys(text);
			Log.testStep("PASSED", name+" TextBox is populated with '"+text+"'", name+" TextBox is populated with '"+text+"'");
		}
	}
	
public void click() {
		
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" TextBox is displayed");
		}else{
			try {
				element.click();
			} catch (Exception e) {
				element.click();
			}
			Log.testStep("PASSED", name+" TextBox is clicked", name+" TextBox is clicked");
		}
	}
	
	
	public String getValue(){

		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" Element is displayed");
			return "";
		}else{
			return element.getAttribute("value");
		}
		
	}
	

	public void submit() {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" Element is displayed");
		}else{
			Log.testStep("PASSED", name+" TextBox is submitted", name+" Element is submitted");
			element.submit();
		}
		
	}

	public void sendKeys(CharSequence... keysToSend) {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " TextBox is NOT displayed", name + " Element is displayed");
		} else {
			Log.testStep("PASSED", name + " TextBox is populated with " + keysToSend.toString(),
					name + " Element is populated with " + keysToSend.toString());
			element.sendKeys(keysToSend);
		}

	}

	public void clear() {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" Element is displayed");
		}else{
			Log.testStep("PASSED", name+" TextBox is cleared ", name+" Element is cleared");
			element.clear();
		}
	}

	public String getTagName() {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" Element is displayed");
			return null;
		}else{
			Log.testStep("PASSED", name+" TextBox TagName  is " +element.getTagName(),  name+" Element TagName  is " +element.getTagName());
			return element.getTagName();
		}
	}

	public String getAttribute(String aname) {
		element = Browser.findElement(by);
		
		if(element == null){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" Element is displayed");
			return null;
		}else{
			Log.testStep("PASSED", name+" TextBox '"+name+"' Attribute  is " +element.getAttribute(aname),  name+" Element '"+name+"' Attribute  is " +element.getAttribute(aname));
			return element.getAttribute(aname);
		}
	}

	public boolean isSelected() {
		element = Browser.findElement(by);
		
		if(element == null){
			return false;
		}else{
			return element.isSelected();
		}
	}

	public boolean isEnabled() {
		element = Browser.findElement(by);
		
		if(element == null){
			return false;
		}else{
			return element.isEnabled();
		}
	}

	public String getText() {
		element = Browser.findElement(by);
		
		if(element == null){
//			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" Element is displayed");
			return null;
		}else{
//			Log.testStep("PASSED", name+" TextBox text is "+element.getText(),   name+" Element text is "+element.getText());
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
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" TextBox is displayed");
		}else if(element.getSize().height==0 | element.getSize().width==0){
			Log.testStep("FAILED", name+" TextBox is NOT displayed", name+" TextBox is displayed");
		}else{
			Log.testStep("PASSED", name+" TextBox is displayed", name+" TextBox is displayed");
		}
		
	}

	public void verifyNOTDisplayedBySize(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("PASSED", name+" TextBox is NOT displayed", name+" TextBox is NOT displayed");
		}else if(element.getSize().height==0 | element.getSize().width==0){
			Log.testStep("PASSED", name+" TextBox is NOT displayed", name+" TextBox is NOT displayed");
		}else{
			Log.testStep("FAILED", name+" TextBox is displayed", name+" TextBox is NOT displayed");
		}
		
	}
	
	public void verifyFieldIsNotEmpty(){
		
		element = Browser.findElement(by);
		
		if(element==null){
			Log.testStep("FAILED", name+" TextBox is not displayed", name+" TextBox is not displayed");
		}else if(element.getAttribute("value").length() > 0){
			Log.testStep("PASSED", name+" TextBox value is "+ element.getAttribute("value"), name+" TextBox is not empty");
		}else{
			Log.testStep("FAILED", name+" TextBox is empty", name+" TextBox is empty");
		}
		
	}
	
	/*Press sequence of keyboard stroke*/
	public void pressKey(Keys...key){
		
		element = Browser.findElement(by);
		String keyStroke = Keys.chord(key);
		
		if(element==null){
			Log.testStep("FAILED", name+" TextBox is not displayed", name+" TextBox is not displayed");
		}else {
			Log.testStep("PASSED", name+" is pressed", name+" is pressed");
			element.sendKeys(keyStroke);
		}
	}
	
}
