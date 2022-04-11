package com.shashi.TransactionQ.util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Component;




@Component
public class ObjectEncryptionDecryption {
	
	private String key = "Bar12345Bar12345";
	
	private Key aesKey;
	private Cipher cipher;
	
	public ObjectEncryptionDecryption() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		aesKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher = Cipher.getInstance("AES");
        
	}

	public String encryptString(String str) throws Exception {
		
		cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		 return Base64.getEncoder()
			        .encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
	}
	
	public String decryptString(String str) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		cipher.init(Cipher.DECRYPT_MODE, aesKey);
		return new String(cipher.doFinal(Base64.getDecoder()
		        .decode(str)));
	}

  
 
 }
