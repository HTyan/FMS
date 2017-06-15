package com.etc.fms.emp.dao;

import com.etc.fms.emp.entity.Granted;

public interface GrantedMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Granted record);

    int insertSelective(Granted record);

    Granted selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Granted record);

    int updateByPrimaryKey(Granted record);
}