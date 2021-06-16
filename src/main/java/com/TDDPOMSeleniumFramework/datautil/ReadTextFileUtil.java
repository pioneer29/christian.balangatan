package com.TDDPOMSeleniumFramework.datautil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Christian Balangatan
 *
 */

public class ReadTextFileUtil {

	private String path;

	public ReadTextFileUtil(String file_path) {

		path = file_path;

	}
	
	public String[] OpenFile() throws IOException{
		
		FileReader reader = new FileReader(path);
		BufferedReader textReader = new BufferedReader(reader);
		
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		
		int i;
		for(i = 0; i < numberOfLines; i++){
			textData[i] = textReader.readLine();
		}
		
		textReader.close();
		return textData;
	}
	
	int readLines() throws IOException{
		
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		@SuppressWarnings("unused")
		String aLine;
		int numberOfLines = 0;
		
		while (( aLine = bf.readLine()) != null){
			numberOfLines++;
		}
		
		bf.close();
		
		return numberOfLines;
	}
	
	
	
}
