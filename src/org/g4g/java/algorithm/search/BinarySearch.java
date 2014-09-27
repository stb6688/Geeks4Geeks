package org.g4g.java.algorithm.search;

import java.util.Random;

import org.g4g.java.common.utils.CommonUtils;

/**
 * Given a sorted array arr[] of n elements, write a function to 
 * search a given element x in arr[]. Return its index; if not found,
 * return -1.
 * @author AlexTheGreat
 * @date Sep 26, 2014
 */
public class BinarySearch {

	public int search(int[] sorted, int target) {
		return doSearch(sorted, 0, sorted.length - 1, target);
	}
	
	private int doSearch(int[] sorted, int start, int end, int target) {
		if (start > end)
			return -1;
		if (start == end) {
			if (sorted[start] == target)
				return start;
			else
				return -1;
		}
		
		int mid = (start + end)/2;
		if (sorted[mid] == target)
			return mid;
		else if (target < sorted[mid])
			return doSearch(sorted, start, mid-1, target);
		else
			return doSearch(sorted, mid+1, end, target);
	}
	
	public static void main(String[] args) {
		final int len = 10000000;
		
		BinarySearch instance = new BinarySearch();
		int[] sorted = new int[len];
		for (int i = 0; i < len; i++)
			sorted[i] = i;
		Random random = new Random();
		
		int target = random.nextInt(len);
		System.out.println("target=" + target);
		long t1 = System.currentTimeMillis();
		int index = instance.search(sorted, target);
		long t2 = System.currentTimeMillis();
		if (index >= 0)
			System.out.println("index=" + index + ", value=" + sorted[index]);
		else
			System.out.println("not found");

		CommonUtils.printTime(t1, t2);
	}
	
}
