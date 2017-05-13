package com.hz.mapper;

import java.util.List;

import com.hz.po.User;
import com.hz.po.UserCustom;
import com.hz.po.UserQueryVo;

/*
 * mapper 接口，相当于dao接口
 */
public interface UserMapper {

	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

	public User findUserByIdResultMap(int id) throws Exception;

	public User findUserById(int id) throws Exception;

	public void deleteUser(int id) throws Exception;
}
