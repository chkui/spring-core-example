package chkui.springcore.example.javabase.validation.entity;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import chkui.springcore.example.javabase.validation.annotation.Price;
import chkui.springcore.example.javabase.validation.annotation.Type;
import chkui.springcore.example.javabase.validation.groups.BetaGroup;
import chkui.springcore.example.javabase.validation.payload.PayLoadLevel;

public class Game {
	
	@NotNull //非空
	@Length(min=0, max=5) //字符串长度小于5，这个是一个Hibernate Validator增加的注解
	private String name;
	
	@NotNull
	private String description;
	
	@NotNull(payload=PayLoadLevel.Error.class)
	@Min(value=0, payload=PayLoadLevel.Error.class) //最小值>=0
	@Max(value=10, payload=PayLoadLevel.Error.class) //最大值<=10
	@Max(value=0, message="未发行的游戏版本为0!", groups = BetaGroup.class, payload=PayLoadLevel.WARN.class)
	private int currentVersion; 
	
	@Price
	private float price;

	@NotNull
	@Type
	private String type;
	
	@AssertTrue(groups = BetaGroup.class, payload=PayLoadLevel.WARN.class)
	//表示是否为内侧版
	private boolean beta;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(int currentVersion) {
		this.currentVersion = currentVersion;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isBeta() {
		return beta;
	}

	public void setBeta(boolean beta) {
		this.beta = beta;
	}
}
