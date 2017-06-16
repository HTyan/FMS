package com.etc.fms.check.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.etc.fms.check.dao.CheckedMapper;
import com.etc.fms.check.dao.LogMapper;
import com.etc.fms.check.entity.Checked;
import com.etc.fms.check.service.ICheckedService;
import com.etc.fms.utils.PageBean;
import com.mysql.jdbc.log.Log;

@Service(value = "checkedService")
public class CheckedService implements ICheckedService {

	@Resource(name = "checkeddao")
	private CheckedMapper checkeddao;
	//工作日志
	@Resource(name = "logdao")
	private LogMapper logdao;


	/*@Resource可以忽略setter方法，用反射和代理，使用byName来注入*/
	public void setCheckeddao(CheckedMapper checkeddao) {
		this.checkeddao = checkeddao;
	}

	public CheckedMapper getCheckeddao() {

		return checkeddao;
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
	public Checked selectChecked(int id) {
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
