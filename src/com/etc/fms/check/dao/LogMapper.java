package com.etc.fms.check.dao;

import org.springframework.stereotype.Repository;

import com.etc.fms.check.entity.Log;


/**
 * 自定义接口
 * 
 * @author Administrator
 * 
 */
@Repository(value="logdao")
public interface LogMapper {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public int insertLog(Log log);

	
	

}
