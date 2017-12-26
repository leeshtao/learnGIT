package com.leeshtao.springmybatis.dao;

import java.util.List;
import com.leeshtao.springmybatis.entity.Person;

public interface PersonChooseDao {

	List<Person> getPerson(Person person);
}
