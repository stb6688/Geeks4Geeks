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
	
	public boolean test(ISort sort) {
		boolean success = true;
		int[] array = CommonUtils.generateArray(size, unique);
		int[] copy  = Arrays.copyOf(array, array.length);
		if (isKerbose())
			System.out.println("Input : " + Arrays.toString(array));
		
		long t1 = System.currentTimeMillis();
		sort.sort(array);
		long t2 = System.currentTimeMillis();
		
		Arrays.sort(copy);
		for (int i = 0; i < array.length; i++) {
			if (array[i] != copy[i]) {
				System.err.println("Sorting result is wrong!!");
				success = false;
				break;
			}
		}
		
		if (isKerbose()) {
			System.out.println("Sorted: " + Arrays.toString(array));
			System.out.println(String.format("Total time=%,dms", (t2 - t1)));
		}
		
		return success;
	}
	
	public boolean test(ISort sort, int n) {
		boolean success = true;
		for (int i = 0; i < n; i++) {
			int[] array = CommonUtils.generateArray(size, unique);
			int[] copy  = Arrays.copyOf(array, array.length);
			sort.sort(array);
			Arrays.sort(copy);
			for (int j = 0; j < array.length; j++) {
				if (array[j] != copy[j]) {
					System.err.println("Sorting result is wrong!!");
					success = false;
					break;
				}
			}
		}
		
		if (success)
			System.out.println("Success!");
		return success;
	}
	

}
