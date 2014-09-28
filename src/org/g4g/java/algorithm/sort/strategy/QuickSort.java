package org.g4g.java.algorithm.sort.strategy;

import org.g4g.java.algorithm.sort.ISort;
import org.g4g.java.algorithm.sort.SortTest;
import org.g4g.java.common.utils.CommonUtils;

/**
 * Pick a pivot (last of sub-array);
 * move cursor from start to right until end-1,
 * if current element is less than pivot, swap with index "next",
 * where "next" is the index for next element less than pivot.
 * In the end, swap pivot with next; any element on right of left are >= pivot.
 * Recurse with sub-array from start to left-1, and from left+1 to end.
 * @author AlexTheGreat
 * @date Sep 27, 2014
 */
public class QuickSort implements ISort {

	@Override
	public void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	// select last element as pivot.
	private void quickSort(int[] array, int start, int end) {
		// boundary
		if (start >= end)
			return;
		
		int pivot = array[end];
		int next = start; // next position to store the element less than pivot.
		for (int curr = start; curr < end; curr++) {
			if (array[curr] < pivot) {
				CommonUtils.swap(array, curr, next);
				next++;
			}
		}
		CommonUtils.swap(array, next, end);
		
		quickSort(array, start, next-1);
		quickSort(array, next+1, end);
	}
	
	
	public static void main(String[] args) {
		new SortTest().test(new QuickSort(), 100);
	}
}
