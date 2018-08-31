package chkui.springcore.example.hybrid.springvalidation;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import chkui.springcore.example.hybrid.springvalidation.entity.ValidationError;
import chkui.springcore.example.hybrid.springvalidation.entity.Vehicle;
import chkui.springcore.example.hybrid.springvalidation.factory.ValidationErrorFactory;
import chkui.springcore.example.hybrid.springvalidation.service.PersonService;
import chkui.springcore.example.hybrid.springvalidation.validator.VehicleValidator;

public class SpringValidationApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringValidationConfig.class);
		springValidation(ctx);// spring自定义的验证
		beanValidation(ctx);// JSR规范验证
		adapterValidation(ctx); // 适配校验
		methodValidation(ctx);// 方法参数校验
	}

	// Spring源生验证
	private static void springValidation(ApplicationContext ctx) {
		print("1. Spring 源生数据校验：");

		VehicleValidator vehicleValidator = ctx.getBean(VehicleValidator.class);// 获取校验器
		Vehicle vehicle = ctx.getBean(Vehicle.class);// 获取要检验的对象

		ValidationError error = ctx.getBean(ValidationErrorFactory.class).build("Vehicle");

		ValidationUtils.invokeValidator(vehicleValidator, vehicle, error);
		List<FieldError> list = error.getFieldErrors();
		print("车辆信息：");
		print(vehicle);
		int count = 1;
		for (FieldError res : list) {
			print("Error Info ", count++, ".");
			print("Entity:", res.getObjectName());
			print("Field:", res.getField());
			print("Code:", res.getCode());
			print("Message:", res.getDefaultMessage());
			print("-");
		}
		print("==================================================");
	}

	private static void beanValidation(ApplicationContext ctx) {
		print("2. JSR Bean Validation 数据校验：");

		Validator validator = ctx.getBean(Validator.class);// 获取校验器
		Vehicle vehicle = ctx.getBean(Vehicle.class);// 获取要检验的对象

		print("车辆信息：");
		print(vehicle);

		validator.validate(vehicle).forEach(err -> { // 执行检验
			print("Field: ", err.getPropertyPath());
			print("Error: ", err.getMessage());
		});

		print("==================================================");
	}

	private static void adapterValidation(ApplicationContext ctx) {
		print("3. JSR Bean Validation 数据校验：");
		// 获取校验器
		// LocalValidatorFactoryBean继承了SpringValidatorAdapter，所以这里就是获取LocalValidatorFactoryBean
		SpringValidatorAdapter adapter = ctx.getBean(SpringValidatorAdapter.class);
		Vehicle vehicle = ctx.getBean(Vehicle.class);// 获取要检验的对象

		ValidationError error = ctx.getBean(ValidationErrorFactory.class).build("Vehicle");
		
		print("Spring Validation校验");
		ValidationUtils.invokeValidator(adapter, vehicle, error);
		List<FieldError> list = error.getFieldErrors();
		int count = 1;
		for (FieldError res : list) {
			print("Error Info ", count++, ".");
			print("Entity:", res.getObjectName());
			print("Field:", res.getField());
			print("Code:", res.getCode());
			print("Message:", res.getDefaultMessage());
			print("-");
		}

		print("Bean Validation 校验");
		adapter.validate(vehicle).forEach(err -> { // 执行检验
			print("Field: ", err.getPropertyPath());
			print("Error: ", err.getMessage());
		});

		print("==================================================");
	}

	private static void methodValidation(ApplicationContext ctx) {
		print("4. 方法参数校验：");
		try {
			PersonService personService = ctx.getBean(PersonService.class);
			personService.execute(null, 1);
		} catch (ConstraintViolationException error) {
			error.getConstraintViolations().forEach(err -> {
				print("Field: ", err.getPropertyPath());
				print("Error: ", err.getMessage());
			});
		}
		print("==================================================");
	}

	private static void print(Object... infos) {
		StringBuilder sb = new StringBuilder();
		if (null != infos) {
			for (Object info : infos) {
				sb.append(info);
			}
		} else {
			sb.append("null");
		}
		System.out.println(sb.toString());
	}
}
