package test;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leeshtao.algorithm.BucketSort;
import com.leeshtao.algorithm.CountingSort;
import com.leeshtao.algorithm.HeapSort;
import com.leeshtao.algorithm.MergeSort;
import com.leeshtao.algorithm.QuickSort;
import com.leeshtao.algorithm.RadixSort;
import com.leeshtao.algorithm.ShellSort;
import com.leeshtao.algorithm.SortingAlgorithm;
import com.leeshtao.service.Sort;

public class SortingTest {

	private static final Logger logger = LoggerFactory.getLogger(SortingTest.class); 
	SortingAlgorithm s = new SortingAlgorithm();
	private int[] array = null;
	private Long start = null;
	private Long end = null;
	private Long se = null;
	@Before
	public void init(){
		array = s.getIntArrayRandom(1200, 120000);
		start = System.currentTimeMillis();
		logger.info("原数组:\n"+Arrays.toString(array));
		System.out.println("原数组:\n"+Arrays.toString(array));
	}
	
	
	@Test
	public void insertSortTest(){
		array = s.insertSort(array);
		s.show(array);
	}
	
	@Test
	public void selectSortTest(){
		array = s.selectSort(array);
		s.show(array);
	}
	
	@Test
	public void shellSortTest(){
		ShellSort s = new ShellSort();
		s.sort(array);
		s.show(array);
	}
	
	@Test
	public void bubbleSortTest(){
		array = s.bubbleSort(array);
		s.show(array);
	}
	
	@Test
	public void quickSortTest(){
		Sort s = new QuickSort();
		s.sort(array);
		s.show(array);
	}
	
	@Test
	public void heapSortTest(){
		HeapSort s = new HeapSort();
		s.sort(array);
		s.show(array);
	}
	
	@Test
	public void mergeSortTest(){
		MergeSort s = new MergeSort();
		s.sort(array);
		s.show(array);
	}
	
	@Test
	public void countingSortTest(){
		CountingSort s = new CountingSort();
		s.sort(array);
		s.show(array);
	}
	
	@Test
	public void bucketSort(){
		BucketSort s = new BucketSort();
		s.sort(array);
		s.show(array);
	}
	
	@Test
	public void radixSortTest(){
		Sort s = new RadixSort();
		s.sort(array);
		s.show(array);
		
	}
	
	@After
	public void after(){
		end = System.currentTimeMillis();
		se = end - start;
		logger.info("排序耗时:"+se);
		System.out.println("排序耗时:"+se);
	}
	
	
	
}
