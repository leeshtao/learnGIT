package com.leeshtao.springmybatis.pagehelper.dao;

import java.util.List;

import com.leeshtao.springmybatis.pagehelper.entity.Person;

public interface PersonPageDao {

	List<Person> getPersons();
	void savePerson(Person person);
}
