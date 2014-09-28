package org.g4g.java.algorithm.sort.strategy;

import java.util.Arrays;

import org.g4g.java.algorithm.sort.ISort;
import org.g4g.java.algorithm.sort.SortTest;
import org.g4g.java.common.utils.CommonUtils;

/**
 * Divide array into 2 sub-arrays, by mid point, then merge them.
 * During merging, select the smaller from left & right and insert in order.
 * @author admin
 *
 */
public class MergeSort implements ISort {

	@Override
	public void sort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	private void mergeSort(int[] array, int start, int end) {
		if (start >= end)
			return;
		
		int mid = (start + end)/2;
		mergeSort(array, start, mid);
		mergeSort(array, mid+1, end);
		
		int[] temp = new int[end - start + 1];
		int index = 0;
		int left = start, right = mid + 1;
		while (left <= mid && right <= end) {
			int leftInt  = array[left];
			int rightInt = array[right];
			if (leftInt < rightInt) {
				temp[index++] = leftInt;
				left++;
			} else {
				temp[index++] = rightInt;
				right++;
			}
		}
		if (left <= mid) {
			for (int i = left; i <= mid; i++)
				temp[index++] = array[left++];
		} else {
			for (int i = right; i <= end; i++)
				temp[index++] = array[right++];
		}
		
		for (int i = 0; i < temp.length; i++) {
			array[start + i] = temp[i];
		}
	}
	
	
	public static void main(String[] args) {
		new SortTest().test(new MergeSort(), 100);
	}

}
