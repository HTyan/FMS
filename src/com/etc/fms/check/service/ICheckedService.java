package com.etc.fms.check.service;

import java.util.List;

import com.etc.fms.check.entity.Checked;
import com.etc.fms.utils.PageBean;
import com.mysql.jdbc.log.Log;

public interface ICheckedService {

	/**
	 * ͨ��ID��ѯ
	 * @return
	 */
	public Checked selectChecked(int id);

	/**
	 * ��ѯȫ��
	 * @return
	 */
	public List<Checked> selectAllChecked();
	
	/**
	 * ���ӵ�����Ϣ 
	 * @param Checked
	 * @return
	 */
	public boolean addChecked(Checked Checked);
	
	/**
	 * �޸���Ϣ
	 * @param Checked
	 * @return
	 */
	public boolean updateChecked(Checked Checked);
	
	/**
	 * ͨ��idɾ��������Ϣ
	 * @param Checked
	 * @return
	 */
	public boolean deleteChecked(int id);
	
	/**
	 * ͨ��idsɾ��������Ϣ
	 * @param Checked
	 * @return
	 */
	public boolean deleteMuchChecked(String ids);
	
	/**
	 * ��ҳ��ѯ
	 * @param pb
	 * @return
	 */
	public List<Checked> selectCheckedByPage(PageBean pb);
	
	/**
	 * ���������
	 * @param Checked
	 * @param log
	 */
	public void insertChecked(Checked Checked, Log log);
}