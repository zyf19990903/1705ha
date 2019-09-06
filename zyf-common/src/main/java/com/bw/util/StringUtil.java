package com.bw.util;

import java.util.Random;


/**
 * @author zyf
 *
 * 2019年9月6日
 */
public class StringUtil {
	private StringUtil (){};//私有化构造
	
	/**
	 * 判断源字符串是否有值(null)，空引号("")也算没值
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		//"" 在内存开辟内存空间  null 没有开辟内存空间
		return str !=null && !"".equals(str);//有值为true
	}
	
	/**
	 * 判断源字符串是否有值，空引号和空格也算没值
	 */
	public static boolean isEmptyandSpace(String str) {
		//"" 在内存开辟内存空间  null 没有开辟内存空间
		return str!=null&&!"".equals(str.trim());//有值为true
	}
	
	/**
	 * 判断是否为手机号码
	 */
	public static boolean isPhoneNum(String phone) {
		if(!isEmpty(phone)) {
			return false;
		}
		String reg="^1[3|4|5|7|8]\\d{9}$";
		// 正则验证   
		boolean matches = phone.matches(reg);
		return matches;
	}
	
	/**
	 *判断是否为电子邮箱
	 */
	public static boolean isEmail(String email) {
		if(!isEmpty(email)) {
			return false;
		}
		//\\w+@(\\w+\\.)+[a-z]{2,3}
		String reg="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		// 正则验证   
		boolean matches = email.matches(reg);
		return matches;
	}
	
	/**
	 *判断是否全部为字母
	 */
	public static boolean isLetter(String letter) {
		if(!isEmpty(letter)) {
			return false;
		}
		String reg="[a-zA-Z]+";
		boolean matches = letter.matches(reg);
		return matches;
	}
	
	/**
	 * 获取n位随机英文字符串
	 * @param n
	 * @return
	 */
	public static String getRandomString(int n) {
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<n; i++) {
			char randomChar = (char)((Math.random()*58)+65);
			randomChar = randomChar > 90 && randomChar < 97 ? (char)(randomChar + 8) : randomChar;
			buffer.append(randomChar);
		}
		
		return buffer.toString();
	}
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @param n
	 * @return
	 */
	public static String getNumStringRandom(int n){
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i <n; i++) {
			String randString =  random.nextInt(2)%2==0?"char":"num";
			
			if("char".equals(randString)){
				
				String randomString = getRandomString(1);
				sb.append(randomString);
				
			}else if("num".equals(randString)){
				
				String numRandom = getNumRandom(1);
				sb.append(numRandom);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 生成随机数字 
	 * @param length
	 * @return
	 */
	public static String getNumRandom(int length) {  
        String val = "";  
        Random random = new Random();  
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
            val += String.valueOf(random.nextInt(10));  
        }  
        return val;  
    }
	
	 /**
     * 获取n个随机中文字符串
     * @param n		需要获取字符串长度
     * @return
     */
	public static String genChineseString(int n) {
		StringBuffer buffer = new StringBuffer();
		int start = Integer.valueOf("4e00", 16);
		int end = Integer.valueOf("9fa5", 16);
		// 生成中文字符的算法如下：
		for (int i=0; i < n; i++) {
			char randomChar = (char)((Math.random()*(end-start+1))+start);
			buffer.append(randomChar);
		}
		
		return buffer.toString();
	}
	
	
	/**
	 * 判断是否是数字
	 * @param src 
	 * @return
	 */
	public static boolean isNumber(String src) {
		boolean result = false;
		
		try {
			double number = Double.valueOf(src);
			result = true;
		} catch (NumberFormatException e) {
			result = false;
		}
		
		return result;
	}
	
	
	
}
