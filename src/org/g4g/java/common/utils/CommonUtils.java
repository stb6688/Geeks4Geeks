package org.g4g.java.common.utils;

import java.util.Arrays;
import java.util.Random;

public class CommonUtils {
	
	/**
	 * Given an URL of geeksforgeeks, return a Java class name.
	 * @param url
	 * @return
	 */
	public static String urlToClass(String url) {
		url = url.trim();
		if (url.charAt(url.length()-1) == '/')
			url = url.substring(0, url.length() - 1);
		String[] splits = url.split("/");
		splits = splits[splits.length - 1].split("-");
		StringBuilder builder = new StringBuilder();
		for (String split : splits) {
			StringBuilder temp = new StringBuilder(split);
			temp.setCharAt(0, Character.toUpperCase(temp.charAt(0)));
			builder.append(temp);
		}
		
		return builder.toString();
	}
	
	/**
	 * Given start & end, print ms elapsed between.
	 * Used for calculating time taken to execute a function.
	 * @param t1
	 * @param t2
	 */
	public static void printTime(long t1, long t2) {
		System.out.println(String.format("Total time taken: %,dms", (t2 - t1)));
	}
	
	public static void swap(int[] array, int i, int j) {
		// CATCH: must check this!
		// otherwise, if you use solution 1 or 2 when i==j, error!
		if (i == j)
			return;
		
		// solution 1
		array[i] ^= array[j];
		array[j] ^= array[i];
		array[i] ^= array[j];
		
		// solution 2
//		array[i] = array[i] + array[j];
//		array[j] = array[i] - array[j];
//		array[i] = array[i] - array[j];
	}
	
	/**
	 * Generate an integer array with given size; if unique, will not allow
	 * duplicated elements; otherwise there is no guarantee.
	 * @param size
	 * @param unique
	 * @param allowNegative
	 * @return
	 */
	public static int[] generateArray(int size, boolean unique, boolean allowNegative) {
		Random random = new Random();
		if (size < 0)
			throw new IllegalArgumentException("array size can't be negative.");
		int[] array = new int[size];
		if (unique) {
			for (int i = 0; i < size; i++)
				array[i] = i;
		} else {
			for (int i = 0; i < size; i++)
				array[i] = random.nextInt(size);
		}
		for (int i = 0; i < size; i++)
			swap(array, i, random.nextInt(size));
		if (allowNegative) {
			int shift = size/2;
			for (int i = 0; i < size; i++)
				array[i] -= shift;
		}
		
		return array;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(urlToClass("http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/"));
		
//		System.out.println(Arrays.toString(CommonUtils.generateArray(20, true, true)));
	}
	
}
