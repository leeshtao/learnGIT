package test.middle_4;

import org.junit.Test;
import com.leeshtao.springmybatis.dao.PersonSetDao;
import com.leeshtao.springmybatis.entity.Person;
import test.Base;

public class SpringMyBatisSetTest extends Base{

	private PersonSetDao personSetDao;
	
	@Test
	public void test(){
		personSetDao = ctx.getBean("personSetDao", PersonSetDao.class);
		Person person = new Person();
		person.setPersonName("¸ÄÃû×ÖÎªJack");
		person.setId(4);
		
		personSetDao.updatePerson(person);
	}
}
