package test.middle_7;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.leeshtao.springmybatis.dao.PersonForeachDao;
import com.leeshtao.springmybatis.entity.Person;
import test.Base;

public class SpringMyBatisForeachTest extends Base{

	private PersonForeachDao personForeachDao;
	
	@Test
	public void test(){
		personForeachDao = ctx.getBean("personForeachDao", PersonForeachDao.class);
		List ids = new ArrayList();
		ids.add(1);
		ids.add(5);
		ids.add(10);
		List<Person> persons = personForeachDao.getPerson(ids);
		if (persons.isEmpty()) {
			throw new RuntimeException("The person dose not exist.");
		}
		for(Person p : persons){
			System.out.println("person name:"+p.getPersonName());
		}
	}
}
