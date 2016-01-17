package com.wb.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录接口
 * @author wb
 */
@Controller
@RequestMapping(value="login")
public class LoginController {
	
	/**
	 * 跳转至登录页面
	 * @return
	 */
	@RequestMapping(value="forLoginJsp")
	public String forLoginJsp() {
		return "login/login";
	}
}
