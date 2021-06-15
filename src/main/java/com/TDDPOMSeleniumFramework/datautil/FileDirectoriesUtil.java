package com.TDDPOMSeleniumFramework.datautil;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class FileDirectoriesUtil {
	
	/**
	 * <b>FUNCTION NAME:</b> getTNSFilePath</br>
	 * <b>DATE CREATED:</b> 06/06/2017 </br>
	 * @return TNS_FILEPATH string file path
	 */
	public static String getTNSFilePath(){
		
		String TNS_FILEPATH = null;
		try {
			// Get the local hostname of the machine
			String varStrHostName = InetAddress.getLocalHost().getHostName();
			if(varStrHostName.contains("APP")){
				TNS_FILEPATH = "C:/Oracle/product/12.1.0/client_1/network/admin";
			} else {
				TNS_FILEPATH = "C:/app/"+System.getProperty("user.name")+"/product_2/11.2.0/dbhome_1/NETWORK/ADMIN";
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TNS_FILEPATH;
		
	}

}
