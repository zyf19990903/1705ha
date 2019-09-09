package com.zhengyuanfang.util;


public class StringUtil {
	
	/**
	 * 判断源字符串是否有值(null)，空引号("")也算没值 , 空格字符也算没值("   ")
	 */
	public static boolean isNullOrEmpty(String str){
		if (str==null || "".equals(str.trim()) || "null".equals(str.trim()) ){
			return true;
		}
		return false;
	}
	

	/**
	 * 判断是否为手机号码
	 */
	public static boolean isMobileNumber(String mobile){
		return mobile.matches("^1[3|4|5|7|8]\\d{9}$");
	}
	
	
	/**
	 * 判断是否为电子邮箱
	 */
	public static boolean isEmail(String email){
		return email.matches("\\w+@(\\w+\\.)+[a-z]{2,3}"); 
	}
	
	public static String toHtml(String text) {
		//a)后台需要通过hasText()工具方法验证前端提交的值不能空，而且空白字符串也不行。（4分）
		if(!isNullOrEmpty(text)){
			text = text.replaceAll("\\n", "<p></p>");
			text = text.replaceAll("\\n\\r", "<p></p>");
			text = text.replaceAll("\\r", "<br/>");
			String[] split = text.split("\\|");
			String a= "";
			for (String string : split) {
				String q = string.replaceAll("<p>", "");
				q = "<p>"+q;
				a+=q;
			}
			return a;
		}
		return "";
	}
}
