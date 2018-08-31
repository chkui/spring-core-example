package chkui.springcore.example.javabase.multiconfiguration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chkui.springcore.example.javabase.multiconfiguration.bean.Jav;
import chkui.springcore.example.javabase.multiconfiguration.bean.Mil;

@Component
public class SerieAService {
	@Autowired
	private Mil mil;
	@Autowired
	private Jav jav;
	public Mil getMil() {
		return mil;
	}
	
	public Jav getJav() {
		return jav;
	}

	@Override
	public String toString() {
		return "Serie A Club:" + mil + ", " + jav + "";
	}
}
