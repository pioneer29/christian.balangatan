package com.TDDPOMSeleniumFramework.datautil;

import java.io.FileInputStream;
import java.io.IOException;


public class DataTable {
//
//		public static String configPath = System.getProperty("user.dir").replace("\\", "/")+"/src/test/java/Config/configuration.txt";
//		
//		public static String getValueBySheetRowColumn(String exlsFileName, String sheet,Integer row, Integer column) throws BiffException, IOException{
//			String FilePath = System.getProperty("user.dir") + "\\src\\test\\java\\Data\\" + Configuration.getValue(exlsFileName, configPath);
//			FileInputStream fs = new FileInputStream(FilePath);
//			Workbook wb = Workbook.getWorkbook(fs);
//			Sheet sh = wb.getSheet(sheet);
//			
//			return sh.getCell(row, column).getContents(); 
//		}
//		
//		public static String getValueBySheetRowNameColumnIndex(String exlsFileName, String sheet, String rowName, int column) throws BiffException, IOException{
//			int row = 0;
//			while(!getValueBySheetRowColumn(exlsFileName, sheet,row,0).contentEquals(rowName)){
//				row+=1;	
//			}
//
//			return getValueBySheetRowColumn(exlsFileName, sheet,row,column); 
//		}
//		
//		public static String getValueFromDownloadedExcel(String filename,String sheet,int row, int column) throws BiffException, IOException{
//			String FilePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\downloads\\"+filename;
//			FileInputStream fs = new FileInputStream(FilePath);
//			Workbook wb = Workbook.getWorkbook(fs);
//			Sheet sh = wb.getSheet(sheet);
//			
//			return sh.getCell(row, column).getContents(); 
//		}
//		
//		public static int getCellCountWithValueByColumn(String exlsFileName, String sheet, String rowName) throws BiffException, IOException{
//			String FilePath = System.getProperty("user.dir") + "\\src\\test\\java\\Data\\" + Configuration.getValue(exlsFileName, configPath);
//			FileInputStream fs = new FileInputStream(FilePath);
//			Workbook wb = Workbook.getWorkbook(fs);
//			Sheet sh = wb.getSheet(sheet);
//			
//			int row = 0;
//			while(!getValueBySheetRowColumn(exlsFileName, sheet,row,0).contentEquals(rowName)){
//				row+=1;	
//			}
//			
//			Cell[] cell = sh.getColumn(row);
//			
//			return cell.length; 
//		}
}
		
