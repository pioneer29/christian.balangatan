package com.TDDPOMSeleniumFramework.reporter;

import com.TDDPOMSeleniumFramework.pages.BasePage;

public class Log extends BasePage {

	@SuppressWarnings("deprecation")
	
	public static void testStep(String tag, String Actual){
		
		if(tag.toUpperCase()=="PASSED"){
			////Reporter.log("["+tag+"] "+Actual);
			System.out.println("\t\t\t["+tag+"] "+Actual);
		}
		else 
		if(tag.toUpperCase()=="FAILED"){
			Screenshot.capture("FAILED");
			////Reporter.log("["+tag+"] "+Actual);
			System.out.println("\t\t\t["+tag+"] "+Actual);
			System.out.println("\t\t\t[Screenshot] " + Screenshot.getpath()+Screenshot.getname());
			//Assert.fail(Actual);
		}else
		if(tag.toUpperCase()=="WARNING"){
			////Reporter.log("["+tag+"] "+Actual);
			System.out.println("\t\t\t["+tag+"] "+Actual);
		}else{
			////Reporter.log("["+tag+"] "+Actual);
			System.out.println("\t\t\t["+tag+"] "+Actual);
		}
}
	public static void testStep(String tag,String Actual, String Expected){
		
			if(tag.toUpperCase()=="PASSED"){
				//Reporter.log("["+tag+"] "+Actual);
				System.out.println("\t\t\t["+tag+"] "+Actual);
			}
			else 
			if(tag.toUpperCase()=="FAILED"){
				Screenshot.capture("FAILED");
				//Reporter.log("["+tag+"] "+Actual);
				System.out.println("\t\t\t["+tag+"] "+Actual);
				System.out.println("\t\t\t[Expected Result] "+Expected);
				System.out.println("\t\t\t[Screenshot] " + Screenshot.getpath()+Screenshot.getname());
				//Assert.fail(Actual);
			}else
			if(tag.toUpperCase()=="WARNING"){
				//Reporter.log("["+tag+"] "+Actual);
				System.out.println("\t\t\t["+tag+"] "+Actual);
			}else{
				//Reporter.log("["+tag+"] "+Actual);
				System.out.println("\t\t\t["+tag+"] "+Actual);
			}
	}
	
	public static void setStoryName(String name){
			System.out.println("[Story Name] "+name);
	}
	
	public static void setTestCaseName(String name){
		System.out.println("\t[Test Case Name] "+name);
	}
	
	public static void setTestStep(String name){
		System.out.println("\t\t[Test Case Step] "+name);
	}
}
