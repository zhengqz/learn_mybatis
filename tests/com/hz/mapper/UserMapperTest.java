package com.hz.mapper;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hz.po.User;
import com.hz.po.UserCustom;
import com.hz.po.UserQueryVo;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream config = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
	}

//	@Test
//	public void testFindUserById() throws Exception {
//		SqlSession session = sqlSessionFactory.openSession();
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		User user = userMapper.findUserById(1);
//		session.close();
//		System.out.println(user);
//	}
	
	@Test
	public void testFindUserList() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(7);
	    ids.add(9);
		userCustom.setSex(1);
//		userCustom.setUsername("王小军");
		userQueryVo.setUserCustom(userCustom);
		userQueryVo.setIds(ids);
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
		session.close();
	}
	
//	@Test
//	public void testFindUserCount() throws Exception{
//		SqlSession session = sqlSessionFactory.openSession();
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		
//		UserQueryVo userQueryVo = new UserQueryVo();
//		UserCustom userCustom = new UserCustom();
//		userCustom.setSex(1);
//		userCustom.setUsername("王小军");
//		userQueryVo.setUserCustom(userCustom);
//		int count = userMapper.findUserCount(userQueryVo);
//		System.out.println(count);
//	}
//	
//	@Test
//	public void testFindUserByIdResultMap() throws Exception {
//		SqlSession session = sqlSessionFactory.openSession();
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		User user = userMapper.findUserByIdResultMap(1);
//		session.close();
//		System.out.println(user);
//	}

}
