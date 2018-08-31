package chkui.springcore.example.hybrid.springvalidation.entity;

import javax.validation.constraints.NotBlank;

public class Gearbox {
	@NotBlank
	private String name;
	@NotBlank
	private String manufacturer;

	public Gearbox(String name, String manufacturer) {
		this.name = name;
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public Gearbox setName(String name) {
		this.name = name;
		return this;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Gearbox [name=" + name + ", type=" + manufacturer + "]";
	}
}
