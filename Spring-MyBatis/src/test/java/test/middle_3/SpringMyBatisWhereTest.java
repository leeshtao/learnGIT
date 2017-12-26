package test.middle_3;

import java.util.List;
import org.junit.Test;
import com.leeshtao.springmybatis.dao.PersonWhereDao;
import com.leeshtao.springmybatis.entity.Person;
import test.Base;

public class SpringMyBatisWhereTest extends Base{

	private PersonWhereDao personWhereDao;
	
	@Test
	public void test(){
		personWhereDao = ctx.getBean("personWhereDao", PersonWhereDao.class);
		Person person = new Person();
		person.setPersonName("jac");
		person.setId(4);
		List<Person> persons = personWhereDao.getPerson(person);
		
		if (persons.isEmpty()) {
			throw new RuntimeException("The person dose not exist.");
		}
		System.out.println("============================");
		for(Person p:persons){
			System.out.println("person name:"+p.getPersonName());
		}
	}
}
