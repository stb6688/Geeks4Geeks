package org.g4g.java.algorithm.sort.strategy;

import java.util.Arrays;

import org.g4g.java.algorithm.sort.ISort;
import org.g4g.java.algorithm.sort.SortTest;

public class CountingSort implements ISort {

	@Override
	public void sort(int[] array) {
		if (array.length <= 1)
			return;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : array) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;
		}
		
		int[] counts = new int[max - min + 1];
		Arrays.fill(counts, 0);
		for (int i : array)
			counts[i - min]++;
		
		int index = 0;
		for (int i = 0;  i < counts.length; i++) {
			int count = counts[i];
			while ((count--) > 0) {
				array[index++] = i + min;
			}
		}
	}
	
	
	public static void main(String[] args) {
		SortTest test = new SortTest();
		test.test(new CountingSort(), 100);
	}
	
}
