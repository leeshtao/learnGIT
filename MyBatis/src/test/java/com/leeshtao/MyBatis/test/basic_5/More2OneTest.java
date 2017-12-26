package com.leeshtao.MyBatis.test.basic_5;

import org.junit.Test;

import com.leeshtao.MyBatis.Base;
import com.leeshtao.MyBatis.entity.basic_4.one2more.Student;
import com.leeshtao.MyBatis.entity.basic_5.more2one.Mobile;

public class More2OneTest extends Base{

	@Test
	public void test(){
		try {
			Mobile mobile = session.selectOne("getMobile", 2);
			System.out.println("mobileName:"+mobile.getMobileName());
			
			Student student = mobile.getStudent();
			System.out.println("studentName:"+student.getStudentName());
		} finally {
			session.close();
		}
	}
}
