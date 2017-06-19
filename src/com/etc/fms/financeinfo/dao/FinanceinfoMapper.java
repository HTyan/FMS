package com.etc.fms.financeinfo.dao;

import com.etc.fms.financeinfo.entity.Financeinfo;

public interface FinanceinfoMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Financeinfo record);

    int insertSelective(Financeinfo record);

    Financeinfo selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Financeinfo record);

    int updateByPrimaryKey(Financeinfo record);
}