package com.etc.fms.expense.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.fms.expense.dao.CheckedMapper;
import com.etc.fms.expense.entity.Checked;
import com.etc.fms.expense.service.ICheckedService;
import com.etc.fms.utils.PageBean;
import com.mysql.jdbc.log.Log;

@Service(value = "checkedService")
public class CheckedService implements ICheckedService {

	@Resource(name = "checkeddao")
	private CheckedMapper checkeddao;


	/*@Resource可以忽略setter方法，用反射和代理，使用byName来注入*/
	public void setCheckeddao(CheckedMapper checkeddao) {
		this.checkeddao = checkeddao;
	}

	public CheckedMapper getCheckeddao() {

		return checkeddao;
	}
	
	/**
	 * 通过id查询审批表信息
	 */
	@Override
	public Checked selectByPrimaryKey(int cid) {
		// TODO Auto-generated method stub
		return checkeddao.selectByPrimaryKey(cid);
	}
	
	/**
	 * 通过部门查询审批表信息
	 */
	@Override
	public Checked selectByDept(String dept) {
		// TODO Auto-generated method stub
		return checkeddao.selectByDept(dept);
	}
	
	@Override
	public boolean addChecked(Checked Checked) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteChecked(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteMuchChecked(String ids) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void insertChecked(Checked Checked, Log log) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Checked> selectAllChecked() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	@Override
	public List<Checked> selectCheckedByPage(PageBean pb) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean updateChecked(Checked Checked) {
		// TODO Auto-generated method stub
		return false;
	}public CheckedService() {
		// TODO Auto-generated constructor stub
	}
}
