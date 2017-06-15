package com.etc.fms.expense.dao;

import com.etc.fms.expense.entity.Apply;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}