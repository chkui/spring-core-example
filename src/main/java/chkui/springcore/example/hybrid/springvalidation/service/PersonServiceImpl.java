package chkui.springcore.example.hybrid.springvalidation.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PersonServiceImpl implements PersonService {

	@Override
	public String execute(String name, int age) {
		return "I'm " + name + ". " + age + " years old.";
	}
}
