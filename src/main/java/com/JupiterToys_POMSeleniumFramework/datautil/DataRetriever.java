package com.JupiterToys_POMSeleniumFramework.datautil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.JupiterToys_POMSeleniumFramework.pages.BasePage;


public class DataRetriever extends BasePage {



	public static String funcGetDataFromExcel(String fileName, String sheetName, String refColumn, String refRowValue, String refColToGetValue) throws Exception {

		// Create an object of File class to open xlsx file

		File file = new File(Common.PATH_TESTDATA);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			try {
				workbook = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of HSSFWorkbook class

			workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		Sheet sheet = workbook.getSheet(sheetName);

		// Find number of rows in excel file

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it
		String retVal = null, retValue = null;
		int intColIndex = funcGetExcelColumnIndex(sheetName,refColumn,workbook);
		
		for (int i = 0; i < rowCount + 1; i++) {
			retVal = funcGetExcelCellValueForNthRowCol(sheetName, i, intColIndex, workbook);
			if(retVal.equalsIgnoreCase(refRowValue)) {
				retValue = funcGetExcelCellValueForNthRowCol(sheetName, i, funcGetExcelColumnIndex(sheetName,refColToGetValue,workbook), workbook);
				workbook.close();
				break;
			}
			
		}
		
		if (retValue == null) {
			throw new Exception("Data is not found in excel file.");
		}
		
		return retValue;

	}

	public static Integer funcGetExcelColumnIndex(String sheetName, String columnName, Workbook workbook) throws Exception {

		Sheet sheet = workbook.getSheet(sheetName);
		Row r = sheet.getRow(0);
		int colIndex = -1;

		for (int cn = 0; cn < r.getLastCellNum(); cn++) {
			Cell c = r.getCell(cn);
			if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
				continue;
			}
			if (c.getCellType() == Cell.CELL_TYPE_STRING) {
				String text = c.getStringCellValue();
				if (columnName.equals(text)) {
					colIndex = cn;
					break;
				}
			}
		}
		workbook.close();

		if (colIndex == -1) {
			throw new Exception("None of the cells in the first row were Patch");
		}

		return colIndex;

	}

	public static String funcGetExcelCellValueForNthRowCol(String sheetName, int row, int col, Workbook workbook)
			throws IOException {

		Sheet sheet = workbook.getSheet(sheetName);
		Row actualRow = sheet.getRow(row);
		Cell actualCell = actualRow.getCell(col);

		String actualValue = actualCell.getStringCellValue();
		workbook.close();
		return actualValue;

	}

}
