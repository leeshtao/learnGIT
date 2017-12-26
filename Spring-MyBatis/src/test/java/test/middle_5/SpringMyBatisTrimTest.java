package test.middle_5;

import java.util.List;

import org.junit.Test;
import com.leeshtao.springmybatis.dao.PersonTrimDao;
import com.leeshtao.springmybatis.entity.Person;
import test.Base;

public class SpringMyBatisTrimTest extends Base{

	private PersonTrimDao personTrimDao;
	
	@Test
	public void test(){
		personTrimDao = ctx.getBean("personTrimDao", PersonTrimDao.class);
		Person person = new Person();
		person.setPersonName("¸ÄÃû×ÖÎªMicle Jack");
		person.setId(5);
		personTrimDao.updatePerson(person);
		
		Person person2 = new Person();
		person2.setId(4);
		person2.setPersonName("jacks");
		List<Person> persons = personTrimDao.getPerson(person2);
		if (persons.isEmpty()) {
			throw new RuntimeException("The person dose not exist.");
		}
		for(Person p : persons){
			System.out.println("person name:"+p.getPersonName());
		}
	}
}
