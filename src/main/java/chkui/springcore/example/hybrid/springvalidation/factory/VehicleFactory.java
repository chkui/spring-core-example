package chkui.springcore.example.hybrid.springvalidation.factory;

import java.util.Calendar;
import java.util.Random;

import chkui.springcore.example.hybrid.springvalidation.entity.Vehicle;
import chkui.springcore.example.hybrid.springvalidation.entity.vehicle.BenzC;
import chkui.springcore.example.hybrid.springvalidation.entity.vehicle.Envision;
import chkui.springcore.example.hybrid.springvalidation.entity.vehicle.UnknownCar;

public class VehicleFactory {
	// 随即指定2个生产日期
	public static Calendar[] CalendarS = new Calendar[] { new Calendar.Builder().setFields(Calendar.YEAR, 2018).build(),
			new Calendar.Builder().setFields(Calendar.YEAR, 2017).build(),
			new Calendar.Builder().setFields(Calendar.YEAR, 2016).build(),
			new Calendar.Builder().setFields(Calendar.YEAR, 2015).build(),
			new Calendar.Builder().setFields(Calendar.YEAR, 2014).build() };
	public static Vehicle[] VEHICLES = new Vehicle[] { new BenzC(CalendarS[Local.random(5)]),
			new Envision(CalendarS[Local.random(5)]), new UnknownCar(CalendarS[Local.random(5)]) };

	public static Vehicle build() {
		return VEHICLES[Local.random(3)];
	}
}

class Local {
	static public int random(int len) {
		return Math.abs(new Random().nextInt()) % len;
	}
}
