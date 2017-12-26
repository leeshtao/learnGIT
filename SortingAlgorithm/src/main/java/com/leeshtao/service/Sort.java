package com.leeshtao.service;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Sort {
	
	private static final Logger logger = LoggerFactory.getLogger(Sort.class);

	private int count; 
	
	public int[] sort(int[] array) { 
		return null; 
	}; 
	/** * 互换位置的方法 *
     * @param array
     * 要换位置的目标数组
     * @param i
     * 数组位置1
     * @param j
     * 数组位置2
     * @return 换好位置以后的数组
     */

	protected int[] swap(int[] array, int i, int j) { 
		int t = array[i];
		array[i] = array[j]; 
		array[j] = t; 
		count++; 
		return array; 
	} 
	
	public void show(int[] array) { 
		logger.info("排序后数组:\n"+Arrays.toString(array));
		System.out.println("排序后数组:\n"+Arrays.toString(array)); 
		System.out.println("数组长度：" + array.length + "，执行交换次数：" + count); 
	} 
	
	public int[] getIntArrayRandom(int len, int max) { 
		int[] arr = new int[len]; 
		Random r = new Random(); 
		for (int i = 0; i < arr.length; i++) { 
			arr[i] = r.nextInt(max); 
		} 
		return arr; 
	} 
	
	/**
     * 取得数组的最大值
     * @param arr
     * @return
     */

	protected int max(int[] arr) { 
		int max = 0; 
		for (int a : arr) { 
			if (a > max) max = a; 
		} 
		return max; 
	}
}
