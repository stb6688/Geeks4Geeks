package org.g4g.java.algorithm.sort;

import java.util.Arrays;

import org.g4g.java.common.utils.CommonUtils;

public class SortTest {
	private int size = 100;
	private boolean unique = true;
	
	public SortTest() {}
	
	public SortTest(int size, boolean unique) {
		this.size = size;
		this.unique = unique;
	}
	
	public void test(ISort sort) {
		int[] array = CommonUtils.generateArray(size, unique);
		System.out.println("Input : " + Arrays.toString(array));
		
		long t1 = System.currentTimeMillis();
		sort.sort(array);
		long t2 = System.currentTimeMillis();
		
		int prev = array[0], curr;
		for (int i = 1; i < array.length; i++) {
			curr = array[i];
			if (curr < prev) {
				System.err.println("Sorting result is wrong!");
				break;
			}
		}
		
		System.out.println("Sorted: " + Arrays.toString(array));
		System.out.println(String.format("Total time=%,dms", (t2 - t1)));
	}
	

}
