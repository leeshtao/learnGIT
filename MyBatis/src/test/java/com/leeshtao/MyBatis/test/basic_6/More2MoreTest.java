package com.leeshtao.MyBatis.test.basic_6;

import java.util.List;

import org.junit.Test;

import com.leeshtao.MyBatis.Base;
import com.leeshtao.MyBatis.entity.basic_6.more2more.ClassInfo;
import com.leeshtao.MyBatis.entity.basic_6.more2more.Teacher;

public class More2MoreTest extends Base{

	@Test
	public void test(){
		try {
			ClassInfo classInfo = session.selectOne("getClassInfo", 1);
			System.out.println("classInfoName:"+classInfo.getClassName());
			
			List<Teacher> teachers = classInfo.getTeachers();
			if (!teachers.isEmpty()) {
				for(Teacher t : teachers){
					System.out.println("teachername:"+t.getTeacherName());
				}
			}
		} finally {
			session.close();
		}
	}
}
