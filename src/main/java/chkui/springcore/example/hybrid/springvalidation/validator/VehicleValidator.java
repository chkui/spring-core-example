package chkui.springcore.example.hybrid.springvalidation.validator;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import chkui.springcore.example.hybrid.springvalidation.entity.Vehicle;
import chkui.springcore.example.hybrid.springvalidation.factory.VehicleFactory;

public class VehicleValidator implements Validator {
	private List<String> _TYPE = Arrays.asList(new String[] { "CAR", "SUV", "MPV" });
	
	@Autowired
	GearboxValidator gearboxValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		return Vehicle.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Vehicle vehicle = Vehicle.class.cast(target);

		if (null == vehicle.getName()) {
			ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "车辆名称为空");
		}
		if (!_TYPE.contains(vehicle.getType())) {
			errors.rejectValue("type", "type.error", "汽车类型必须是" + _TYPE);
		}
		Calendar cal = VehicleFactory.CalendarS[2];
		if (cal.getTimeInMillis() > vehicle.getProductionDate().getTimeInMillis()) {
			errors.rejectValue("Production Date", "pd.error", "汽车必须是" + cal.getWeekYear() + "年之后生产");
		}
		if(null == vehicle.getGearbox()) {
			errors.rejectValue("gearbox", "gearbox.error", "变速箱信息为空");
		}else {
			errors.pushNestedPath("gearbox");
            ValidationUtils.invokeValidator(gearboxValidator, vehicle.getGearbox(), errors);
		}
	}
}
