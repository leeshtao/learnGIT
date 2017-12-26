package com.leeshtao.MyBatis.entity.basic_6.more2more;

import java.util.List;

public class ClassInfo {

	private int id;
	private String className;
	private List<Teacher> teachers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
