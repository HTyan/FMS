package com.etc.fms.company.dao;

import org.springframework.stereotype.Repository;

import com.etc.fms.company.entity.Company;

@Repository(value = "companydao")
public interface CompanyMapper {

	int deleteByPrimaryKey(Integer cid);

	int insert(Company record);

	int insertSelective(Company record);

	Company selectByPrimaryKey(Integer cid);

	int updateByPrimaryKeySelective(Company record);

	int updateByPrimaryKey(Company record);
}