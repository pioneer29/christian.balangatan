package com.TDDPOMSeleniumFramework.datautil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class PropertyFileUtil {

	public static String createUpdatePropertyFile(String paramStrPropFileName, String...paramStrAurg){
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\Data\\" + paramStrPropFileName;
        File file = new File(filePath);
        try{
	        OutputStream out = new FileOutputStream(file);
	        String[] arrOfString;
	        
	        if(file.exists()){
	        	Browser.getProp().load(new FileReader(file));
	        	
	        	for(String s: paramStrAurg){
					arrOfString = s.split("\\|"); // Split the string
					Browser.getProp().setProperty(arrOfString[0], arrOfString[1]); // Writes/Updates property file
					System.out.println(paramStrPropFileName + " successfully updated.");
				}
	        } else{
	        	file.createNewFile(); // Create a file, also checks if the file exists
				filePath = file.toString(); // Convert the file path to a string data type
				System.out.println(filePath + " successfully created.");
				
				for(String s: paramStrAurg){
					arrOfString = s.split("\\|"); // Split the string
					
					if(arrOfString[0].equalsIgnoreCase(arrOfString[0])){
						
					}
					Browser.getProp().setProperty(arrOfString[0], arrOfString[1]); // Writes to a property file
				}
	        	System.out.println(paramStrPropFileName + " file successfully created.");
	        }
	        Browser.getProp().store(out, "Author: "+ System.getProperty("user.name"));
        }catch (IOException e){
	        	System.err.println(e.getMessage());
	        }
		return filePath;
	}

	public static String loadAndReadpropertyValue(String paramStrPropFileName, String paramStrPropperty) {

		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\Data\\" + paramStrPropFileName;
        File file = new File(filePath);
        InputStream input = null;
        
		String result = "";
		try {
			input = new FileInputStream(file);
			
			// load a properties file
			Browser.getProp().load(input);
			
			result = Browser.getProp().getProperty(paramStrPropperty); // Read the property file

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static void writeToPropertyFile(String paramStrPropFileName, Properties props, String... paramStrAurg)
			throws IOException {

		File f = new File(paramStrPropFileName);
		OutputStream out = new FileOutputStream(f);
		props.store(out, "Author: " + System.getProperty("user.name"));

	}

	public static void closeTheFile(String paramStrPropFileName) {

		try {
			FileOutputStream writer = new FileOutputStream(paramStrPropFileName);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
