package chkui.springcore.example.hybrid.springvalidation.factory;

import chkui.springcore.example.hybrid.springvalidation.entity.ValidationError;

public class ValidationErrorFactory {
	public ValidationError build(String objName) {
		return new ValidationError(objName);
	}
}
