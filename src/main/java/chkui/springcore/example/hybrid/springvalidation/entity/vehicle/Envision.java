package chkui.springcore.example.hybrid.springvalidation.entity.vehicle;

import java.util.Calendar;

import chkui.springcore.example.hybrid.springvalidation.entity.Gearbox;
import chkui.springcore.example.hybrid.springvalidation.entity.Tyre;
import chkui.springcore.example.hybrid.springvalidation.entity.Vehicle;

public class Envision extends Vehicle {

	public Envision(Calendar pd) {
		super("Buick Envision", "SUV", "LTG 2.0T", "Buick", new Gearbox("9-AT", "Buick"),
				new Tyre("GOODYEAR", "235/50 R19"), pd);
	}

}
