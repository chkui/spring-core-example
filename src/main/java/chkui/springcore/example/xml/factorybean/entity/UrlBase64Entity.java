package chkui.springcore.example.xml.factorybean.entity;

import java.util.Base64;

public class UrlBase64Entity implements Text {
	private String cipher;

	public UrlBase64Entity(String text) {
		this.cipher = Base64.getUrlEncoder().encodeToString(text.getBytes());
	}
	
	@Override
	public Type getType() {
		return Text.Type.UrlBase64;
	}

	@Override
	public String getCipher() {
		return cipher;
	}
}
