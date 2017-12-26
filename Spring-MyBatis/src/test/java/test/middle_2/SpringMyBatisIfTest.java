package test.middle_2;

import java.util.List;
import org.junit.Test;
import com.leeshtao.springmybatis.dao.PersonIfDao;
import com.leeshtao.springmybatis.entity.Person;
import test.Base;

public class SpringMyBatisIfTest extends Base{

	private PersonIfDao personIfDao;
	
	@Test
	public void test(){
		personIfDao = ctx.getBean("personIfDao", PersonIfDao.class);
		Person person = new Person();
		person.setPersonName("jac");
		List<Person> persons = personIfDao.getPerson(person);
		
		if (persons.isEmpty()) {
			throw new RuntimeException("The person dose not exist.");
		}
		System.out.println("============================");
		for(Person p:persons){
			System.out.println("person name:"+p.getPersonName());
		}
	}
}
