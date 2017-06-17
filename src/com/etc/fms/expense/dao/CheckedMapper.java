package com.etc.fms.expense.dao;

import org.springframework.stereotype.Repository;

import com.etc.fms.expense.entity.Checked;

@Repository(value="checkeddao")
public interface CheckedMapper {
	
    
    /**
	 * 查询通过主键
	 * @param cid
	 * @return
	 */
    Checked selectByPrimaryKey(Integer cid);
	

    /**
	 * 通过部门查询
	 * @param cid
	 * @return
	 */
    Checked selectByDept(String dept);
	
	/**
	 * 删除单个
	 * @param cid
	 * @return
	 */
    int deleteByPrimaryKey(Integer cid);
    
    
    /**
	 * 添加单个
	 * @param cid
	 * @return
	 */
    int insert(Checked record);
    
    
    /**
	 * 添加
	 * @param cid
	 * @return
	 */
    int insertSelective(Checked record);
    

    
    
    /**
	 * 删除单个
	 * @param cid
	 * @return
	 */
    int updateByPrimaryKeySelective(Checked record);
    
    
    /**
	 * 更新通过主键
	 * @param cid
	 * @return
	 */
    int updateByPrimaryKey(Checked record);
}