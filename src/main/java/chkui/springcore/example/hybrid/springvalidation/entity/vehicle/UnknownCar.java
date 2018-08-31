package chkui.springcore.example.hybrid.springvalidation.entity.vehicle;

import java.util.Calendar;

import chkui.springcore.example.hybrid.springvalidation.entity.Gearbox;
import chkui.springcore.example.hybrid.springvalidation.entity.Tyre;
import chkui.springcore.example.hybrid.springvalidation.entity.Vehicle;

public class UnknownCar extends Vehicle {

	public UnknownCar(Calendar pd) {
		super(null, null, null, null, new Gearbox(null, null), new Tyre(null, null), pd);
	}

}
