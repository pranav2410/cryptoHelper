package com.pranav.cryptohelper.crypto.impls;

import java.security.Key;
import java.util.Map;

import javax.crypto.Mac;

import com.pranav.cryptohelper.crypto.CryptoInterface;

public class HmacSHA2 implements CryptoInterface {

	public Map<String, Object> encrypt(Key pEncrytionKey, int pBlockLength, byte[] pPlainData) throws Exception {
		Mac lHmac = Mac.getInstance(pAlgo.getAlgo());
		lHmac.init(pEncrytionKey);
		lHmac.doFinal(pPlainData);
		return null;
	}

	public byte[] decrypt(Key pKey, int pBlockLength, byte[] pEncryptedData, byte[] pIV) throws Exception {
		throw new Exception();
	}

}
