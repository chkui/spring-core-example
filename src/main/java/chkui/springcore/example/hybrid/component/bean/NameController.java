package chkui.springcore.example.hybrid.component.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NameController {
	@Autowired
	private NameService nameService;

	public NameService getNameService() {
		return nameService;
	}

	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}
}
