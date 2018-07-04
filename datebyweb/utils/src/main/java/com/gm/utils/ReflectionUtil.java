package com.gm.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;



/**
 * 反射工具
 * 
 * @author pqr
 *
 */
public class ReflectionUtil {

	/**
	 * 通过Introspector 的方式复制不为空的属性值
	 */
	public static Map<String, Object> notNullObjectToMapViaBeanInfo(Object o) {
		Map<String, Object> result = new HashMap<String, Object>(); 
		BeanInfo info = null;
		try {
			info = Introspector.getBeanInfo(o.getClass());
			for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
				Method reader = pd.getReadMethod();
				// 内容为null的过滤掉
				if (reader == null || reader.invoke(o) == null) {
					continue;
				}
				// 默认继承Object类的属性，过滤掉
				if (pd.getName().equalsIgnoreCase("class")) {
					continue;
				}
				 result.put(pd.getName(), reader.invoke(o));
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	/**
	 * 获取类中属性的类型
	 * @param o
	 * @param property
	 * @return
	 */
	public static String getPropertyByType(Object o,String property) {
		BeanInfo info = null;
		String type = "";
		try {
			info = Introspector.getBeanInfo(o.getClass());
			for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
				if (pd.getName().equalsIgnoreCase("class")) {
					continue;
				}
				if (pd.getName().equals(property)) {
					type = pd.getPropertyType().getSimpleName();
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
		return type;
	}
	
	
	
	/**
	 * 通过Introspector 的方式复制属性值
	 */
	public static Map<String, Object> objectToMapViaBeanInfo(Object o) {
		Map<String, Object> result = new HashMap<String, Object>(); 
		BeanInfo info = null;
		try {
			info = Introspector.getBeanInfo(o.getClass());
			for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
				Method reader = pd.getReadMethod();
				// 默认继承Object类的属性，过滤掉
				if (pd.getName().equalsIgnoreCase("class")) {
					continue;
				}
				 result.put(pd.getName(), reader.invoke(o));
			}

		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * 通过getDeclaredFields 的方式复制属性值 getDeclaredFields方式不会返回父类的属性
	 */
	public static Map<String, Object> objectToMapViaFields(Object o) {
		Map<String, Object> resMap = new HashMap<String, Object>();  
        Field[] declaredFields = o.getClass().getDeclaredFields();  
        for (Field field : declaredFields) {  
            field.setAccessible(true);  
            //过滤内容为空的  
            try {
				if (field.get(o) == null) {  
				    continue;  
				}
				resMap.put(field.getName(), field.get(o));  
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}  
        }
		return resMap;  
	}

	/**
	 * 通过Apache beanUtils的方式复制属性值 其内部实现方式同 方法1
	 */
	public static Map<Object, Object> objectToMapViaApacheTools(Object o) {
	      return new org.apache.commons.beanutils.BeanMap(o);
	}
	
	
	
	
}
