package com.mawen.learn.basic.chapter3;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/15
 */
public class BubbleSort {

	/**
	 * ref to array a
	 */
	private long[] a;

	/**
	 * number of data items
	 */
	private int nElems;

	public BubbleSort(int n) {
		a = new long[n];
		nElems = 0;
	}

	/**
	 * put element into array
	 */
	public void insert(long value) {
		// insert it
		a[nElems] = value;
		// increment size
		nElems++;
	}

	/**
	 * displays array contents
	 */
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

	public void bubbleSort() {
		int out, in;

		for (out = nElems - 1; out > 1; out--) { // outer loop (backward)
			for (in = 0; in < out; in++) { // inner loop (forward)
				if (a[in] > a[in + 1]) { // out of order?
					swap(in, in + 1); // swap item
				}
			}
		}
	}

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}

	private static class BubbleSortApp {
		public static void main(String[] args) {
			int maxSize = 100;
			BubbleSort arr;
			arr = new BubbleSort(maxSize);

			arr.insert(77);
			arr.insert(99);
			arr.insert(44);
			arr.insert(55);
			arr.insert(22);
			arr.insert(88);
			arr.insert(11);
			arr.insert(00);
			arr.insert(66);
			arr.insert(33);

			arr.display();

			arr.bubbleSort(); // bubble sort item

			arr.display();
		}
	}
}
