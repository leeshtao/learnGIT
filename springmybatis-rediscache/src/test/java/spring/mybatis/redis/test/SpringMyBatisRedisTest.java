package spring.mybatis.redis.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leeshtao.springmybatis.redis.dao.PersonDao;
import com.leeshtao.springmybatis.redis.entity.Person;


public class SpringMyBatisRedisTest {

	@Inject
	PersonDao personDao;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
		personDao = ctx.getBean("personMaper",PersonDao.class);
	}
	@Test
	public void test(){
		for (int i = 0; i < 2; i++) {
			long startTime = System.currentTimeMillis();
			List<Person> persons = personDao.getPersons();
			long endTime = System.currentTimeMillis();
			
			System.out.println("第"+(i+1)+"次查询时间是： "+(endTime-startTime));
		}
		
	}
}
