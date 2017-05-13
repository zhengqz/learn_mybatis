package com.hz.first;

import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hz.po.User;

public class First {

	@Test
	public void findUserByIdTest() throws IOException {

		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		User user = session.selectOne("test.findUserById", 1);
		System.out.println(user);

		session.close();
	}
	
	@Test
	public void findUserByNameTest() throws IOException {
		// TODO Auto-generated method stub
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users = session.selectList("test.findUserByName","test");
		System.out.println(users);
		session.close();
	}
	
	@Test
	public void insertUser() throws IOException {
		// TODO Auto-generated method stub
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("王小军");
		user.setAddress("hz_gs");
		user.setSex(1);
		user.setBirthday(new Date());
		user.setEmail("xioajun_wang@126.com");
		user.setPassword("123456");
		session.insert("test.insertUser",user);
		System.out.println(user.getUuid());
		session.commit();
		session.close();
	}
	
	@Test
	public void deleteUser() throws IOException {

		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		session.delete("test.deleteUser", 8);
		session.commit();

		session.close();
	}
	
	@Test
	public void updateUser() throws IOException {

		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		User user = new User();
		user.setId(7);
		user.setUsername("王小军");
		user.setAddress("hz_bj");
		user.setSex(1);
		user.setBirthday(new Date());
		user.setEmail("xioajun_wang@126.com");
		user.setPassword("123456");
		
		session.update("test.updateUser", user);
      session.commit();

		session.close();
	}
}
