package com.hhs.base.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.hhs.base.enums.QueryObjEnum;

public class QueryObj {
	// 查询条件 相等
	private List<Map<String, Object>> eqMap = new ArrayList<>();
	// 查询条件 不相等
	private List<Map<String, Object>> neMap = new ArrayList<>();
	// 查询条件 小于
	private Map<String, Object> ltMap = new HashMap<>();
	// 查询条件 小于或等于
	private Map<String, Object> leMap = new HashMap<>();
	// 查询条件 大于
	private Map<String, Object> gtMap = new HashMap<>();
	// 查询条件 大于或等于
	private Map<String, Object> geMap = new HashMap<>();
	// 查询条件 区间
	private List<Map<String, ConObj>> btMap = new ArrayList<>();
	// 查询条件 like
	private List<Map<String, Object>> lkMap = new ArrayList<>();
	// 返回查询属性集
	private List<String> reList = new ArrayList<>();
	// 排序
	private Map<String, QueryObjEnum> sortMap = new HashMap<>();
	//关联
	private Set<String> aliasSet = new HashSet<>();
	
	public List<String> getReList() {
		return reList;
	}
	
	public Set<String> getAliasSet() {
		return aliasSet;
	}

	public List<Map<String, Object>> getEqMap() {
		return eqMap;
	}

	public List<Map<String, Object>> getNeMap() {
		return neMap;
	}

	public Map<String, Object> getLtMap() {
		return ltMap;
	}

	public Map<String, Object> getLeMap() {
		return leMap;
	}

	public Map<String, Object> getGtMap() {
		return gtMap;
	}

	public Map<String, Object> getGeMap() {
		return geMap;
	}

	public List<Map<String, ConObj>> getBtMap() {
		return btMap;
	}
	
	public Map<String, QueryObjEnum> getSortMap() {
		return sortMap;
	}
	
	public List<Map<String, Object>> getLkMap() {
		return lkMap;
	}
	
	public QueryObj setReList(String p) {
		alias(p);
		reList.add(p);
		return this;
	}
	
	public QueryObj setEqMap(String p, Object v) {
		alias(p);
		Map<String,Object> map = new HashMap<>();
		map.put(p, v);
		eqMap.add(map);
		return this;
	}

	public void setNeMap(String p, Object v) {
		alias(p);
		Map<String,Object> map = new HashMap<>();
		map.put(p, v);
		this.neMap.add(map);
	}

	public void setLtMap(String p, Object v) {
		alias(p);
		this.ltMap.put(p, v);
	}

	public void setLeMap(String p, Object v) {
		alias(p);
		this.leMap.put(p, v);
	}

	public void setGtMap(String p, Object v) {
		alias(p);
		this.gtMap.put(p, v);
	}

	public void setGeMap(String p, Object v) {
		alias(p);
		this.geMap.put(p, v);
	}

	public void setBtMap(String p, ConObj conObj) {
		alias(p);
		Map<String,ConObj> map = new HashMap<>();
		map.put(p, conObj);
		this.btMap.add(map);
	}

	public void setLkMap(String p, Object v) {
		alias(p);
		Map<String,Object> map = new HashMap<>();
		map.put(p, v);
		this.lkMap.add(map);
	}

	public void setSortMap(String p, QueryObjEnum v) {
		alias(p);
		this.sortMap.put(p, v);
	}
	
	private void alias(String s){
		if (s.contains(".")) {
			String [] ss = s.split("\\.");
			for (int i = 0; i < ss.length; i++) {
				if (!ss[ss.length-1].equals("id")&&i != ss.length-1) {
					aliasSet.add(ss[i]);		
				}
			}
		}
	}

}
