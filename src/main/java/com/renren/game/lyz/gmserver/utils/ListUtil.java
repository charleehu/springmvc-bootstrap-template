package com.renren.game.lyz.gmserver.utils;

/**
 * $Id: ListUtil.java 18178 2013-11-19 11:05:36Z xiaowei.hu $
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-9-6 下午03:31:02
 * @since 1.0
 */
public class ListUtil {
    public static interface TargetObject<T, V> {
        V getValue(T t);
    }

    public static List<Long> string2LongList(String source, String split) {
    	if (StringUtil.isEmpty(source)) return CollectionUtils.newArrayList(0);
        return string2long(Arrays.asList(source.split(split)));
	}
    
    public static List<Long> string2long(List<String> input) {
        List<Long> output = CollectionUtils.newArrayList(input.size());
        for (String s : input) {
            if (!StringUtils.isEmpty(s)) output.add(Long.valueOf(s));
        }
        return output;
    }
    
    public static List<String> long2string(List<Long> input) {
        List<String> output = CollectionUtils.newArrayList(input.size());
        for (Long s : input) {
            output.add(s.toString());
        }
        return output;
    }

    public static List<Long> string2LongList(String source) {
    	return string2LongList(source, ",");
    }
    
    public static <T> String join(List<T> list, String separator) {
        return joinWithSeparator(list, separator, new TargetObject<T, String>() {

            @Override
            public String getValue(T t) {
                return String.valueOf(t);
            }
        });
    }
    
    public static <T> String joinWithComma(List<T> list) {
        return join(list, ",");
    }
    
    /**
     * 从targetList提取指定值用","分隔
     * 
     * @param <T>
     * @param <V>
     * @param targetList
     * @param targetObject
     * @return
     */
    public static <T, V> String joinWithComma(List<T> targetList, TargetObject<T, V> targetObject) {
        return joinWithSeparator(targetList, ",", targetObject);
    }
    
    /**
     * 从targetList提取指定值用separator分隔
     * 
     * @param <T>
     * @param <V>
     * @param targetList
     * @param separator
     * @param targetObject
     * @return
     */
    public static <T, V> String joinWithSeparator(List<T> targetList, String separator, TargetObject<T, V> targetObject) {
        if (targetList == null) {
            throw new IllegalArgumentException("param list is null.");
        }
        
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < targetList.size(); i++) {
            if (i != 0) rs.append(separator);
            rs.append(targetObject.getValue(targetList.get(i)));
        }
        
        return rs.toString();
    }

    /**
     * @param source
     * @return
     */
    public static List<Integer> string2IntList(String source) {
        return parseWithComma(source, new TargetObject<String, Integer>(){

            @Override
            public Integer getValue(String t) {
                return Integer.parseInt(t);
            }
            
        });
    }
    
    public static List<Integer> string2int(List<String> input) {
        return string2t(input, new TargetObject<String, Integer>(){

            @Override
            public Integer getValue(String t) {
                return Integer.parseInt(t);
            }
            
        });
    }

    public static <T> List<T> parseWithComma(String source, TargetObject<String, T> targetObject) {
        if (StringUtil.isEmpty(source)) {
            return Collections.emptyList();
        }
        
        return string2t(Arrays.asList(source.split(",")), targetObject);
    }
    
    public static <T> List<T> string2t(List<String> list, TargetObject<String, T> targetObject) {
        return fetchValue(list, targetObject);
    }
    
    /**
     * 从targetCollection中提取指定值封装成List返回
     * 
     * @param targetCollection
     * @param targetObject
     * @return
     */
    public static <T, V> List<V> fetchValue(Collection<T> targetCollection, TargetObject<T, V> targetObject) {
        List<V> ret = CollectionUtils.newArrayList();
        for (T t : targetCollection) {
            ret.add(targetObject.getValue(t));
        }
        return ret;
    }
    
    public static List<Long> obj2Long(List<Object> source) {
        List<Long> ret = new ArrayList<Long>();
        for (Object o : source) {
            ret.add((Long) o);
        }
        return ret;
    }

}
