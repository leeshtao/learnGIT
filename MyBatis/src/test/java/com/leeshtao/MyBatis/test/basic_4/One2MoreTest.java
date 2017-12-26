package com.leeshtao.MyBatis.test.basic_4;

import java.util.List;

import org.junit.Test;
import com.leeshtao.MyBatis.Base;
import com.leeshtao.MyBatis.entity.basic_3.one2one.Course;
import com.leeshtao.MyBatis.entity.basic_4.one2more.Student;

public class One2MoreTest extends Base{

	@Test
	public void test(){
		try {
			Student student = session.selectOne("getStudent", 1);
			if (student != null) {
				System.out.println("studentName:"+student.getStudentName());
				System.out.println("course size:"+student.getCourses().size());
				
				List<Course> courses = student.getCourses();
				if(courses.size()!=0){
					for(Course course : courses){
						System.out.println("courseName:"+course.getCourseName());
					}
				}
			}
			
		} finally {
			session.close();
		}
		
	}
}
