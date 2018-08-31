package chkui.springcore.example.hybrid.springvalidation.entity;

import java.util.Calendar;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import chkui.springcore.example.hybrid.springvalidation.annotation.VehicleProductionDate;
import chkui.springcore.example.hybrid.springvalidation.annotation.VehicleType;

abstract public class Vehicle {

	@NotBlank
	private String name;

	@NotBlank
	@VehicleType
	private String type;

	@NotBlank
	private String engine;

	@NotBlank
	private String manufacturer;

	@Valid //@Valid的作用是对嵌套的解构进行校验
	private Gearbox gearbox;
	
	@Valid
	private Tyre tyre;

	@VehicleProductionDate
	private Calendar productionDate;

	public Vehicle(String name, String type, String engine, String manufacturer, Gearbox gearbox, Tyre tyre,
			Calendar pd) {
		this.name = name;
		this.type = type;
		this.engine = engine;
		this.manufacturer = manufacturer;
		this.gearbox = gearbox;
		this.tyre = tyre;
		this.productionDate = pd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setGearbox(Gearbox gearbox) {
		this.gearbox = gearbox;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	public void setProductionDate(Calendar productionDate) {
		this.productionDate = productionDate;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getEngine() {
		return engine;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public Gearbox getGearbox() {
		return gearbox;
	}

	public Tyre getTyre() {
		return tyre;
	}

	public Calendar getProductionDate() {
		return productionDate;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", type=" + type + ", engine=" + engine + ", manufacturer=" + manufacturer
				+ ", gearbox=" + gearbox + ", tyre=" + tyre + ", Production Date:" + productionDate.getWeekYear() + "]";
	}
}
