package com.etc.fms.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.fms.admin.service.IAdminService;
import com.etc.fms.user.dao.UserMapper;
import com.etc.fms.user.entity.User;


@Service("adminService")
public class AdminService implements IAdminService {

	@Resource(name = "userDao")
	private UserMapper adminUser;

	public User selByNameAndPwd(User user) {
		return adminUser.selByNameAndPwd(user);
	}

	public List<User> queryAllUser() {
		
		return adminUser.queryAllUser();
	}

	public void deleteByPrimaryKey(Integer uid) {
		adminUser.deleteByPrimaryKey(uid);
	}
	
	

}
