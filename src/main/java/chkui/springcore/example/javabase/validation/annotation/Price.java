package chkui.springcore.example.javabase.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Min(1)//最小值>=1
@Max(300)//最大值<=300
@Constraint(validatedBy = {}) //不制定校验器
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Price {
	String message() default "定价必须在$1~$200之间";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
