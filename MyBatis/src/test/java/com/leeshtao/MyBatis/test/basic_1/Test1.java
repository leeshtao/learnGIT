package com.leeshtao.MyBatis.test.basic_1;

import org.junit.Test;

import com.leeshtao.MyBatis.Base;
import com.leeshtao.MyBatis.entity.basic_1.Person;

public class Test1 extends Base{

	@Test
	public void test(){
		
		/*
		 * session.selectOne(String statement, Object parameter)
		 * statement:SQL语句的id
		 * parameter:对应的是SQL语句的参数
		 * 
		 * 调用此方法,就不需要对应的dao.
		 */
		Person person = session.selectOne("getPersonById", 1);
		if (person != null) {
			System.out.println("personId:"+person.getId());
			System.out.println("personNmae:"+person.getPersonName());
			System.out.println("age:"+person.getAge());
			System.out.println("sex:"+person.getSex());
		}
	}
}
