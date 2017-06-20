package com.etc.fms.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.fms.company.dao.CompanyMapper;
import com.etc.fms.company.entity.Company;
import com.etc.fms.company.service.ICompanyService;

@Service(value = "companyService")
public class CompanyServiceImpl implements ICompanyService {
	/**
	 * ×¢Èë
	 */
	@Resource(name = "companydao")
	private CompanyMapper companydao;

	public CompanyMapper getCompanydao() {
		return companydao;
	}

	public void setCompanydao(CompanyMapper companydao) {
		this.companydao = companydao;
	}

	@Override
	public int delCompany(int cid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Company getCompany(int cid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompany(String cname) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getCompanys(String cname) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveCompany(Company c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCompany(int cid, double xy) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
