package org.g4g.java.algorithm.sort.strategy;

import org.g4g.java.algorithm.sort.ISort;
import org.g4g.java.algorithm.sort.SortTest;
import org.g4g.java.common.utils.CommonUtils;

/**
 * From index 0 to end,
 * select, from index to end, the smallest int and swap to here.
 * @author admin
 *
 */
public class SelectionSort implements ISort {

	@Override
	public void sort(int[] array) {
		for (int curr = 0; curr < array.length; curr++) {
			int min = array[curr];
			int indexOfMin = curr;
			for (int i = curr; i < array.length; i++) {
				if (array[i] < min) {
					min = array[i];
					indexOfMin = i;
				}
			}
			CommonUtils.swap(array, curr, indexOfMin);
		}
	}
	
	public static void main(String[] args) {
		new SortTest().test(new SelectionSort());
	}

}
