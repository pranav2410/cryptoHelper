package com.pranav.cryptohelper;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.pranav.cryptohelper.crypto.CryptoInterface;
import com.pranav.cryptohelper.crypto.CryptoManager;
import com.pranav.cryptohelper.crypto.enums.EncrytpionAlgoEnum;
import com.pranav.cryptohelper.crypto.enums.KeyLength;

public class CryptoHelper {
	
	private static KeyGenerator msKeyGenerator_32;
	private static int msiCount32 = 0;
	private static KeyGenerator msKeyGenerator_16;
	private static int msiCount16 = 0;
	private static Object msIntrensicLock = new Object();
	
	
	/**
	 * generates SecreytKey for Algorithm passed.<br>
	 * May throw Exception if invalid algorithm name is passed.<br>
	 * @param pKeyLength
	 * @param pAlogrithm
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	public static SecretKey generateKey(KeyLength pKeyLength, String pAlogrithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		synchronized (msIntrensicLock) {
			SecureRandom lSecRandom =  new SecureRandom();
			SecretKey lKey = null;	
			
			if(pKeyLength.equals(KeyLength.KEY_SIZE_128)) {
				if(msKeyGenerator_16 == null || msiCount16 == 100) {
					msKeyGenerator_16 = KeyGenerator.getInstance(pAlogrithm);
					msKeyGenerator_16.init(pKeyLength.getKeySiz(), lSecRandom);
				}
				lKey = msKeyGenerator_16.generateKey();
				msiCount16++;
			}
			else if(pKeyLength.equals(KeyLength.KEY_SIZE_256)){
				if(msKeyGenerator_32 == null || msiCount32 == 100) {
					msKeyGenerator_32 = KeyGenerator.getInstance(pAlogrithm);
					msKeyGenerator_32.init(pKeyLength.getKeySiz(), lSecRandom);
				}
				lKey = msKeyGenerator_32.generateKey();
				msiCount32++;
			}
			
			return lKey;
		}		
	}
	
	public static Map<String, Object> encrypt(byte[] pPlainData, Key pEncrytionKey, int pBlockLength, EncrytpionAlgoEnum pAlgorithm) throws Exception {
		assert pEncrytionKey != null;
		CryptoInterface lCrypto = CryptoManager.getInstance(pAlgorithm);
		Map<String, Object> lData =  lCrypto.encrypt(pEncrytionKey, pBlockLength, pPlainData);
		return lData;	
	}
	
	public static Map<String, Object> decrypt(byte[] pEncryptedData, Key pDecrytionKey, int pBlockLength) {
		return null;
	}  
}
