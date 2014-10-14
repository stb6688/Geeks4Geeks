package org.g4g.java.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Problem:
You are given n activities with their start and finish times. 
Select the maximum number of activities that can be performed by a single person, 
assuming that a person can only work on a single activity at a time.
Example:
Consider the following 6 activities. 
     start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
The maximum set of activities that can be executed 
by a single person is {0, 1, 3, 4} (return indices of selected activities).
 * 
 * @author AlexTheGreat
 * @date Oct 13, 2014
 */
public class ActivitySelectionProblem {

	/**
	 * Logic:
	 * greedy: sort all activities by end time;
	 * select the next activity whose start is after previously selected activity. 
	 * 
	 * Implementation:
	 * 1. build an array with start & end.
	 * 2. sort array by end (user Collections.sort() with an anonymous Comparactor).
	 * iterate through the sorted activities and select:
	 * record lastEnd, which is initialized to -1;
	 * check next activity; if start > lastEnd, select it;
	 * add all selected indices to a list;
	 * in the end, convert list to an array.
	 * @param start
	 * @param end
	 * @return
	 */
	public int[] getMaxActivities(int[] start, int[] end) {
		List<List<Integer>> sorted = new ArrayList<List<Integer>>();
		for (int i = 0; i < start.length; i ++) {
			List<Integer> activity = new ArrayList<Integer>(2);
			activity.add(start[i]);
			activity.add(end[i]);
			sorted.add(activity);
		}
		
		Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> l1, List<Integer>l2) {
				return l1.get(1) - l2.get(1);
			}
		};
		Collections.sort(sorted, comparator);
		
		List<Integer> indices = new ArrayList<Integer>();
		int lastEnd = -1;
		for (int i = 0; i < sorted.size(); i++) {
			List<Integer> activity = sorted.get(i);
			if (activity.get(0) <= lastEnd)
				continue;
			indices.add(i);
			lastEnd = activity.get(1);
		}
		
		int[] result = new int[indices.size()];
		for (int i = 0; i < indices.size(); i++)
			result[i] = indices.get(i);
		
		return result;
	}
	
	public static void main(String[] args) {
		ActivitySelectionProblem instance = new ActivitySelectionProblem();
		
		// empty
//		int[] start = {};
//		int[] end = {};
		
		// {0, 1, 3, 4}
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] end = {2, 4, 6, 7, 9, 9};

		
		int[] result = instance.getMaxActivities(start, end);
		System.out.println(">> Result: " + Arrays.toString(result));
	}
	
}
