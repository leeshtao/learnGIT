package test;


import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leeshtao.cloudnote.user.entity.User;
import com.leeshtao.cloudnote.user.handler.UserService;

import util.Object2JSON;



public class TestUserService {
	private static UserService service;
	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		service = ac.getBean("userService", UserService.class);
	}
	@Test
	//预期:用户名错误
	public void test1() {
		User user = service.login("zhangsan", "123");
	}
	
	@Test
	//预期:密码错误
	public void test2() {
		User user = service.login("demo", "123");
	}
	
	@Test
	//预期:登录成功
	public void test3() {
		User user = service.login("list", "pass1234");
		System.out.println(Object2JSON.object2JSON(user));
	}
	
	@Test
	//注册新用户
	public void test4(){
		User user = service.regist("list1", "pass1234", "list");
		System.out.println(Object2JSON.object2JSON(user));
	}
	
	@Test
	//注销用户
	public void test5(){
		service.cancelUser("list1");
	}
}





