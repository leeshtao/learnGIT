package com.leeshtao.springmybatis.redis.dao;

import java.util.List;
import com.leeshtao.springmybatis.redis.entity.Person;

public interface PersonDao {

	List<Person> getPersons();
	void savePerson(Person person);
}
