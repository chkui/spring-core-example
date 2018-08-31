package chkui.springcore.example.javabase.configuration.bean;

public class Alice {
	private Bob bob;
	
	public Alice(Bob bob) {
		this.bob = bob;
	}
	
	public Bob getBob() {
		return bob;
	}
}
