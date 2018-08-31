package chkui.springcore.example.hybrid.springvalidation.entity.vehicle;

import java.util.Calendar;

import chkui.springcore.example.hybrid.springvalidation.entity.Gearbox;
import chkui.springcore.example.hybrid.springvalidation.entity.Tyre;
import chkui.springcore.example.hybrid.springvalidation.entity.Vehicle;

public class BenzC extends Vehicle {
	public BenzC(Calendar pd) {
		super("Mercedes-Benz C-Class", "CAR", "M274", "Mercedes-Benz", new Gearbox("9-Tronic", "Mercedes-Benz"),
				new Tyre("DUNLOP", "225/50 R17"), pd);
	}
}
