package com.TDDPOMSeleniumFramework.datautil;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.openqa.selenium.internal.Base64Encoder;


@SuppressWarnings("restriction")
public class EncryptDecryptPassword {
   

	private static final String ALGO = "AES";
	 
	private static final byte[] keyValue = new byte[] { 'm', 'Y', 'p', 'U',
			'b', 'l', 'I', 'c', 'k', 'E', 'y', 'n', 'A', 'e', 'E', 'M' };
 
	public static String decrypt(String encryptedData){
		
		byte[] decordedValue, decValue = null;
		String decryptedValue = "";
		try{
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			decordedValue = new Base64Encoder().decode(encryptedData);
			decValue = c.doFinal(decordedValue);
			decryptedValue = new String(decValue);
		} catch (Exception e){
			System.err.println(e.getMessage());
		}
		return decryptedValue;
	}
 
	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
 
	public static String encrypt(String Data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = new Base64Encoder().encode(encVal);
		return encryptedValue;
	}
 
}