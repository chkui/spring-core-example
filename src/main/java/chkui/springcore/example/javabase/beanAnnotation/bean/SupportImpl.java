package chkui.springcore.example.javabase.beanAnnotation.bean;

public class SupportImpl implements Support {
	private FinalFantasy ff; 

	@Override
	public void setFinalFantasy(FinalFantasy ff) {
		this.ff = ff;
	}

	@Override
	public FinalFantasy getFinalFantasy() {
		return ff;
	}
}
