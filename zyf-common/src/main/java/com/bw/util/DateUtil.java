package com.bw.util;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//		https://www.imooc.com/article/41686    工具类地址
/**
日期工具类:
	1.	根据日期算年龄
	2.	求未来日期离今天还剩的天数	
	3.	求过去日期离今天还剩的天数	
	4.	判断给定的日期是否为今天
	5.	判断给定的日期是否在本周之内
	6.	判断给定的日期是否在本月之内
	7.	给定时间对象，初始化到该月初的1月1日0时0分0秒0毫秒		
	8.	给定时间对象，设定到该月最一天的23时59分59秒999毫秒	
	9.	时间比较	
    @author zyf
 */
public class DateUtil {
	
	
	
	 /**
     * 计算两个日期之间相差的周年数，忽略时间
     * 根据日期算年龄
     * @param startDate
     * @param endDate
     * @return
     */
	
		public static int getAge(Calendar target) {
			   int age = 0;
			   // 日期初始化
		        Calendar cal = Calendar.getInstance();
		        if (cal.before(target)) { //出生日期晚于当前时间，无法计算
		            throw new IllegalArgumentException(
		                    "The birthDay is before Now.It's unbelievable!");
		        }
		        
		        int yearNow = cal.get(Calendar.YEAR);  //当前年份
		        int monthNow = cal.get(Calendar.MONTH);  //当前月份
		        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期  月中的日
		        
		        
		        int yearBirth = target.get(Calendar.YEAR); // 获取参数的年份
		        int monthBirth = target.get(Calendar.MONTH);// 获取参数的月份
		        int dayOfMonthBirth = target.get(Calendar.DAY_OF_MONTH);//// 获取参数的日期
		        
		        age = yearNow - yearBirth;   //计算整岁数
		        if (monthNow <= monthBirth) {
		            if (monthNow == monthBirth) {
		                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
		            } else {
		                age--;//当前月份在生日之前，年龄减一
		            }
		        }
		        return age;
		}
	
    /**
     *  日期转换字符串工具类
     * @param date
     * @param pattern    设置转换后的日期格式(yyyy-MM-dd HH:mm:ss)
     * @return
     */
	public static String dateToString(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	
	
	/**
     * 字符串转日期 
     * @param dateString   日期的字符串格式
     * @param format  	        日期格式   
     * @return
     */
    public static Date stringToDate(String dateString, String format){
        if(dateString == null) {
            throw new InvalidParameterException("dateString cannot be null!");
        }
        try {
            return new SimpleDateFormat(format).parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("parse error! [dateString:"+ dateString +";format:"+ format +"]");
        }
    }
	
	
}
