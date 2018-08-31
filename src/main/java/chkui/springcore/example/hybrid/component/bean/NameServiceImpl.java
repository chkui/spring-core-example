package chkui.springcore.example.hybrid.component.bean;
import org.springframework.stereotype.Service;

@Service("implementNameService")
public class NameServiceImpl implements NameService{
	@Override
	public String getName() {
		return "This is My Component";
	}
}