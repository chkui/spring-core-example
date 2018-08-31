package chkui.springcore.example.hybrid.springvalidation.entity;

import javax.validation.constraints.NotBlank;

public class Tyre {
	@NotBlank
	private String manufacturer;
	@NotBlank
	private String spec;

	public Tyre(String manufacturer, String spec) {
		super();
		this.manufacturer = manufacturer;
		this.spec = spec;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getSpec() {
		return spec;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Override
	public String toString() {
		return "Tyre [manufacturer=" + manufacturer + ", spec=" + spec + "]";
	}
}
