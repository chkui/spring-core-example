package chkui.springcore.example.javabase.validation;

public class ValidationApp {

	public static void main(String[] args) {
		//IF-ELSE简单校验
		SimpleValidation.instance.validate(" ", -1);
		
		//Bean Validation 校验方法
		StandardValidation.instance.validate();
	}
}
