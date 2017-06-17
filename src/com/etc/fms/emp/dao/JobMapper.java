package com.etc.fms.emp.dao;

import com.etc.fms.emp.entity.Job;

public interface JobMapper {
    int deleteByPrimaryKey(Integer jid);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer jid);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}