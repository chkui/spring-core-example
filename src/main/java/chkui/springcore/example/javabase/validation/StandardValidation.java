package chkui.springcore.example.javabase.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import chkui.springcore.example.javabase.validation.entity.Game;
import chkui.springcore.example.javabase.validation.groups.BetaGroup;

public enum StandardValidation {
	instance;
	public void validate() {
		System.out.println("2. StandardValidation");
		System.out.println("");
		//引入校验工具
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Game wow = new Game();
		Set<ConstraintViolation<Game>> violationSet = validator.validate(wow);
		System.out.println("a) null check:");
		System.out.println();
		violationSet.forEach(violat -> {
			System.out.println(violat.getPropertyPath() + ":" + violat.getMessage());
		});
		wow.setName("World Of Warcraft");
		wow.setDescription("由著名游戏公司暴雪娱乐所制作的第一款网络游戏，属于大型多人在线角色扮演游戏。");
		wow.setCurrentVersion(8);
		wow.setType("RPG");
		wow.setPrice(401.01F);
		violationSet = validator.validate(wow);
		System.out.println();
		System.out.println("b) with data check 1:");
		violationSet.forEach(violat -> {
			System.out.println(violat.getPropertyPath() + ":" + violat.getMessage());
		});
		wow.setName("WOW");
		violationSet = validator.validate(wow);
		System.out.println();
		System.out.println("c) with data check 2:");
		violationSet.forEach(violat -> {
			System.out.println(violat.getPropertyPath() + ":" + violat.getMessage());
		});
		
		//分组校验
		violationSet = validator.validate(wow, BetaGroup.class);
		System.out.println();
		System.out.println("d) group check with payload:");
		violationSet.forEach(violat -> {
			System.out.println(violat.getPropertyPath() + ":" + violat.getMessage());
			System.out.println(violat.getConstraintDescriptor().getPayload());
		});
		
		System.out.println("=======================================================");
	}
}
