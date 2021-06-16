package com.TDDPOMSeleniumFramework.datautil;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class DataTransferUtil {

	/**
	 * <h1>copyToClipBoard</h1>
	 * <ul>
	 * This method uses to copy text to clipboard
	 * </ul>
	 * 
	 * @param string
	 * @return String - a string copied to clipboard
	 */
	public static String copyToClipBoard(String string) {

		String clpbrdContents = null;

		StringSelection stringSelection = new StringSelection(string);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		return clpbrdContents;

	}

	/**
	 * <b>FUNCTION NAME:</b> getTextFromTheFile<br>
	 * <b>DESCRIPTION:</b> This function reads the text inside a text file <br>
	 * <b>DATE CREATED:</b> 02/06/2017<br>
	 * 
	 * @param paramStrFileName
	 *            string file name including the file extension<br>
	 * @param paramStrVariableName
	 *            string name of the variable as a reference with corresponding
	 *            value<br>
	 * @author Christian Balangatan<br>
	 */

	public static String getTextFromTheFile(String paramStrFileName, String paramStrVariableName) {
		String varStrTextValue = "";
		String[] varStrTextArr, varStrTextArr2 = null;

		try {
			ReadTextFileUtil readFile = new ReadTextFileUtil(
					System.getProperty("user.dir").replace("\\", "/") + "/src/test/java/Data/" + paramStrFileName);
			String[] aryLines = readFile.OpenFile();

			// Extract text from the text file
			int i;
			for (i = 0; i < aryLines.length; i++) {
				varStrTextValue += aryLines[i] + " ";
			}

			// Split the initial strings read from the text file
			varStrTextArr = varStrTextValue.split(" ");
			break_loop: for (String s : varStrTextArr) {
				varStrTextArr2 = s.split("=");
				for (String t : varStrTextArr2) {
					if (t.equalsIgnoreCase(paramStrVariableName)) {
						varStrTextValue = varStrTextArr2[1];
						System.out.println("Found! The value of the variable [" + paramStrVariableName.toUpperCase()
								+ "] is : " + varStrTextValue);
						break break_loop;
					}
				}
			}
			//System.out.println(varStrTextArr2[0]);
			//System.out.println(paramStrVariableName);
			// Log if variable did not found from the text file
			if (!varStrTextArr2[0].equalsIgnoreCase(paramStrVariableName)) {
				System.err.println("Variable " + paramStrVariableName.toUpperCase() + " not found from the text file!");
			}

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

		return varStrTextValue;

	}
	
	public static String readFileLineByLine(String paramStrFileName, String paramStrKeyword){
		
		StringBuffer stringBuffer = new StringBuffer();
		String[] varStrTextArr = null;
		try {
			File file = new File(System.getProperty("user.dir").replace("\\", "/") + "/src/test/java/Data/" + paramStrFileName);
			FileReader fileReader = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				varStrTextArr = line.split("=");
				if(varStrTextArr[0].equalsIgnoreCase(paramStrKeyword)){
					System.out.println("Found! The value of the variable [" + paramStrKeyword.toUpperCase()
					+ "] is : " + varStrTextArr[1]);
					return varStrTextArr[1].toString();
				}
								
				/*stringBuffer.append(line);
				stringBuffer.append("\n");*/
			}
			
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stringBuffer.toString();
		
	}

	/**
	 * <h1>writeToTextFile</h1>
	 * <ul>
	 * This method will write the text to a textfile
	 * </ul>
	 * 
	 * @author Christian Balangatan
	 */

	public static void writeToTextFile(String text, String paramStrFileName) {
		try {

			File file = new File(System.getProperty("user.dir").replace("\\", "/") + "/src/test/java/Data/" + paramStrFileName);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
