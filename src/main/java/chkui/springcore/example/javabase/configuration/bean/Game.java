package chkui.springcore.example.javabase.configuration.bean;

public class Game {
	private Cytus cytus;
	private Dva dva;
	public Game(Cytus cytus, Dva dva) {
		this.cytus = cytus;
		this.dva = dva;
	}
	public Cytus getCytus() {
		return cytus;
	}
	public Dva getDva() {
		return dva;
	}
}
