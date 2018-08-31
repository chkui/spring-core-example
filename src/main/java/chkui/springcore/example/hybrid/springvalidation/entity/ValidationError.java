package chkui.springcore.example.hybrid.springvalidation.entity;

import org.springframework.validation.AbstractBindingResult;

@SuppressWarnings("serial")
public class ValidationError extends AbstractBindingResult {

	public ValidationError(String objectName) {
		super(objectName);
	}

	@Override
	public Object getTarget() {
		return null;
	}

	@Override
	protected Object getActualFieldValue(String field) {
		return null;
	}
}
