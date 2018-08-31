package chkui.springcore.example.hybrid.springvalidation.validator;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import chkui.springcore.example.hybrid.springvalidation.annotation.VehicleProductionDate;
import chkui.springcore.example.hybrid.springvalidation.factory.VehicleFactory;

public class ProductionDateValidator implements ConstraintValidator<VehicleProductionDate, Calendar> {
	@Override
	public boolean isValid(Calendar value, ConstraintValidatorContext context) {
		return VehicleFactory.CalendarS[2].getTimeInMillis() < value.getTimeInMillis();
	}
}
