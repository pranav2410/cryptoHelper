package com.pranav.cryptohelper.crypto.enums;

public enum EncrytpionAlgoEnum {
	
	AES_ECB_PKCS5PADDING("AES/ECB/PKCS5Padding", "AES"),
	AES_ECB_NOPADDING("AES/ECB/NoPadding", "AES"),
	AES_CBC_PKCS5PADDING("AES/CBC/PKCS5Padding", "AES"),
	AES_CBC_NOPADDING("AES/CBC/PKCS5Padding", "AES"),
	MD5_HASH("MD5", "MD5");
	
	
	private String mstrAlgo;
	private String mstrAlgoAlias;
	
	EncrytpionAlgoEnum(String pAlgo, String pAlgoAlias) {
		this.mstrAlgo = pAlgo;
		this.mstrAlgoAlias =  pAlgoAlias;
	}
	
	public String getAlgo() {
		return mstrAlgo;
	}
	
	public String getAlgoAlias() {
		return mstrAlgoAlias;
	}
}
