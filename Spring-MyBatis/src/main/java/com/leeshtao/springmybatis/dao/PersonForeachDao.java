package com.leeshtao.springmybatis.dao;

import java.util.List;
import com.leeshtao.springmybatis.entity.Person;

public interface PersonForeachDao {

	List<Person> getPerson(List<Integer> id);
}
