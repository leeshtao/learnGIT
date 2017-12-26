package test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Base {

protected ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("config/spring-mybatis.xml");
	}
}
