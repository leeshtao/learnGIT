package com.leeshtao.springmybatis.dao;

import java.util.List;
import com.leeshtao.springmybatis.entity.Person;

public interface PersonTrimDao {

	void updatePerson(Person person);
	List<Person> getPerson(Person person);
}
