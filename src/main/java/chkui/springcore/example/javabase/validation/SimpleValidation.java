package chkui.springcore.example.javabase.validation;

public enum SimpleValidation {
	instance;
	public String validate(String inputString, Integer inputInt) {
		System.out.println("=======================================================");
		System.out.println("1. Simple Validation");
		String error = null;
		if (null == inputString) {
			error = "inputString不能为null";
		} else if (null == inputInt) {
			error = "inputInt不能为null";
		} else if (1 > inputInt.compareTo(0)) {
			error = "inputInt必须大于0";
		} else if (inputString.isEmpty() || inputString.trim().isEmpty()) {
			error = "inputString不能为空字符串";
		} else {
			// DO
		}
		System.out.println(error);
		System.out.println("=======================================================");
		return error;
	}
}
