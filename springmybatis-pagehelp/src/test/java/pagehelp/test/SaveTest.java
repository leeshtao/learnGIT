package pagehelp.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leeshtao.springmybatis.pagehelper.dao.PersonPageDao;
import com.leeshtao.springmybatis.pagehelper.entity.Person;


public class SaveTest {

	private static PersonPageDao pageDao;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		pageDao = ac.getBean("personPageMaper", PersonPageDao.class);
	}

	@Test
	public void savePersonTest(){
		Person person = new Person();
		for(int i=0; i<1000000; i++){
			person.setPersonName("jackson"+(i+1));
			person.setAge(19+i);
			person.setSex(0);
			if (i%3==0) {
				person.setSex(1);
			}
			pageDao.savePerson(person);
		}
	}
}
