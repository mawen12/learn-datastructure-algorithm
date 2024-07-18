package com.mawen.learn.basic.chapter3;

/**
 * Insert sort
 *
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @see 3.3
 * @since 2024/6/28
 */
public class InsertSort {

	private long[] arr;
	private int nElems;

	public InsertSort(int max) {
		this.arr = new long[max];
		this.nElems = 0;
	}

	public void insert(long value) {
		arr[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void insertSort() {
		int in, out;

		for (out = 1; out < nElems; out++) {
			long temp = arr[out];
			in = out;
			while (in > 0 && arr[in - 1] >= temp) {
				arr[in] = arr[in - 1];
				--in;
			}
			arr[in] = temp;
		}
	}

	private static class InsertSortApp {
		public static void main(String[] args) {
			int maxSize = 100;
			InsertSort arr = new InsertSort(maxSize);

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

			arr.insertSort();

			arr.display();
		}
	}
}
