package chkui.springcore.example.hybrid.springvalidation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import chkui.springcore.example.hybrid.springvalidation.annotation.VehicleType;

public class TypeValidator implements ConstraintValidator<VehicleType, String> {
	private List<String> _TYPE = Arrays.asList(new String[] { "CAR", "SUV", "MPV" });
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return _TYPE.contains(value);
	}
}
