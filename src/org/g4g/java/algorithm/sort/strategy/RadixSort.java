package org.g4g.java.algorithm.sort.strategy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.g4g.java.algorithm.sort.ISort;
import org.g4g.java.algorithm.sort.SortTest;

/**
 * Sort the whole array by 1's, 10's, 100's, ...
 * Create 10 lists corresponding to digit value 0 ~ 9 (19 if input could be negative).
 * First check last digit (1's): 
 * add integers to the list corresponding to its digit value.
 * Then the second last digit (10's),
 * Repeat until number of iteration == max digits of all integers.
 * 
 * Note: this algorithm can deal with positive & negative integers.
 * 		 but normally, Radix set only deals with non-negative numbers,
 * 		 and radix buckets is usually 0 - 9.
 * @author AlexTheGreat
 * @date Sep 29, 2014
 */
public class RadixSort implements ISort {

	@Override
	public void sort(int[] array) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i : array) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}
		int numDigits = 0;
		int selected = max;
		if (max + min < 0)
			selected = min;
		while (selected != 0) {
			selected /= 10;
			numDigits++;
		}
		Map<Integer, Deque<Integer>> radices = 
				new HashMap<Integer, Deque<Integer>>();
		for (int key = -9; key <= 9; key++)
			radices.put(key, new LinkedList<Integer>());
		
		int divider = 1;
		for (int pow = 1; pow <= numDigits; pow++) {
			for (int i : array) {
				int key = i / divider % 10;
				radices.get(key).addLast(i);
			}
			int index = 0;
			for (int key = -9; key <= 9; key++) {
				Deque<Integer> list = radices.get(key);
				while (!list.isEmpty()) {
					array[index++] = list.pollFirst();
				}
			}
			divider *= 10;
		}
	}
	
	
	public static void main(String[] args) {
		SortTest test = new SortTest();
		test.test(new RadixSort(), 100);
	}
	
}
