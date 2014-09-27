package org.g4g.java.algorithm.sort.strategy;

import org.g4g.java.algorithm.sort.ISort;
import org.g4g.java.algorithm.sort.SortTest;
import org.g4g.java.common.utils.CommonUtils;

/**
 * j = len-1
 * move from 0 to j, find the max element and swap with last index,
 * each iteration j decreases, repeat the above logic.
 * stop when j becomes 1.
 * @author AlexTheGreat
 * @date Sep 27, 2014
 */
public class BubbleSort implements ISort {

	@Override
	public void sort(int[] array) {
		for (int end = array.length - 1; end >= 1; end--) {
			int max = Integer.MIN_VALUE;
			int indexOfMax = -1;
			for (int i = 0; i <= end; i++) {
				if (array[i] > max) {
					max = array[i];
					indexOfMax = i;
				}
			}
			CommonUtils.swap(array, end, indexOfMax);
		}
	}
	
	public static void main(String[] args) {
		SortTest test = new SortTest();
		ISort sort = new BubbleSort();
		test.test(sort);
	}
}
