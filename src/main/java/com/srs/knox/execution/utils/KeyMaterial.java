package com.srs.knox.execution.utils;

public class KeyMaterial {
	private String cryptoAlg;
	private String curve;
	private String params;
	private DHPublicKey DHPublicKeyObject;
	private String Nonce;
	private String Signature;

	public String getCryptoAlg() {
		return cryptoAlg;
	}

	public String getCurve() {
		return curve;
	}

	public String getParams() {
		return params;
	}

	public DHPublicKey getDHPublicKey() {
		return DHPublicKeyObject;
	}

	public String getNonce() {
		return Nonce;
	}

	public String getSignature() {
		return Signature;
	}

	public void setCryptoAlg(String cryptoAlg) {
		this.cryptoAlg = cryptoAlg;
	}

	public void setCurve(String curve) {
		this.curve = curve;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public void setDHPublicKey(DHPublicKey DHPublicKeyObject) {
		this.DHPublicKeyObject = DHPublicKeyObject;
	}

	public void setNonce(String Nonce) {
		this.Nonce = Nonce;
	}

	public void setSignature(String Signature) {
		this.Signature = Signature;
	}
}
