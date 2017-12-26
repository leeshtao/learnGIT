package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leeshtao.cloudnote.user.dao.UserDao;
import com.leeshtao.cloudnote.user.entity.User;

import util.Object2JSON;


public class TestUserDao {
	@Test
	public void testFindUserByName(){
		ApplicationContext ctx
			=new ClassPathXmlApplicationContext(
				 "conf/*.xml");
		UserDao dao=ctx.getBean(
				"userDao", UserDao.class);
		User user=dao.findUserByName("demo1");
		if(user!=null){
			System.out.println(Object2JSON.object2JSON(user));
		}else{
			System.out.println("用户不存在");
		}
	}
	@Test
	public void testAddUser(){
		ApplicationContext ctx
			=new ClassPathXmlApplicationContext(
					"conf/spring-mybatis.xml");
		UserDao dao
			=ctx.getBean("userDao", UserDao.class);
		User user=new User();
		user.setCnUserName("老司机");
		user.setCnUserPassword("123456");
		user.setCnUserNick("带你飞");
		dao.addUser(user);
	}
}












