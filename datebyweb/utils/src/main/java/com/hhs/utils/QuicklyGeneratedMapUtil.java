package com.hhs.utils;

import java.util.HashMap;
import java.util.Map;

public class QuicklyGeneratedMapUtil {
	private Map<String, Object> map = new HashMap<>();
	
	public static Builder initialization(){
		Builder builder = new Builder();
		return builder;
	}
	
	public static class Builder {
		private QuicklyGeneratedMapUtil qgm = new QuicklyGeneratedMapUtil();

		public Builder addMap(String key,Object value) {
			qgm.map.put(key, value);
			return this;
		}
		
		public Map<String, Object> build() {
			return qgm.map;
		}
	}
	
	
	public static void main(String[] args) {
		Map<String,Object> map = QuicklyGeneratedMapUtil.initialization().addMap("s", "sdsdsd").addMap("asd", 123123).build(); 
		map.forEach((k,v)->System.out.println("key:"+k+"\n"+"value:"+v));
	}
}
