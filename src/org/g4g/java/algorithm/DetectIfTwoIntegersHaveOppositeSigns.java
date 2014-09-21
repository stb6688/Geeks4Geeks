package org.g4g.java.algorithm;

/**
 * 
Given two signed integers, write a function that returns true if the signs of given integers are different, 
otherwise false. For example, the function should return true -1 and +100, and should return false for -100 and -200. 
The function should not use any of the arithmetic operators.

 * @author AlexTheGreat
 * @date Sep 21, 2014
 */
public class DetectIfTwoIntegersHaveOppositeSigns {
	
	/**
	 * 1 XOR operation; if a and b have opposite sign,
	 * leftmost bit is 1, thus result is negative.
	 * For integer, sign is essentially determined by the leftmost bit (bit 31 from right).
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isOppositeSign(int a, int b) {
		return (a ^ b) < 0;
	}
	
	// SOLUTION I: compare leftmost bit
//	public boolean isOppositeSign(int a, int b) {
//		int mask = 1;
//		mask <<= 31;
//		return (a & mask) != (b & mask);
//	}
	
	
	public static void main(String[] args) {
		DetectIfTwoIntegersHaveOppositeSigns instance = new DetectIfTwoIntegersHaveOppositeSigns();
		boolean result;
		int a, b;
		
//		a = -1; b = 100; // true
//		a = -100; b = -200; // false
		a = 200; b = 0; // false
		
		result = instance.isOppositeSign(a, b);
		System.out.println(">> Result=" + result);
	}

}
