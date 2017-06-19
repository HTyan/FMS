package com.etc.fms.utils;


import java.util.List;

/**
 * 分页数据类
 * 包含了 显示的记录的信息
 * 总数
 * 每行显示的记录
 * 当前的第几页
 */
public class PageData<T> {
	private List<T> data; // 查找的数据

	private Integer total; // 总记录数

	private Integer rows;// 每页几行

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	private Integer page;// 页数

	public PageData() {
		super();
	}

	public PageData(List<T> data, Integer total, Integer rows, Integer page) {
		super();
		this.data = data;
		this.total = total;
		this.rows = rows;
		this.page = page;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * 得到总页数
	 * @return
	 */
	public Integer getTotalPage() {
		//总记录数 和每页显示的记录数 来得到总页数
		//8   3
		Integer num = total / rows; //2
		if (total % rows != 0)
			num++; //3
		return num; //3
	}

	@Override
	public String toString() {
		return "{total:" + total + ",data:" + data + "}";
	}
}
