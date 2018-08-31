package chkui.springcore.example.javabase.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import chkui.springcore.example.javabase.validation.annotation.Type;

public class TypeValidator implements ConstraintValidator<Type, String> {
	private final List<String> TYPE = Arrays.asList(new String[]{"RPG", "ACT", "SLG", "ARPG"});
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return TYPE.contains(value);
	}
}
