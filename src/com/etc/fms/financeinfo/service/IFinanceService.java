package com.etc.fms.financeinfo.service;

import java.util.List;

import com.etc.fms.financeinfo.entity.FBaoBiao;
import com.etc.fms.financeinfo.entity.FinanceInfo;

public interface IFinanceService { 
	/**
	 * 保存
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public int saveFinanceinfo(FinanceInfo f);
	
	/**
	 * 
	 * @param cno
	 * @return
	 * @throws Exception
	 */
	public FinanceInfo getFinanceinfo(String cno);
	
	
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	public List<FinanceInfo> queryFinanceInfolist();
	/**
	 * 
	 * @param cid
	 * @param begintime
	 * @param endtime
	 * @return
	 * @throws Exception
	 */
	public List<FinanceInfo> getFinanceinfolist(int cid, String begintime,
			String endtime) throws Exception;
	
	/**
	 * 
	 * @param cid
	 * @param begintime
	 * @param endtime
	 * @return
	 * @throws Exception
	 */
	public List<FBaoBiao> getFinanceBBlist(int cid, String begintime,
			String endtime) ; 
	//报表

	public int delFinanceinfos(int cid);
	
	public int delFinanceinfo(int fid);
	
	public int updateFinance(FinanceInfo f);
}
