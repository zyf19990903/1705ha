package com.zhengyuanfang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhengyuanfang.util.StringUtil;

@Controller
public class StringController {
	
	@RequestMapping("test.do")
	@ResponseBody
	public int test(String str, String phone, String email) {
		// 测试StringUtil工具类中的是否为中国地区手机号码isPhone()工具方法
		if (StringUtil.isMobileNumber(phone)) {
			System.out.println("手机号码合法");
		} else {
			System.out.println("手机号码不合法");
		}
		// 测试StringUtil工具类中的是否为邮箱isEmail()工具方法
		if (StringUtil.isEmail(email)) {
			System.out.println("邮箱合法");
		} else {
			System.out.println("邮箱不合法");
		}
		String s = StringUtil.toHtml(str);
		System.out.println(s);
		if("".equals(s)){
			return 0;
		}else{
			return 1;
		}
	}

}
