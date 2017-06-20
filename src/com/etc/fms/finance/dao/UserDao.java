package com.etc.fms.finance.dao;

import java.util.List;

import com.etc.fms.user.entity.User;

public interface UserDao {
	public int saveUser(User u) throws Exception;

	public User getUser(String loginname, String password) throws Exception;

	public List<User> getUsers(String lognname, String username)
			throws Exception;

	public int delUser(int uid) throws Exception;
}
