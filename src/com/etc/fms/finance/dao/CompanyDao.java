package com.etc.fms.finance.dao;

import java.util.List;

import com.etc.fms.company.entity.Company;

public interface CompanyDao {
	public int saveCompany(Company c) throws Exception;

	public Company getCompany(String cname) throws Exception;

	public List<Company> getCompanys(String cname) throws Exception;

	public int delCompany(int cid) throws Exception;
	
	public int updateCompany(int cid,double xy) throws Exception;
	
	public Company getCompany(int cid) throws Exception;
}

