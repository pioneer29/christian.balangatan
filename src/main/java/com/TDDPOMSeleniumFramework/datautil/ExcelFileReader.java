package com.TDDPOMSeleniumFramework.datautil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
	        throws IOException {
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputStream);
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputStream);
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	 
	    return workbook;
	}
	
	public static String getColumnValueForNthRow(String fileName, int sheet, int r, int c) throws IOException, Exception, InvalidFormatException {
		String filePath = System.getProperty("user.dir").replace("\\", "/") + "/src/test/java/Data/" + fileName;
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook workbook = getWorkbook(inputStream, filePath);
		Sheet sh = workbook.getSheetAt(sheet);
		Row row = sh.getRow(r);
		Cell cell = row.getCell(c);
		return cell.getStringCellValue();
	}
	
	
}
