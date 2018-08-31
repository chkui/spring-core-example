package chkui.springcore.example.hybrid.springvalidation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import chkui.springcore.example.hybrid.springvalidation.entity.Gearbox;

public class GearboxValidator implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		return Gearbox.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Gearbox gearbox = Gearbox.class.cast(target);

		if (null == gearbox.getName()) {
			ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "变速箱名字为空");
		}
		if (null == gearbox.getManufacturer()) {
			ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "生产商名字为空");
		}
	}

}
