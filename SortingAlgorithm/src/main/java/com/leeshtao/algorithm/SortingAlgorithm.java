package com.leeshtao.algorithm;

import com.leeshtao.service.Sort;

/**
 * 此类中有三种排序方法:插入,选择,冒泡
 *
 */
public class SortingAlgorithm extends Sort {
	 
	/* 插入排序 */
	public int[] insertSort(int[] array) { 
		// 从第二张牌开始比较
		for (int i = 1; i < array.length; i++) {
			int target = array[i];
			int j = i;
			// 如果比前一个大，就把前一个放到当前目标牌的位置，把前一个的位置空出来，然后继续跟更前一个比较，循环去找到最准确的目标位置
			while (j > 0 && target > array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			// 在目标位置的插入操作
			array[j] = target;
		}
		return array;
	}
	
	/* 选择排序 */ 
	public int[] selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			// 控制交换的次数，最多交换n-1次。
			int maxIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				// 找到当前位置后面最小值的位置，交换。
				swap(array, maxIndex, i);
			}
		}
		return array;
	}

	
	/*  冒泡排序  */ 
	public int[] bubbleSort(int[] arr) { 
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					arr = swap(arr, j, j + 1);
				}
			}
		}
		return arr;

	}
	
}