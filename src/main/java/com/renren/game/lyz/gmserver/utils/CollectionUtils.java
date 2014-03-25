package com.renren.game.lyz.gmserver.utils;

/**
 * $Id: CollectionUtils.java 18178 2013-11-19 11:05:36Z xiaowei.hu $
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 扩展{@link org.apache.commons.collections.CollectionUtils},添加一些创建map,set,list的泛型方法。
 * 
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-8-21 上午11:26:36
 * @since 1.0
 */
public class CollectionUtils extends org.apache.commons.collections.CollectionUtils {

    /**
     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
     * (16) and the default load factor (0.75).
     * 
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> newHashMap() {
        return newHashMap(16);
    }
    
    /**
     * Constructs an empty HashMap with the specified initial capacity and the default load factor (0.75).
     * 
     * @param <K>
     * @param <V>
     * @param initialCapacity
     * @return
     */
    public static <K, V> Map<K, V> newHashMap(int initialCapacity) {
        return new HashMap<K, V>(initialCapacity);
    }
    
    /**
     * Constructs an empty list with the specified initial capacity.
     * 
     * @param <T>
     * @param initialCapacity
     * @return
     */
    public static <T> List<T> newArrayList(int initialCapacity) {
        return new ArrayList<T>(initialCapacity);
    }
    
    /**
     * Constructs an empty list with an initial capacity of ten.
     * 
     * @param <T>
     * @return
     */
    public static <T> List<T> newArrayList() {
        return newArrayList(10);
    }
    
    public static <T> List<T> newLinkedList() {
    	return new LinkedList<T>();
    }
    
    /**
     * @param enemyList
     * @return
     */
    public static <T> List<T> newArrayList(List<T> c) {
        return new ArrayList<T>(c);
    }
    
    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
     * the specified initial capacity and default load factor (0.75).
     * 
     * @param <T>
     * @param initialCapacity
     * @return
     */
    public static <T> Set<T> newHashSet(int initialCapacity) {
        return new HashSet<T>(initialCapacity);
    }
    
    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
     * default initial capacity (16) and load factor (0.75).
     * 
     * @param <T>
     * @return
     */
    public static <T> Set<T> newHashSet() {
        return newHashSet(16);
    }

    /**
     * @param disorderBoss
     * @return
     */
    public static <T> List<T> set2List(Set<T> set) {
        List<T> ret = newArrayList(set.size());
        for (T t : set) {
            ret.add(t);
        }
        return ret;
    }

  
}
