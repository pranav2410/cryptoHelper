package com.pranav.cryptohelper.crypto;

import java.security.Key;
import java.util.Map;

import com.pranav.cryptohelper.crypto.enums.EncrytpionAlgoEnum;

public interface CryptoInterface {

	/**
	 * This method accepts Key for encryption, key size and block-length, and data to be encrypted. <br> 
	 * This method will use dofinal() for any implementing Encryption Algorithm.<br>
	 * Block-length should be equal or more than key size.<br>
	 * <b>Note:</b> Algorithms like AES/CBC/PKCS5Padding and AES/CBC/PKCS5Padding use IV(Initialization Vector). IV used will be returned in Map    
	 * @param pEncrytionKey
	 * @param pBlockLength
	 * @param pPlainData
	 * @return Map with String value pair. Structure: {'data': '&lt;encrypted_data_byte_array&gt;', 'iv': '&lt;iv_byte_array&gt;'}
	 * @throws Exception
	 */
	public Map<String, Object> encrypt(Key pEncrytionKey, int pBlockLength, byte[] pPlainData)throws Exception;
	
	/**
	 * This method accepts Key for decryption, key size and block-length, and data to be decrypted. <br> 
	 * This method will use dofinal() for any implementing Encryption Algorithm.<br>
	 * Block-length should be equal or more than key size.<br> 
	 * <b>Note:</b> Algorithms like AES/CBC/PKCS5Padding and AES/CBC/PKCS5Padding use IV(Initialization Vector). <strong>IV is Mandatory for decryption while using these algorithms.</strong>
	 * @param pKey
	 * @param pBlockLength
	 * @param pEncryptedData
	 * @return
	 * @throws Exception 
	 */
	public byte[] decrypt(Key pKey, int pBlockLength, byte[] pEncryptedData, byte[] pIV) throws Exception;
}
