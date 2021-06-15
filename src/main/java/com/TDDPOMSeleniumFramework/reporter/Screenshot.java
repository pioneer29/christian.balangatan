package com.TDDPOMSeleniumFramework.reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.TDDPOMSeleniumFramework.webdriver.Browser;

public class Screenshot {

	public static String name;
	public static String path = System.getProperty("user.dir") + "\\src\\test\\java\\Screenshot\\";
	public static void capture(String filename){
		  File scrFile = ((TakesScreenshot)Browser.getDriver()).getScreenshotAs(OutputType.FILE);
		  DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		  Date dateobj = new Date();
	        try {
	        	name = filename+df.format(dateobj)+".png";
				FileUtils.copyFile(scrFile, new File(path+name));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static String getname(){
		return name;
	}
	
	public static String getpath(){
		return path;
	}
}

