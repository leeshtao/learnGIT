package com.leeshtao.MyBatis.test.basic_2;


import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.leeshtao.MyBatis.Base;
import com.leeshtao.MyBatis.entity.basic_1.Person;

public class Test2 extends Base{

	@Test
	public void saveTest(){
		System.out.println("\nTest insert start...");
		Person person = new Person();
		person.setAge(22);
		person.setPersonName("lisi");
		person.setSex(1);
		session.insert("savePerson", person);
		session.commit();
		System.out.println("\nTest insert finished...");
	}
	
	@Test
	public void updateTest(){
		System.out.println("\nTest update start...");
		Person person = session.selectOne("getPersonById", 1);
		person.setAge(25);
		session.update("updatePerson",person);
		session.commit();
		System.out.println("\nTest update finished...");
	}
	
	@Test
	public void deletePersonTest(){
		System.out.println("\nTest delete start...");
		session.delete("deletePerson", 2);
		session.commit();
		System.out.println("\nTest delete finished...");
	}
	
	@After
	public void getPersons(){
		System.out.println("\nTest Get start ...");
		List<Person> persons = session.selectList("getPersons");
		printPersons(persons);
		
	}
	
	private static void printPersons(final List<Person> persons){
		int count = 0;
		for(Person person : persons){
			System.out.println("=============Person"+(++count)+"=============");
			System.out.println("personId:"+person.getId());
			System.out.println("personName:"+person.getPersonName());
			System.out.println("age:"+person.getAge());
			System.out.println("sex:"+person.getSex());
		}
	}
}



