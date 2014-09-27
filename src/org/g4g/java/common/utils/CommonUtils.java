package org.g4g.java.common.utils;

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
		array[i] ^= array[j];
		array[j] ^= array[i];
		array[i] ^= array[j];
	}
	
	
	public static void main(String[] args) {
		System.out.println(urlToClass("http://geeksquiz.com/binary-search/"));
	}

}
