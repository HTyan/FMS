package com.etc.fms.expense.dao;

import org.springframework.stereotype.Repository;

import com.etc.fms.expense.entity.Checked;

@Repository(value="checkeddao")
public interface CheckedMapper {
	
    
    /**
	 * ��ѯͨ������
	 * @param cid
	 * @return
	 */
    Checked selectByPrimaryKey(Integer cid);
	

    /**
	 * ͨ�����Ų�ѯ
	 * @param cid
	 * @return
	 */
    Checked selectByDept(String dept);
	
	/**
	 * ɾ������
	 * @param cid
	 * @return
	 */
    int deleteByPrimaryKey(Integer cid);
    
    
    /**
	 * ��ӵ���
	 * @param cid
	 * @return
	 */
    int insert(Checked record);
    
    
    /**
	 * ���
	 * @param cid
	 * @return
	 */
    int insertSelective(Checked record);
    

    
    
    /**
	 * ɾ������
	 * @param cid
	 * @return
	 */
    int updateByPrimaryKeySelective(Checked record);
    
    
    /**
	 * ����ͨ������
	 * @param cid
	 * @return
	 */
    int updateByPrimaryKey(Checked record);
}