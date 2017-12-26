package com.leeshtao.MyBatis.dao.basic_1;

import java.util.List;

import com.leeshtao.MyBatis.entity.basic_1.Person;

public interface PersonDao {

	List<Person> getPersons();
	void savePerson(Person person);
	//Person getPersonById(int id);
}
