package com.hz.mapper;

import com.hz.po.User;

/*
 * mapper 接口，相当于dao接口
 */
public interface UserMapper {
	
	public User findUserById(int id) throws Exception;
	
	public void deleteUser(int id) throws Exception;
}
