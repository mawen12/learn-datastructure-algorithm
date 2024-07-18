package com.mawen.learn.basic.chapter3;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/18
 */
public class SelectionSort {

	private long[] a;

	private int nElems;

	public SelectionSort(int max) {
		a = new long[max];
		nElems = 0;
	}

	/**
	 * put element into array
	 */
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	/**
	 * displays array contents
	 */
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void selectionSort() {
		int out, in, min;

		for (out = 0; out < nElems - 1; out++) { // outer loop
			min = out; // minimum
			for (in = out + 1; in < nElems; in++) { // inner loop
				if (a[in] < a[min]) {// if min greater
					min = in; // we have a new min
				}
			}
			swap(out, min); // swap them
		}
	}

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}

	private static class SelectionSortApp {

		public static void main(String[] args) {
			int maxSize = 100;
			SelectionSort arr;
			arr = new SelectionSort(maxSize);

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

			arr.selectionSort(); // selection-sort them

			arr.display();
		}

	}
}
