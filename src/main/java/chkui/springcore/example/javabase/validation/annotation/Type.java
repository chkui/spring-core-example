package chkui.springcore.example.javabase.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import chkui.springcore.example.javabase.validation.validator.TypeValidator;

@Constraint(validatedBy = { TypeValidator.class }) //指定校验器
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Type {
	String message() default "游戏类型错误,可选类型为CAR、SUV、MPV";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
