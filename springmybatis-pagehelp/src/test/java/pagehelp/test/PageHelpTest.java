package pagehelp.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leeshtao.springmybatis.pagehelper.dao.PersonPageDao;
import com.leeshtao.springmybatis.pagehelper.entity.Person;

public class PageHelpTest {

	@Inject
	PersonPageDao pageDao;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		pageDao = (PersonPageDao) ctx.getBean("personPageMaper");
	}

	@Test
	public void test() {
		
		/*
		 * PageHelper.startPage(int pageNum, int pageSize)
		 * pageNum:查询第几页
		 * pageSize:每一页的数据个数
		 */
		//通过PageHelper插件设置分页的信息，下边是查询第2页，每一页4条数据
		PageHelper.startPage(2, 4);
		//插件下边的查询就是就能拦截进行分页了，可以看出对原来的查询方法没有增加任何额外代码
		List<Person> persons = pageDao.getPersons();
		 System.out.println("本次查询的person个数：" + persons.size());
		for (Person person : persons) {
			System.out.println("person info start ========================");
			System.out.println("person name: "+person.getPersonName() );
			System.out.println("person age: "+person.getAge() );
			System.out.println("person sex: "+person.getSex() );
			System.out.println("person info end  +++++++++++++++++++++++++");
		}
		
		// 取分页信息
        PageInfo<Person> pageInfo = new PageInfo<Person>(persons);
        //获取总记录数
        long total = pageInfo.getTotal(); 
        System.out.println("数据库中person的总数：" + total);
		
	}
	
	@Test
	public void test1(){
		for (int i = 0; i < 2; i++) {
			long startTime = System.currentTimeMillis();
			List<Person> persons = pageDao.getPersons();
			long endTime = System.currentTimeMillis();
			
			System.out.println("第"+(i+1)+"次查询时间是： "+(endTime-startTime));
		}
		
	}
}
