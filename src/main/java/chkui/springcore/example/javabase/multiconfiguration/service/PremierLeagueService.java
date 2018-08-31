package chkui.springcore.example.javabase.multiconfiguration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chkui.springcore.example.javabase.multiconfiguration.bean.Cfc;
import chkui.springcore.example.javabase.multiconfiguration.bean.Mau;

@Service
public class PremierLeagueService {
	@Autowired
	private Mau mau;
	
	@Autowired
	private Cfc cfc;

	public Mau getMau() {
		return mau;
	}

	public Cfc getCfc() {
		return cfc;
	}

	@Override
	public String toString() {
		return "Premier League Club:" + mau + ", " + cfc + "";
	}
}
