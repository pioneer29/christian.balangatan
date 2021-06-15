package com.TDDPOMSeleniumFramework.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TDDPOMSeleniumFramework.reporter.Log;
import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class ListBox {// implements ElementBase{

	private By by;
	private WebElement element;
	private Select select;
	private String name;
	private WebDriverWait wait;

	public ListBox(String name, By by) {
		this.by = by;
		this.name = name;
	}

	public void verifyDisplayed() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " ListBox is displayed");
		} else {
			Log.testStep("PASSED", name + " ListBox is displayed", name + " ListBox is displayed");
		}

	}

	public void verifyNotDisplayed() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("PASSED", name + " ListBox is NOT displayed", name + " ListBox is NOT displayed");
		} else {
			Log.testStep("FAILED", name + " ListBox is displayed", name + " ListBox is NOT displayed");
		}

	}

	public void selectByVisibleText(String value) {

		element = Browser.findElement(by);
		select = new Select(element);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
		} else {
			select.selectByVisibleText(value);
			Log.testStep("PASSED", "Selected " + value + " from " + name + " ListBox",
					"Selected " + value + " from " + name + "ListBox");
		}
	}
	
	public void selectByValue(String value) {

		element = Browser.findElement(by);
		select = new Select(element);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
		} else {
			select.selectByValue(value);
			Log.testStep("PASSED", "Selected " + value + " from " + name + " ListBox",
					"Selected " + value + " from " + name + "ListBox");
		}
	}

	public void click() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " ListBox is displayed");
		} else {
			try {
				element.click();
			} catch (Exception e) {
				element.click();
			}
			Log.testStep("PASSED", name + " ListBox is clicked", name + " ListBox is clicked");
		}
	}

	public String getValue() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
			return "";
		} else {
			return element.getAttribute("value");
		}

	}

	public void submit() {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
		} else {
			Log.testStep("PASSED", name + " ListBox is submitted", name + " Element is submitted");
			element.submit();
		}

	}

	public void sendKeys(CharSequence... keysToSend) {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
		} else {
			Log.testStep("PASSED", name + " ListBox is populated with " + keysToSend,
					name + " Element is populated with " + keysToSend);
			element.sendKeys(keysToSend);
		}

	}

	public void clear() {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
		} else {
			Log.testStep("PASSED", name + " ListBox is cleared ", name + " Element is cleared");
			element.clear();
		}
	}

	public String getTagName() {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
			return null;
		} else {
			Log.testStep("PASSED", name + " ListBox TagName  is " + element.getTagName(),
					name + " Element TagName  is " + element.getTagName());
			return element.getTagName();
		}
	}

	public String getAttribute(String aname) {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
			return null;
		} else {
			Log.testStep("PASSED", name + " ListBox '" + name + "' Attribute  is " + element.getAttribute(aname),
					name + " Element '" + name + "' Attribute  is " + element.getAttribute(aname));
			return element.getAttribute(aname);
		}
	}

	public boolean isSelected() {
		element = Browser.findElement(by);

		if (element == null) {
			return false;
		} else {
			return element.isSelected();
		}
	}

	public boolean isEnabled() {
		element = Browser.findElement(by);

		if (element == null) {
			return false;
		} else {
			return element.isEnabled();
		}
	}

	public String getText() {
		element = Browser.findElement(by);

		if (element == null) {
			// Log.testStep("FAILED", name+" ListBox is NOT displayed", name+"
			// Element is displayed");
			return null;
		} else {
			// Log.testStep("PASSED", name+" ListBox text is
			// "+element.getText(), name+" Element text is "+element.getText());
			return element.getText();
		}
	}

	public String getCssValue(String propertyName) {
		element = Browser.findElement(by);

		if (element == null) {
			return null;
		} else {
			return element.getCssValue(propertyName);
		}
	}

	public boolean isDisplayed() {
		element = Browser.findElement(by);

		if (element == null) {
			return false;
		} else {
			return element.isDisplayed();
		}
	}

	public Integer getYCoordinate() {
		element = Browser.findElement(by);

		Point coordinates = element.getLocation();

		if (element == null) {
			return 0;
		} else {
			return coordinates.getY();
		}
	}

	public Integer getXCoordinate() {
		element = Browser.findElement(by);

		Point coordinates = element.getLocation();

		if (element == null) {
			return 0;
		} else {
			return coordinates.getX();
		}
	}

	public Integer getHeight() {
		element = Browser.findElement(by);

		if (element == null) {
			return 0;
		} else {
			return element.getSize().height;
		}
	}

	public Integer getWidth() {
		element = Browser.findElement(by);

		if (element == null) {
			return 0;
		} else {
			return element.getSize().width;
		}
	}

	public void verifyDisplayedBySize() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " ListBox is displayed");
		} else if (element.getSize().height == 0 | element.getSize().width == 0) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " ListBox is displayed");
		} else {
			Log.testStep("PASSED", name + " ListBox is displayed", name + " ListBox is displayed");
		}

	}

	public void verifyNOTDisplayedBySize() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("PASSED", name + " ListBox is NOT displayed", name + " ListBox is NOT displayed");
		} else if (element.getSize().height == 0 | element.getSize().width == 0) {
			Log.testStep("PASSED", name + " ListBox is NOT displayed", name + " ListBox is NOT displayed");
		} else {
			Log.testStep("FAILED", name + " ListBox is displayed", name + " ListBox is NOT displayed");
		}

	}

	// Mark
	public void verifySelectedValue() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("PASSED", name + " no value is selected", name + " no value is selected");
		} else if (element.isSelected()) {
			Log.testStep("PASSED", name + " value is selected", name + " value is selected");
		} else {
			Log.testStep("FAILED", name + " value is NOT selected", name + " value is NOT selected");
		}

	}
	
	// Rose
	public void selectByOption(String value)
	 {
	  element = Browser.findElement(by);
	  WebElement select = element;
	  List<WebElement> options = select.findElements(By.tagName("option"));
	  
	   for(WebElement option : options){
	          if(option.getText().equals(value)) {
	              option.click();
	              Log.testStep("PASSED", name + " value is selected", name + " value is selected");
	              break;
	   }
	 }
	 }
	
	// Mark
	public void selectByIndex(int index){
		
		element = Browser.findElement(by);
		select = new Select(element);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
		} else {
			select.selectByIndex(index);
			Log.testStep("PASSED", "Selected " + select.getAllSelectedOptions().toString() + " from " + name + " ListBox",
					"Selected " + select.getAllSelectedOptions().toString() + " from " + name + "ListBox");
		}
	}
	
	public void deselectByVisibleText(String paramStrVisibleText){
		
		element = Browser.findElement(by);
		select = new Select(element);

		if (element == null) {
			Log.testStep("FAILED", name + " ListBox is NOT displayed", name + " Element is displayed");
		} else {
			select.deselectByVisibleText(paramStrVisibleText);
			Log.testStep("PASSED", "Selected " + paramStrVisibleText + " from " + name + " ListBox",
					"Selected " + paramStrVisibleText + " from " + name + "ListBox");
		}
	}
	
	public void waitForElementToBeEnabled() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " is NOT displayed", name + " is NOT displayed");
		} else {
			while (element.isEnabled() != true) {
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
			}
		}
	}
	
	public String getSelectedOption(){
		
		element = Browser.findElement(by);
		select = new Select(element);
		
		if(element == null){
			return null;
		} else {
			return select.getFirstSelectedOption().getText();
		}
		
	}
}
