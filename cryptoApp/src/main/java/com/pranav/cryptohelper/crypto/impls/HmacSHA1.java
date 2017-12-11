package com.pranav.cryptohelper.crypto.impls;

import java.security.Key;
import java.util.Map;

import com.pranav.cryptohelper.crypto.CryptoInterface;

public class HmacSHA1 implements CryptoInterface {

	public Map<String, Object> encrypt(Key pEncrytionKey, int pBlockLength, byte[] pPlainData) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] decrypt(Key pKey, int pBlockLength, byte[] pEncryptedData, byte[] pIV) throws Exception {
		throw new Exception();
	}

}
