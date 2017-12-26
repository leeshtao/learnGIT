package com.leeshtao.springmybatis.dao;

import java.util.List;

import com.leeshtao.springmybatis.entity.Child;
import com.leeshtao.springmybatis.entity.Person;

public interface PersonDao {

	Person getPersonById(int personId);
	List<Child> getChildByPerson(int personId);
}
