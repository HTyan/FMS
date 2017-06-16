package com.etc.fms.check.dao;

import org.springframework.stereotype.Repository;

import com.etc.fms.check.entity.Checked;

@Repository(value="checkeddao")
public interface CheckedMapper {
	//ɾ��
    int deleteByPrimaryKey(Integer cid);
    //���
    int insert(Checked record);

    int insertSelective(Checked record);

    Checked selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Checked record);

    int updateByPrimaryKey(Checked record);
}