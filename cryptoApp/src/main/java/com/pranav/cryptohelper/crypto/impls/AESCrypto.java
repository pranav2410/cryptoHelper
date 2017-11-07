package com.pranav.cryptohelper.crypto.impls;

import java.security.Key;
import java.util.Map;

import com.pranav.cryptohelper.crypto.CryptoInterface;

public abstract class AESCrypto implements CryptoInterface {

	public Map<String, Object> encrypt(Key pKey, int pBlockLength, byte[] pPlainData) throws Exception {
		return null;
	}

	public byte[] decrypt(Key pKey, int pBlockLength, byte[] pEncryptedData, byte[] pIV) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract byte[] encryptSpecific(String pKey, int pBlockLength, byte[] pPlainData) throws Exception;
	
	public abstract byte[] decryptSpecific(String pKey, int pBlockLength, byte[] pEncryptedData, byte[] pIV) throws Exception;

}
