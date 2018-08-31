package chkui.springcore.example.xml.beanfactorypostprocessor.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Cpu {
	private String brand;
	
	@Autowired
	private Pc belong;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Pc getBelong() {
		return belong;
	}

	public void setBelong(Pc belong) {
		this.belong = belong;
	}
}
