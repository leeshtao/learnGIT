package test.middle_1;

import java.util.List;

import org.junit.Test;

import com.leeshtao.springmybatis.dao.PersonDao;
import com.leeshtao.springmybatis.entity.Child;
import com.leeshtao.springmybatis.entity.Person;

import test.Base;

public class SpringMyBatisBasicTest extends Base{

	private PersonDao personDao;
	
	@Test
	public void test(){
		personDao = ctx.getBean("personDao",PersonDao.class);
		Person person = personDao.getPersonById(1);
		if (person != null) {
			System.out.println("person name:"+person.getPersonName());
		}else {
			throw new RuntimeException("The person does not exist.");
		}
		
		System.out.println("=====================================");
		List<Child> childs = personDao.getChildByPerson(person.getId());
		if (childs.isEmpty() ) {
			throw new RuntimeException("The child does note exist.");
		}
		for(Child c : childs){
			System.out.println("child name:"+c.getChildName());
		}
	}
	
}
