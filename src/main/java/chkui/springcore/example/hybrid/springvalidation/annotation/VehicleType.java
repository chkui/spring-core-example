package chkui.springcore.example.hybrid.springvalidation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import chkui.springcore.example.hybrid.springvalidation.validator.TypeValidator;

@Constraint(validatedBy = { TypeValidator.class }) //指定校验器
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface VehicleType {
	String message() default "车辆类型只能为RPG、ACT、SLG、ARPG";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
