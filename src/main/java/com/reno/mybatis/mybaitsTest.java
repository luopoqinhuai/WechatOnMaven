package com.reno.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.reno.mybatis.domain.User;

public class mybaitsTest {

	public static void ccc() {
		String resource = "conf.xml";
		InputStream is = mybaitsTest.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		
		String statement = "com.reno.mybatis.mapping.userMapper.getUser";
		User user = session.selectOne(statement, 1);

		System.out.println(user);
	}
	
	
	public static void addUser() {
		String resource = "conf.xml";
		InputStream is = mybaitsTest.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		
		String statement = "com.reno.mybatis.mapping.userMapper.addUser";
		User user=new User();
		user.setName("by chengxu");
		user.setAge(0);
		session.insert(statement, user);
		session.commit();
		session.close();
		System.out.println("insert ok");
	}

}
