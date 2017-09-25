package com.unmi.login.service.impl;

import com.unmi.login.service.Validator;

public class DbValidatorBundle implements Validator {

	@Override
	public boolean validate(String username, String password) throws Exception {
		System.out.println("使用Db进行登录验证");
		System.out.println("username：" + username + "=====password：" + password);
		if ("cy".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)) {
			return true;
		} else {
			return false;
		}
	}

}
