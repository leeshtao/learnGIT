package com.leeshtao.MyBatis.entity.basic_5.more2one;

import com.leeshtao.MyBatis.entity.basic_4.one2more.Student;

public class Mobile {

	private int id;
	private String mobileName;
	private Student student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
