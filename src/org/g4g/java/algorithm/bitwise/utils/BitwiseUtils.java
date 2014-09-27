package org.g4g.java.algorithm.bitwise.utils;

import java.util.Random;

public class BitwiseUtils {

//	public static int getNumOnes(int i) {
//		
//	}
	
	/**
	 * Given any integer, return the binary representation as string.
	 * @param i
	 * @param padding true if add padding 0 at left.
	 * @return
	 */
	public static String toBinary(int i, boolean padding) {
		StringBuilder builder = new StringBuilder();
		int shift = 0;
		while (i != 0) {
			if ((i & 1) == 1)
				builder.insert(0, "1");
			else
				builder.insert(0, "0");
			i >>>= 1;
			shift++;
		}
		
		if (padding) {
			for (int n = shift + 1; n <= 32; n++)
				builder.insert(0, "0");
		}
		
		return builder.toString();
	}
	
	public static String toBinary(int i) {
		return toBinary(i, true);
	}
	
	
	public static void main(String[] args) {
		Random random = new Random();
		int i = random.nextInt();
		System.out.println(i);
		System.out.println(toBinary(i, true));
	}
	
}
