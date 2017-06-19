package com.etc.fms.financeinfo.dao;

import org.springframework.stereotype.Repository;

import com.etc.fms.financeinfo.entity.FinanceInfo;

@Repository(value="financeinfodao")
public interface FinanceInfoMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(FinanceInfo record);

    int insertSelective(FinanceInfo record);

    FinanceInfo selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(FinanceInfo record);

    int updateByPrimaryKey(FinanceInfo record);
}