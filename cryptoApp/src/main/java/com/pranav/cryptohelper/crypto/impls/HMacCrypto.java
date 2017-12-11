package com.pranav.cryptohelper.crypto.impls;

import java.security.Key;
import java.util.Map;

import javax.crypto.Mac;

import com.pranav.cryptohelper.crypto.CryptoInterface;
import com.pranav.cryptohelper.crypto.enums.EncrytpionAlgoEnum;

public abstract class HMacCrypto implements CryptoInterface {

	public Map<String, Object> encrypt(EncrytpionAlgoEnum pAlgo, Key pEncrytionKey, int pBlockLength, byte[] pPlainData) throws Exception {
		
		Mac lHmac = Mac.getInstance(pAlgo.getAlgo());
		lHmac.init(pEncrytionKey);
		lHmac.doFinal(pPlainData);
		encryptSpecific(pAlgo, new String(pEncrytionKey.getEncoded()), pBlockLength, pPlainData);
		return null;
	}

	public byte[] decrypt(EncrytpionAlgoEnum pAlgo, Key pKey, int pBlockLength, byte[] pEncryptedData, byte[] pIV) throws Exception {
		throw new Exception();
	}

	public abstract byte[] encryptSpecific(EncrytpionAlgoEnum pAlgo, String pKey, int pBlockLength, byte[] pPlainData) throws Exception;
}
