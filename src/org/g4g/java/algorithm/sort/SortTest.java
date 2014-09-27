package org.g4g.java.algorithm.sort;

import java.util.Arrays;

import org.g4g.java.common.utils.CommonUtils;

public class SortTest {
	private int size = 13;
	private boolean unique = true;
	// if true, print inputs, result, and time;
	// if false, only print error when the result is wrong.
	private boolean kerbose = true;
	
	/// Constructors ///
	
	public SortTest() {}
	
	public SortTest(int size, boolean unique, boolean kerbose) {
		this.size = size;
		this.unique = unique;
		this.kerbose = kerbose;
	}
	

	/// Getters & Setters ///
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	
	public boolean isKerbose() {
		return kerbose;
	}

	public void setKerbose(boolean kerbose) {
		this.kerbose = kerbose;
	}
	

	/// Methods ///
	
	public void test(ISort sort) {
		int[] array = CommonUtils.generateArray(size, unique);
		if (isKerbose())
			System.out.println("Input : " + Arrays.toString(array));
		
		long t1 = System.currentTimeMillis();
		sort.sort(array);
		long t2 = System.currentTimeMillis();
		
		if (array.length > 0) {
			int prev = array[0], curr;
			for (int i = 1; i < array.length; i++) {
				curr = array[i];
				if (curr < prev) {
					System.err.println("Sorting result is wrong!");
					break;
				}
			}
		}
		
		if (isKerbose()) {
			System.out.println("Sorted: " + Arrays.toString(array));
			System.out.println(String.format("Total time=%,dms", (t2 - t1)));
		}
	}
	

}
