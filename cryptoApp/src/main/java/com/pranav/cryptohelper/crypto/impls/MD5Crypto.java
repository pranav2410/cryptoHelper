package com.pranav.cryptohelper.crypto.impls;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.pranav.cryptohelper.crypto.CryptoInterface;

public class MD5Crypto implements CryptoInterface {

	public Map<String, Object> encrypt(Key pKey, int pBlockLength, byte[] pPlainData) throws Exception {
		Map<String, Object> lReturnVal =  new HashMap<String, Object>();
		
		MessageDigest lMD5 = MessageDigest.getInstance("MD5");
		
		byte[] lbarrData = Arrays.copyOf(pPlainData, pPlainData.length);
		lMD5.update(lbarrData);
		
		byte[] lbarrDigest =  lMD5.digest();
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < lbarrDigest.length; i++) {
         sb.append(Integer.toString((lbarrDigest[i] & 0xff) + 0x100, 16).substring(1));
        }
        
		lReturnVal.put("data", sb.toString());
		
		return lReturnVal;
	}

	public byte[] decrypt(Key pKey, int pBlockLength, byte[] pEncryptedData, byte[] pIV) throws Exception {
		throw new Exception();
	}	
}
