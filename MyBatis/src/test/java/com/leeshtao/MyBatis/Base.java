package com.leeshtao.MyBatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import com.leeshtao.MyBatis.entity.basic_1.Person;

public class Base {

	protected static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	protected static SqlSession session;
	@Before
	public void init(){
		try {
			reader = Resources.getResourceAsReader("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
