package chkui.springcore.example.xml.factorybean.entity;

import java.util.Base64;

public class Base64Entity implements Text {
	private String cipher;

	public Base64Entity(String text) {
		this.cipher = Base64.getEncoder().encodeToString(text.getBytes());
	}
	
	@Override
	public Type getType() {
		return Text.Type.Base64;
	}

	@Override
	public String getCipher() {
		return cipher;
	}
}
