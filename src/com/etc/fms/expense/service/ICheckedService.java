package com.etc.fms.expense.service;

import java.util.List;

import com.etc.fms.expense.entity.Checked;
import com.etc.fms.utils.PageBean;
import com.mysql.jdbc.log.Log;

public interface ICheckedService {

	/**
	 * 通过ID查询
	 * @return
	 */
	public Checked selectByPrimaryKey(int id);
	
	/**
	 * 通过部门查询
	 * @return
	 */
	public Checked selectByDept(String dept);
	
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<Checked> selectAllChecked();
	
	/**
	 * 添加单条信息 
	 * @param Checked
	 * @return
	 */
	public boolean addChecked(Checked Checked);
	
	/**
	 * 修改信息
	 * @param Checked
	 * @return
	 */
	public boolean updateChecked(Checked Checked);
	
	/**
	 * 通过id删除单条信息
	 * @param Checked
	 * @return
	 */
	public boolean deleteChecked(int id);
	
	/**
	 * 通过ids删除多条信息
	 * @param Checked
	 * @return
	 */
	public boolean deleteMuchChecked(String ids);
	
	/**
	 * 分页查询
	 * @param pb
	 * @return
	 */
	public List<Checked> selectCheckedByPage(PageBean pb);
	
	/**
	 * 事务的添加
	 * @param Checked
	 * @param log
	 */
	public void insertChecked(Checked Checked, Log log);
}
