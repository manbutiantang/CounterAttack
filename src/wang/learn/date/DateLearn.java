package wang.learn.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;


/**
 * @author ice
 * @date 2018年5月15日
 */
public class DateLearn {
	@Test
	public void DateConstructorSummary(){
		// Date(String s) 被 DateFormat.parse(String s)所取代		
		System.out.println("无参构造函数: "+new Date());
		System.out.println("距离格林尼治时间的毫秒数: "+new Date(1438725620));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void DateMethodSummary(){
		Date date1 = new Date();
		Date date2 = new Date(1438725620);
		System.out.println("1.当前时间是否在指定日期之后: "+date1.after(date2));
		System.out.println("2.当前时间是否在指定日期之前: "+date1.before(date2));
		System.out.println("3.克隆当前时间对象: "+date1.clone());
		System.out.println("4.如果两个时间相等返回0，当前时间大于指定时间返回大于0的值，否则返回小于0的值: "+date1.compareTo(date2));
		System.out.println("5.比较两个时间是否相等: "+date1.equals(date2));
		System.out.println("6.从一个即时对象获得一个日期实例: "+date1.from(Instant.now()));
		System.out.println("7.返回自1970年1月1日以来的毫秒数: "+date1.getTime());
		System.out.println("8.将当前日期对象转换为Instant: "+date1.toInstant());
	}
	
	@Test
	public void DateFormatMethodSummary() throws ParseException{
		/**
		 * 1.获取不同形式的DateFormat
		 */
		//对年月日格式化
		System.out.println("1.默认格式化格式: "+DateFormat.getDateInstance().format(new Date()));
		System.out.println("2.获取格式化的日期格式: "+DateFormat.getDateInstance(0).format(new Date()));
		System.out.println("3.获取格式化的日期格式: "+DateFormat.getDateInstance(1).format(new Date()));
		System.out.println("4.获取格式化的日期格式: "+DateFormat.getDateInstance(2).format(new Date()));
		System.out.println("5.获取格式化的日期格式: "+DateFormat.getDateInstance(3).format(new Date()));
		System.out.println("6.指定地区、指定时间格式: "+DateFormat.getDateInstance(2, Locale.US).format(new Date()));
		
		//区分getTimeInstance()与getDateTimeInstance()
		System.out.println("7.只获取时分秒: "+DateFormat.getTimeInstance().format(new Date()));
		System.out.println("8.获取年月日时分秒: "+DateFormat.getDateTimeInstance().format(new Date()));
		
		System.out.println("9.获取一个默认的日期/时间格式化程序: "+DateFormat.getInstance().format(new Date()));
		
		System.out.println("10.获取时区: "+DateFormat.getDateTimeInstance().getTimeZone());
		System.out.println("11.将字符串转换为date类型: "+DateFormat.getDateInstance().parse("2013-01-01"));
	}
}
