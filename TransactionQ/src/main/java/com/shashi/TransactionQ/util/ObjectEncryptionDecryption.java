package com.shashi.TransactionQ.util;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import com.shashi.TransactionQ.model.Transaction;




@Component
public class ObjectEncryptionDecryption {
	
	private static String encodedKey = "tWHZ2hWY/tY=";
	
	private static SecretKey key;
	
	public ObjectEncryptionDecryption() {
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        this.key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
	}


  private static Cipher getCipherObject(String type ) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
    Cipher cipher;
    cipher = Cipher.getInstance("DES");
    if(type.contentEquals("encryption"))
    {
      cipher.init(Cipher.ENCRYPT_MODE, key);
    }
    else if(type.contentEquals("decryption")){
      cipher.init(Cipher.DECRYPT_MODE, key);
    }
    return cipher;
    
  }

  public static SealedObject encryptObject(Serializable o) throws InvalidKeyException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException, IOException{
    
    SealedObject sealed = new SealedObject(o, getCipherObject("encryption"));
    
    System.out.println("Object Encrypted");
    return sealed;
  }
  

  public static Transaction decryptObject(SealedObject sealed) throws InvalidKeyException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
	  Transaction encryptedObject = (Transaction) sealed.getObject(getCipherObject("decryption"));
    System.out.println("Object Decrypted");
    return encryptedObject;
    
  }

  
 
 }
