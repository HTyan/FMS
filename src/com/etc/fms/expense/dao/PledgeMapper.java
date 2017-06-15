package com.etc.fms.expense.dao;

import com.etc.fms.expense.entity.Pledge;

public interface PledgeMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Pledge record);

    int insertSelective(Pledge record);

    Pledge selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Pledge record);

    int updateByPrimaryKey(Pledge record);
}