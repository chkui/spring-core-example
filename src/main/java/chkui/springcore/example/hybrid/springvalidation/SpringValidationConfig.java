package chkui.springcore.example.hybrid.springvalidation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import chkui.springcore.example.hybrid.springvalidation.annotation.VehicleProductionDate;
import chkui.springcore.example.hybrid.springvalidation.entity.Vehicle;
import chkui.springcore.example.hybrid.springvalidation.factory.ValidationErrorFactory;
import chkui.springcore.example.hybrid.springvalidation.factory.VehicleFactory;
import chkui.springcore.example.hybrid.springvalidation.validator.GearboxValidator;
import chkui.springcore.example.hybrid.springvalidation.validator.VehicleValidator;

@Configuration
@ComponentScan("chkui.springcore.example.hybrid.springvalidation.service")
@ImportResource("classpath:hybrid/springvalidation/config.xml")
public class SpringValidationConfig {

	@PostConstruct
	public void init() throws Exception {
		// 初始化注解上的内容
		initAnnotation();
	}

	@Bean("validator")
	public Validator validator() {
		// 添加JSR规范的校验器
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor(Validator validator) {
		// 添加针对方法参数的校验的后置处理器
		MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
		postProcessor.setValidator(validator);
		return postProcessor;
	}

	@Bean
	public VehicleValidator vehicleValidator() {
		// 添加针对Vehicle对象的校验器
		return new VehicleValidator();
	}

	@Bean
	public GearboxValidator gearboxValidator() {
		// 添加针对Gearbox对象的校验器
		return new GearboxValidator();
	}

	@Bean
	public ValidationErrorFactory validationErrorFactory() {
		return new ValidationErrorFactory();
	}

	// 动态根据列表来设置汽车生产年限
	private void initAnnotation() throws Exception {
		VehicleProductionDate annot = Vehicle.class.getDeclaredField("productionDate")
				.getAnnotation(VehicleProductionDate.class);
		InvocationHandler handler = Proxy.getInvocationHandler(annot);
		Field field = handler.getClass().getDeclaredField("memberValues");
		field.setAccessible(true);
		@SuppressWarnings("unchecked")
		Map<String, Object> memberValues = (Map<String, Object>) field.get(handler);
		memberValues.put("message", "汽车必须是" + VehicleFactory.CalendarS[2].getWeekYear() + "年之后生产");
	}
}
