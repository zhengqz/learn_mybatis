package com.hz.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hz.po.User;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated constructor stub
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", 1);
		session.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("test.insertUser", user);
		session.commit();
		session.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test.deleteUser", id);
		session.commit();
		session.close();
	}

}
