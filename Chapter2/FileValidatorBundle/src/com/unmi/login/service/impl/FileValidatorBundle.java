package com.unmi.login.service.impl;

import com.unmi.login.service.Validator;

public class FileValidatorBundle implements Validator {

	@Override
	public boolean validate(String username, String password) throws Exception {
		System.out.println("使用File进行登录验证");
		System.out.println("username：" + username + "=====password：" + password);
		if ("cy".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)) {
			return true;
		} else {
			return false;
		}
	}

}
