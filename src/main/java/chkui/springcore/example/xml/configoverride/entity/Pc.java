package chkui.springcore.example.xml.configoverride.entity;

public class Pc {
	private Cpu cpu;
	private Graphics graphics;
	private Ram ram;

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Graphics getGraphics() {
		return graphics;
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Pc [cpu=" + cpu.getBrand() + ", graphics=" + graphics.getBrand() + ", ram=" + ram.getBrand() + "]";
	}
}
