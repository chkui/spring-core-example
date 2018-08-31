package chkui.springcore.example.hybrid.springvalidation.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public interface PersonService {
	public @NotBlank String execute(@NotBlank(message = "必须设置人员名称") String name,
			@Min(value = 18, message = "年龄必须大于18") int age);
}
