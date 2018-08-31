package chkui.springcore.example.xml.factorybean.adapter;

import java.util.Base64;

public class UrlBase64Adapter implements DecodeAdapter {
	private String cipher;

	public UrlBase64Adapter(String cipher){
		this.cipher = cipher;
	}

	@Override
	public String getPlain() {
		return new String(Base64.getUrlDecoder().decode(cipher));
	}
}
