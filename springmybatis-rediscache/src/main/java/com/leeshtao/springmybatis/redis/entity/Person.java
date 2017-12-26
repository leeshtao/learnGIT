package com.leeshtao.springmybatis.redis.entity;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = -4203574390718203417L;
	
	private int id;
	private String personName;
	private int age;
	private int sex;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
}
