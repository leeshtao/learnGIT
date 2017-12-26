package com.leeshtao.MyBatis.test.basic_3;

import org.junit.Test;

import com.leeshtao.MyBatis.Base;
import com.leeshtao.MyBatis.entity.basic_3.one2one.Catalog;
import com.leeshtao.MyBatis.entity.basic_3.one2one.Course;

public class One2OneTest extends Base{

	@Test
	public void test(){
		try {
			Course course = session.selectOne("getCourse", 3);
			System.out.println("courseName:"+course.getCourseName());
			
			Catalog catalog = course.getCatalog();
			System.out.println("catalogName:"+catalog.getCatalogName());
		} finally {
			session.close();
		}
		
	}
	
}
