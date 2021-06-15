package com.TDDPOMSeleniumFramework.datautil;

public class StringUtils {

	public static String append(String... params) {
		StringBuilder result = new StringBuilder();
		
		for(String param : params) {
			result.append(param);
		}
		
		return result.toString().trim();
	}

	public static String appendWithSpace(String... params) {
		StringBuilder result = new StringBuilder();
		
		for(String param : params) {
			result.append(param + " ");
		}
		
		return result.toString().trim();
	}
	
	public static boolean containsWhiteSpace(String s) {
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				return true;
			}
		}
		
		return false;
	}
}
