package com.leeshtao.springmybatis.entity;

public class Child {

	private int id;
	private String childName;
	private int personId;
	private Person person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
