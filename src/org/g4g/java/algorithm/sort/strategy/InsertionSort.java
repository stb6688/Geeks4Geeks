package org.g4g.java.algorithm.sort.strategy;

import java.util.Random;

import org.g4g.java.algorithm.sort.ISort;
import org.g4g.java.algorithm.sort.SortTest;

/**
 * From left to right, insert next element to the proper position
 * in the left subarray which is already sorted.
 * Will shift every elements from insertion point to right.
 * @author AlexTheGreat
 * @date Sep 27, 2014
 */
public class InsertionSort implements ISort {

	@Override
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int curr = array[i];
			int index = getInsertIndex(array, 0, i - 1, curr);
			// shift
			for (int j = i; j > index; j--)
				array[j] = array[j - 1];
			array[index] = curr;
		}
	}
	
	/**
	 * Divide & conquer.
	 * @param array
	 * @param start
	 * @param end
	 * @param target
	 * @return
	 */
	private int getInsertIndex(int[] array, int start, int end, int target) {
		// we will never encounter situation where start > end (insert into an empty sub-array).
		// first, the insertion starts from index=1, so left array can't be empty initially;
		// second, in any recursion, we check if mid-1 or mid+1 will exceeds boundary,
		// thus avoid empty array.
		if (start == end) {
			if (target <= array[start])
				return start;
			else
				return start + 1;
		} else {
			int mid = (start + end)/2;
			if (array[mid] == target)
				return mid;
			else if (target < array[mid]) {
				if (mid - 1 < start)
					return start;
				else
					return getInsertIndex(array, start, mid-1, target);
			} else {
				if (mid + 1 > end)
					return end;
				else
					return getInsertIndex(array, mid+1, end, target);
			}
		}
	}

	public static void main(String[] args) {
		final int numTests = 100;
		SortTest test = new SortTest();
		test.setKerbose(false);
		ISort sort = new InsertionSort();
		
		test.setSize(0);
		test.test(sort);
		test.setSize(1);
		test.test(sort);
		
		Random random = new Random();
		for (int i = 0; i < numTests; i++) {
			test.setSize(random.nextInt(1000));
			test.test(sort);
		}
	}
	
}
