package com.etc.fms.financeinfo.service;

import java.util.List;

import com.etc.fms.financeinfo.entity.FBaoBiao;
import com.etc.fms.financeinfo.entity.FinanceInfo;

public interface IFinanceService { 
	/**
	 * ±£´æ
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
	//±¨±í

	public int delFinanceinfos(int cid);
	
	public int delFinanceinfo(int fid);
	
	public int updateFinance(FinanceInfo f);
}
