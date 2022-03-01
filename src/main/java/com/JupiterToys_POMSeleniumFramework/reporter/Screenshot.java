package com.JupiterToys_POMSeleniumFramework.reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.JupiterToys_POMSeleniumFramework.datautil.Common;
import com.JupiterToys_POMSeleniumFramework.pages.BasePage;
import com.JupiterToys_POMSeleniumFramework.webdriver.Browser;

public class Screenshot extends BasePage {

	
	//public static String path = System.getProperty("user.dir") + "\\src\\test\\java\\screenshots\\";
	public static String path = Common.PATH_SCREENSHOTS;
	public static void capture(String filename){
		  File scrFile = ((TakesScreenshot)Browser.getDriver()).getScreenshotAs(OutputType.FILE);
		  DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		  Date dateobj = new Date();
	        try {
	        	screenshotName = filename+df.format(dateobj)+".png";
				FileUtils.copyFile(scrFile, new File(path+screenshotName));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static String getname(){
		return screenshotName;
	}
	
	public static String getpath(){
		return path;
	}
}

