package wang.learn.javalang;


import org.junit.Test;

/**
 * @author ice
 * @date 2018年5月16日
 */
public class SystemLearn {

	@Test
	public void SystemMethodSummary(){
		System.out.println(111);
		//System.exit(1); //终止当前运行的java虚拟机
		System.out.println("1.以毫秒为单位返回当前时间: "+System.currentTimeMillis());
		System.out.println("2.获得所有环境变量的值: "+System.getenv());
		System.out.println("3.获得指定环境变量的值: "+System.getenv("JAVA_HOME"));
		System.out.println("4.获取系统属性:"+System.getProperties());
		System.out.println("5.获取指定的系统属性"+System.getProperty("os.name"));
	}
	
	@Test
	public void RunTimeMethodSummary(){
		System.out.println("1.返回Java虚拟机中的空闲内存数量: "+Runtime.getRuntime().freeMemory());
	}
}
