package com.etc.fms.financeinfo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.etc.fms.financeinfo.entity.FBaoBiao;
import com.etc.fms.financeinfo.entity.FinanceInfo;

@Repository(value="financeinfodao")
public interface FinanceInfoMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(FinanceInfo record);

    int insertSelective(FinanceInfo record);

    FinanceInfo selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(FinanceInfo record);

    int updateByPrimaryKey(FinanceInfo record);
    
    /**
     * 财务的操作
     * @param f
     * @return
     * @throws Exception
     */
	public int saveFinanceInfo(FinanceInfo f) throws Exception;

	public FinanceInfo getFinanceInfo(String cno) throws Exception;

	public List<FinanceInfo> getFinanceInfolist(int cid, String begintime,
			String endtime) throws Exception;
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<FinanceInfo> queryFinanceInfolist() ;
	
	public List<FBaoBiao> getFinanceBBlist(int cid, String begintime,
			String endtime) throws Exception; //报表

	public int delFinanceInfos(int cid) throws Exception;
	
	public int delFinanceInfo(int fid) throws Exception;
	
	public int updateFinance(FinanceInfo f) throws Exception;
}