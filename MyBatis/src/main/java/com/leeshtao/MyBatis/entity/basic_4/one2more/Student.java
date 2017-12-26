package com.leeshtao.MyBatis.entity.basic_4.one2more;

import java.util.List;

import com.leeshtao.MyBatis.entity.basic_3.one2one.Course;

public class Student {

	private int id;
	private String studentName;
	private List<Course> courses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
