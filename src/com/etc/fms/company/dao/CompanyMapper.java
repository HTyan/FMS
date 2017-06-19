package com.etc.fms.company.dao;

import com.etc.fms.company.entity.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}