package com.leeshtao.MyBatis.entity.basic_6.more2more;

import java.util.List;

public class Teacher {

	private int id;
	private String teacherName;
	private List<ClassInfo> classInfos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public List<ClassInfo> getClassInfos() {
		return classInfos;
	}
	public void setClassInfos(List<ClassInfo> classInfos) {
		this.classInfos = classInfos;
	}
	
	
}
