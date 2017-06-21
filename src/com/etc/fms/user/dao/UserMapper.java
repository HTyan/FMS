package com.etc.fms.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.etc.fms.user.entity.User;

@Repository("userDao")
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User record);

	User selByNameAndPwd(User user);

	List<User> queryAllUser();

	List<User> selByLUname(User user);


}