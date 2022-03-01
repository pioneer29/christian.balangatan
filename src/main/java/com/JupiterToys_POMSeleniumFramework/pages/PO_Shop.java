package com.JupiterToys_POMSeleniumFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.JupiterToys_POMSeleniumFramework.pages.BasePage;

public class PO_Shop extends BasePage {

	public static final String BTN_BUY_FUNNYCOW = "//li[@id='product-6']//descendant::a[@class='btn btn-success']";
	@FindBy(xpath = BTN_BUY_FUNNYCOW)
	public WebElement btnBuyFunnyCow;

	public static final String BTN_BUY_FLUFFYBUNNY = "//li[@id='product-4']//descendant::a[@class='btn btn-success']";
	@FindBy(xpath = BTN_BUY_FLUFFYBUNNY)
	public WebElement btnBuyFluffyBunny;

	public static final String TBL_CART_TABLE = "//table[@class='table table-striped cart-items']";
	@FindBy(xpath = TBL_CART_TABLE)
	public WebElement tblCartTable;

	public boolean funcClickBuy(String strShopItem) {

		// Initialize result boolean value:
		result = true;

		switch (strShopItem.toUpperCase()) {
		case "FUNNY COW":
			if (isElementDisplayed("[Buy Funny Cow] button", BTN_BUY_FUNNYCOW, XPATH)) {
				funcClickElement("[Buy Funny Cow] button", BTN_BUY_FUNNYCOW, XPATH);
			} else {
				result = false;
			}
			break;

		case "FLUFFY BUNNY":
			if (isElementDisplayed("[Buy Fluffy Bunny] button", BTN_BUY_FLUFFYBUNNY, XPATH)) {
				funcClickElement("[Buy Fluffy Bunny] button", BTN_BUY_FLUFFYBUNNY, XPATH);
			} else {
				result = false;
			}
			break;

		default:
			logger.info("[" + strShopItem + "] item is INVALID");
			result = false;
		}

		return result;
	}

	public boolean funcValiateCartTable(String strColumnReference, String strRowValueReference, String strColumnoGetData,
			String strExpectedQuantity) {
		// Initialize result boolean value:
		result = true;

		List<WebElement> col = driver.findElements(By.xpath(TBL_CART_TABLE + "//tr//th"));
		System.out.println("No of cols are : " + col.size());
		// No.of rows
		List<WebElement> row = driver.findElements(By.xpath(TBL_CART_TABLE + "//tr[@class='cart-item ng-scope']"));
		System.out.println("No of rows are : " + row.size());
		
		// Get the Column Index of the Reference Column
		 int intRefColIndex = funcGetColumnIndexFromTable(strColumnReference, TBL_CART_TABLE);
		
		// Get the row number of the Reference Value
		 int intRefRowIndex = funcGetRowIndexFromTable(intRefColIndex, strRowValueReference, TBL_CART_TABLE);
		 
		// Get the Column Index of the Column to get the data
		 //int intColumnToGetDataIndex = funcGetColumnIndexFromTable(strColumnoGetData, TBL_CART_TABLE);
		 int intColumnToGetDataIndex = funcGetColumnIndexFromTable(strColumnoGetData, TBL_CART_TABLE);
			 
		 //String strRetValue =  driver.findElement(By.xpath("(" + TBL_CART_TABLE + "//tr[@class='cart-item ng-scope']//td["+intColumnToGetDataIndex+"])["+intRefRowIndex+"]//input")).getText();
		 String strRetValue =  driver.findElement(By.xpath("(" + TBL_CART_TABLE + "//tr[@class='cart-item ng-scope']//td["+intColumnToGetDataIndex+"])["+intRefRowIndex+"]//input")).getAttribute("value");
		 
		 if (strExpectedQuantity.equalsIgnoreCase(strRetValue)) {
			 result = true;
		 } else {
			 errorDesc = "Expected Quanity(" + strExpectedQuantity + ") for [" + strRowValueReference + "] is incorrect. Actual quantity: " + strRetValue;
			 result = false; 
		 }
		 
		return result;
	}

	private static int funcGetColumnIndexFromTable(String strColumnName, String strTableXpath) {
		List<WebElement> col = driver.findElements(By.xpath(strTableXpath + "//tr//th"));

		int intTableColumnSize = col.size();
		int indexOfColumn = 0;

		for (int i = 1; i <= intTableColumnSize; i++) {

			if (driver.findElement(By.xpath(strTableXpath + "//tr//th[" + i + "]")).getText().equalsIgnoreCase(strColumnName)) {
			//if (driver.findElement(By.xpath("(" + strTableXpath + "//tr[@class='cart-item ng-scope']//td["+strColumnName+"])["+ i +"]")).getText().equalsIgnoreCase(strColumnName)) {
				indexOfColumn = i;
				break;

			}

		}

		return indexOfColumn;

	}
	
	private static int funcGetRowIndexFromTable(int intRefColIndex, String strRefRowValue, String strTableXpath) {
		List<WebElement> col = driver.findElements(By.xpath(strTableXpath + "//tr//th"));

		int intTableColumnSize = col.size();
		int indexOfRow = 0;

		for (int i = 1; i <= intTableColumnSize; i++) {
			
			//(//table[@class='table table-striped cart-items']//tr[@class='cart-item ng-scope']//td[1])[2]

			if (driver.findElement(By.xpath("(" + strTableXpath + "//tr[@class='cart-item ng-scope']//td[" + intRefColIndex + "])["+i+"]")).getText()
					.equalsIgnoreCase(strRefRowValue)) {
				indexOfRow = i;
				break;

			}

		}

		return indexOfRow;

	}
}
