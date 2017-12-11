package com.pranav.cryptohelper.crypto;

import com.pranav.cryptohelper.crypto.enums.EncrytpionAlgoEnum;
import com.pranav.cryptohelper.crypto.impls.AESCBCNoPadding;
import com.pranav.cryptohelper.crypto.impls.AESCBCPKCS5Padding;
import com.pranav.cryptohelper.crypto.impls.AESECBNOPadding;
import com.pranav.cryptohelper.crypto.impls.AESECBPKCS5Padding;
import com.pranav.cryptohelper.crypto.impls.HmacMD5Crypto;
import com.pranav.cryptohelper.crypto.impls.HmacSHA1;
import com.pranav.cryptohelper.crypto.impls.HmacSHA2;
import com.pranav.cryptohelper.crypto.impls.MD5Crypto;

public class CryptoManager {
	
	public static CryptoInterface getInstance(EncrytpionAlgoEnum pAlgo) {
		CryptoInterface lCrypto = null;
		switch (pAlgo) {
		case AES_CBC_NOPADDING:
			lCrypto = new AESCBCNoPadding();
			break;
		case AES_CBC_PKCS5PADDING:
			lCrypto = new AESCBCPKCS5Padding();
			break;
		case AES_ECB_NOPADDING:
			lCrypto = new AESECBNOPadding();
			break;
		case AES_ECB_PKCS5PADDING:
			lCrypto = new AESECBPKCS5Padding();
			break;
		case MD5_HASH:
			lCrypto = new MD5Crypto();
			break;
		case  HMAC_MD5:
			lCrypto = new HmacMD5Crypto();
			break;
		case  HMAC_SHA1:
			lCrypto = new HmacSHA1();
			break;
		case  HMAC_SHA2:
			lCrypto = new HmacSHA2();
			break;
		default:
			break;
		}
		return lCrypto;
	}

}
