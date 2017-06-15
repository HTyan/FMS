package com.etc.fms.expense.dao;

import com.etc.fms.expense.entity.Checked;

public interface CheckedMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Checked record);

    int insertSelective(Checked record);

    Checked selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Checked record);

    int updateByPrimaryKey(Checked record);
}