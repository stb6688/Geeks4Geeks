package org.g4g.java.algorithm.sort.strategy;

import org.g4g.java.algorithm.sort.ISort;
import org.g4g.java.algorithm.sort.SortTest;
import org.g4g.java.common.utils.CommonUtils;

/**
 * Add all the data to heap (priority queue), then keep extracting root 
 * and add to array, until the heap is empty.
 * @author AlexTheGreat
 * @date Sep 27, 2014
 */
public class HeapSort implements ISort {
	
	class Heap {
		private int[] data;
		private int size = 0;
		
		Heap(int totalSize) {
			this.data = new int[totalSize];
			this.size = 0;
		}
		
		void add(int i) {
			data[size] = i;
			size++;
			bubbleUp(size - 1);
		}
		
		int extractRoot() {
			int root = data[0];
			data[0] = data[size - 1];
			size--;
			bubbleDown(0);
			
			return root;
		}
		
		boolean isEmpty() {
			return this.size == 0;
		}
		
		void bubbleUp(int index) {
			int currIndex = index;
			int curr = data[currIndex];
			int parentIndex = (currIndex - 1)/2;
			while (parentIndex >= 0 && curr < data[parentIndex]) {
				CommonUtils.swap(data, parentIndex, currIndex);
				currIndex = parentIndex;
				parentIndex = (currIndex - 1)/2;
			}
			
			// NOTE: bubbleDown() is not needed; if a child is less than
			// parent, then it will be bubble up to become the new parent,
			// and it is guaranteed to be less than the other child.
			// L < Root, root < R --> L becomes new root
			// L < Root, Root < R --> L (new root) < R.
			// bubbleDown(currIndex);
		}
		
		void bubbleDown(int index) {
			int currIndex = index;
			int curr = data[currIndex];
			while (true) {
				int leftIndex  = currIndex*2 + 1;
				int rightIndex = currIndex*2 + 2;
				if ((leftIndex >= size || curr <= data[leftIndex]) 
						&& (rightIndex >= size || curr <= data[rightIndex]))
					return;
				else {
					int nextIndex = leftIndex;
					if (rightIndex < size && data[rightIndex] < data[leftIndex])
						nextIndex = rightIndex;
					CommonUtils.swap(data, currIndex, nextIndex);
					currIndex = nextIndex;
				}
			}
		}
	}

	@Override
	public void sort(int[] array) {
		Heap heap = new Heap(array.length);
		for (int i : array)
			heap.add(i);
		int index = 0;
		while (!heap.isEmpty()) {
			array[index++] = heap.extractRoot();
		}
	}
	
	
	public static void main(String[] args) {
		SortTest test = new SortTest(13, false, true, true);
		test.test(new HeapSort(), 100);
	}
	
}
