package com.etc.fms.expense.dao;

import org.springframework.stereotype.Repository;
import com.etc.fms.expense.entity.Pledge;

@Repository("pledgedao")
public interface PledgeMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Pledge record);

    int insertSelective(Pledge record);

    Pledge selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Pledge record);

    int updateByPrimaryKey(Pledge record);
    
    //自定义增加方法
    public boolean insert1(Pledge pledge);
}