package com.etc.fms.utils;



public class PageHibernateCallback<T> {
	
	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;
	

	public PageHibernateCallback(String hql, Object[] params,
			int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}



}
