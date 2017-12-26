package test.middle_6;

import java.util.List;
import org.junit.Test;
import com.leeshtao.springmybatis.dao.PersonChooseDao;
import com.leeshtao.springmybatis.entity.Person;
import test.Base;

public class SpringMyBatisChooseTest extends Base{

	private PersonChooseDao personChooseDao;
	
	@Test
	public void test(){
		personChooseDao = ctx.getBean("personChooseDao", PersonChooseDao.class);
		Person person2 = new Person();
		person2.setId(4);
		person2.setPersonName("");
		List<Person> persons = personChooseDao.getPerson(person2);
		if (persons.isEmpty()) {
			throw new RuntimeException("The person dose not exist.");
		}
		for(Person p : persons){
			System.out.println("person name:"+p.getPersonName());
		}
	}
}
