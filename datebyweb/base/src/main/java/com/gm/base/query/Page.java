package com.gm.base.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页类型，此类在分页查询数据时使用
 * 
 * @author guet
 *
 */
public class Page<T> {

	private Integer indexPage;
	private Integer sizePage;
	private Integer count;
	private Integer countPage;
	private Integer lastPage;
	private Integer nextPage;
	private String order = "asc";
	private boolean isPre;//是否有上一页  
	private boolean isNext;//是否有下页
	private List<T> list = new ArrayList<>();

	/**
	 * 排序
	 * 
	 * @return
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 设置排序
	 * 
	 * @param order
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	private Page() {
	}

	/**
	 * 构造器
	 * 
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            每页显示多少条数据
	 * @param count
	 *            总数据条数
	 */
	public Page(Integer indexPage, Integer sizePage, Integer count, List<T> list) {
		super();
		if (indexPage == null || indexPage == 0) {
			this.indexPage = 1;
		} else {
			this.indexPage = indexPage;
		}
		if (sizePage == null || sizePage == 0) {
			this.sizePage = 8;// 默认每一页８条信息
		} else {
			this.sizePage = sizePage;
		}

		this.count = count;

		if (count % sizePage == 0) {
			this.countPage = count / sizePage;
		} else {
			this.countPage = count / sizePage + 1;
		}

		if (indexPage == countPage && countPage == 1) {
			this.lastPage = 1;
			this.nextPage = 1;
		} else {
			if (indexPage == 1) {
				this.lastPage = 1;
				this.nextPage = indexPage + 1;
			} else if (indexPage == countPage) {
				this.lastPage = indexPage - 1;
				this.nextPage = indexPage;
			} else {
				this.lastPage = indexPage - 1;
				this.nextPage = indexPage + 1;
			}
		}

		if (null != list) {
			this.list = list;
		}

	}

	/**
	 * 返回当前页码
	 * 
	 * @return
	 */
	public Integer getIndexPage() {
		return indexPage;
	}

	/**
	 * 设置当前页码
	 * 
	 * @param pageIndex
	 */
	public void setIndexPage(Integer indexPage) {
		this.indexPage = indexPage;
	}

	/**
	 * 返回每一页数据量
	 * 
	 * @return
	 */
	public Integer getSizePage() {
		return sizePage;
	}

	/**
	 * 设置每一页数据量
	 * 
	 * @param pageSize
	 */
	public void setSizePage(Integer sizePage) {
		this.sizePage = sizePage;
	}

	/**
	 * 未分页时数据总量
	 * 
	 * @return
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 设置未分页时数据总量
	 * 
	 * @param count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public Integer getCountPage() {
		return countPage;
	}

	/**
	 * 设置总页数
	 * 
	 * @param pageCount
	 */
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}

	/**
	 * 获取上一页
	 * 
	 * @return
	 */
	public Integer getLastPage() {
		return lastPage;
	}

	/**
	 * 设置上一页
	 * 
	 * @param lastPage
	 */
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	/**
	 * 获取下一页
	 * 
	 * @return
	 */
	public Integer getNextPage() {
		return nextPage;
	}

	/**
	 * 设置下一页
	 * 
	 * @param nextPage
	 */
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	/**
	 * 是否有上一页
	 * @return
	 */
	public boolean getIsPre() {
		int next  = this.getIndexPage()-1;
		if (next >= 1) {
			this.isPre = true;
		}else {
			this.isPre = false;
		}
		return isPre;
	}
	
	public void setIsPre(boolean isPre) {
		this.isPre = isPre;
	}
	
	/**
	 * 是否有下一页
	 * @return
	 */
	public boolean getIsNext() {
		int next = this.getIndexPage()+1;
		if (next<=this.getCountPage()) {
			isNext = true;
			
		}else {
			isNext = false;
		}
		return isNext;
	}
	public void setIsNext(boolean isNext) {
		this.isNext = isNext;
	}

}
