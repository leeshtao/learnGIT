package com.leeshtao.springmybatis.dao;

import java.util.List;
import com.leeshtao.springmybatis.entity.Person;

public interface PersonIfDao {

	List<Person> getPerson(Person person);
}
