package com.TDDPOMSeleniumFramework.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.TDDPOMSeleniumFramework.reporter.Log;
import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class Link {// implements ElementBase{

	private By by;
	private String name;
	private WebElement element;
	private List<WebElement> listElement;

	public Link(String name, By by) {
		this.by = by;
		this.name = name;
	}

	public void verifyDisplayed() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Link is displayed");
		} else {
			Log.testStep("PASSED", name + " Link is displayed", name + " Link is displayed");
		}

	}

	public void verifyNotDisplayed() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("PASSED", name + " Link is NOT displayed", name + " Link is NOT displayed");
		} else {
			Log.testStep("FAILED", name + " Link is displayed", name + " Link is NOT displayed");
		}

	}

	public void setText(String text) {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Link is displayed");
		} else {
			element.clear();
			element.sendKeys(text);
			Log.testStep("PASSED", name + " Link is populated with '" + text + "'",
					name + " Link is populated with '" + text + "'");
		}
	}

	public void click() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Link is displayed");
		} else {
			try {
				element.click();
			} catch (Exception e) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
				}
				JavascriptExecutor executor = (JavascriptExecutor) Browser.getDriver();
				executor.executeScript("arguments[0].click();", element);
			}
			Log.testStep("PASSED", name + " Link is clicked", name + " Link is clicked");
		}
	}

	public String getValue() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Element is displayed");
			return "";
		} else {
			return element.getAttribute("value");
		}

	}

	public void submit() {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Element is displayed");
		} else {
			Log.testStep("PASSED", name + " Link is submitted", name + " Element is submitted");
			element.submit();
		}

	}

	public void sendKeys(CharSequence... keysToSend) {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Element is displayed");
		} else {
			Log.testStep("PASSED", name + " Link is populated with " + keysToSend,
					name + " Element is populated with " + keysToSend);
			element.sendKeys(keysToSend);
		}

	}

	public void clear() {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Element is displayed");
		} else {
			Log.testStep("PASSED", name + " Link is cleared ", name + " Element is cleared");
			element.clear();
		}
	}

	public String getTagName() {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Element is displayed");
			return null;
		} else {
			Log.testStep("PASSED", name + " Link TagName  is " + element.getTagName(),
					name + " Element TagName  is " + element.getTagName());
			return element.getTagName();
		}
	}

	public String getAttribute(String aname) {
		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Element is displayed");
			return null;
		} else {
			Log.testStep("PASSED", name + " Link '" + name + "' Attribute  is " + element.getAttribute(aname),
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
			// Log.testStep("FAILED", name+" Link is NOT displayed", name+"
			// Element is displayed");
			return null;
		} else {
			// Log.testStep("PASSED", name+" Link text is "+element.getText(),
			// name+" Element text is "+element.getText());
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
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Link is displayed");
		} else if (element.getSize().height == 0 | element.getSize().width == 0) {
			Log.testStep("FAILED", name + " Link is NOT displayed", name + " Link is displayed");
		} else {
			Log.testStep("PASSED", name + " Link is displayed", name + " Link is displayed");
		}

	}

	public void verifyNOTDisplayedBySize() {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("PASSED", name + " Link is NOT displayed", name + " Link is NOT displayed");
		} else if (element.getSize().height == 0 | element.getSize().width == 0) {
			Log.testStep("PASSED", name + " Link is NOT displayed", name + " Link is NOT displayed");
		} else {
			Log.testStep("FAILED", name + " Link is displayed", name + " Link is NOT displayed");
		}

	}

	public boolean isElementPresent() {

		listElement = Browser.findDisplayedElements(by);

		if (listElement == null) {
			return false;
		} else if (listElement.size() > 0) {
			System.out.println("Element found!");
			return true;
		}
		return false;

	}

	public void verifyCorrectText(String paramStrTextToVerify) {

		element = Browser.findElement(by);

		if (element == null) {
			Log.testStep("FAILED", paramStrTextToVerify + " Text NOT displayed",
					paramStrTextToVerify + " Text NOT displayed");
		} else if (element.getText().contains(paramStrTextToVerify)) {
			Log.testStep("PASSED", paramStrTextToVerify + " Text displayed is correct",
					paramStrTextToVerify + " Text displayed is correct");
		} else {
			Log.testStep("FAILED", paramStrTextToVerify + " Text NOT displayed",
					paramStrTextToVerify + " Text NOT displayed");
		}
	}
}
