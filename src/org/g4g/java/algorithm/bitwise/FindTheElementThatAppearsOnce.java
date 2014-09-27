package org.g4g.java.algorithm.bitwise;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: 
 *
Given an array where every element occurs three times, 
except one element which occurs only once. Find the element that occurs once. 
Expected time complexity is O(n) and O(1) extra space.
Examples:

Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
Output: 2

public class FindTheElementThatAppearsOnce {
	
	public int findInt(int[] arr) {
		
	}

}
 * @author admin
 *
 */


/**
 * we sum all the elements per bit, then module the sum by 3.
 * for those with 3 occurrences:
 * 	if bit=1 --> sum=3, module=0;
 * 	if bit=0 --> sum=3, module=0;
 * for the target element with 1 occurrence:
 *  if bit=1 --> sum=1, module=1;
 * 	if bit=0 --> sum=0, module=0;
 * So: each resulted bit is essentially equal to the bit on target element!
 * 
 * @author admin
 *
 */
public class FindTheElementThatAppearsOnce {
	
	// find the largest & smallest element, calculate the longest digits --> len
	// for n: 0 to len
	//		mask = 1 << n
	// 		then element & mask and sum up; result module with 3.
	// add up the result from each iteration, that is the target element.
	public int findInt(int[] arr) {
		int result = 0;
		for (int n = 0; n < 32; n++) {
			int sum = 0;
			for (int i : arr) {
				i >>>= n;
				i &= 1;
				sum += i;
			}
			sum %= 3;
			result += (sum << n);
		}
		
		return result;
	}
	
	// SOLUTION I: use HashMap, which gives linear performance 
	// and linear space.
	// key is element, value is occurrences;
	// if an element's count reaches 3, remove the element.
	// in the end, only 1 element should remain in map.
//	public int findInt(int[] arr) {
//		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
//		for (int i : arr) {
//			Integer count = countMap.get(i);
//			if (count == null)
//				count = 1;
//			else
//				count++;
//			if (count < 3)
//				countMap.put(i, count);
//			else
//				countMap.remove(i);
//		}
//		return countMap.keySet().iterator().next();
//	}

	public static void main(String[] args) {
		FindTheElementThatAppearsOnce instance = new FindTheElementThatAppearsOnce();
		int result;
		
		// first test
		// result=2
//		int[] arr = new int[]{12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
//		result = instance.findInt(arr);
//		System.out.println(result);
		
		// test with negative number, where leftmost bit is 1.
		// result=-2
		int[] arr = new int[]{-12, -1, -12, 3, -12, -1, -1, -2, 3, 3};
		result = instance.findInt(arr);
		System.out.println(result);
	}
}
