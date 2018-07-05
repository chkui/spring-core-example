package chkui.springcore.example.xml.service.impl;

import chkui.springcore.example.xml.entity.User;
import chkui.springcore.example.xml.service.UserService;

public class UserServiceImpl implements UserService {
	private User user;
	public UserServiceImpl(User user) {
		this.user = user;
	}

	@Override
	public String getUserId() {
		return this.user.getId();
	}

	@Override
	public String getUserName() {
		return this.user.getName();
	}

	@Override
	public String getUserAddress() {
		return this.user.getAddress();
	}
}
