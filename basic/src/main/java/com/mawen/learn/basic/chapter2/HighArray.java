package com.mawen.learn.basic.chapter2;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/11
 */
public class HighArray {

	/**
	 * ref to array a
	 */
	private long[] a;
	/**
	 * number of data items
	 */
	private int nElems;

	public HighArray(int size) {
		a = new long[size]; // create the array
		nElems = 0; // no items yet
	}

	/**
	 * find specified value
	 */
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems; j++) { // for each element
			if (a[j] == searchKey) { // found items?
				break; // exit loop before end
			}
		}

		if (j == nElems) { // gone to end?
			return false; // yes, can't find it
		}
		else {
			return true; // no, found it
		}
	}

	/**
	 * put element into array
	 */
	public void insert(long value) {
		a[nElems] = value; // insert it
		nElems++; //increment size
	}

	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++) { // look for it
			if (a[j] == value) {
				break;
			}
		}

		if (j == nElems) { // can't find it
			return false;
		}
		else { // found it
			for (int k = j; k < nElems; k++) { // move higher ones down
				a[k] = a[k + 1];
			}
			nElems--; // decrement size
			return true;
		}
	}

	/**
	 * display items
	 */
	public void display() {
		for (int i = 0; i < nElems; i++) { // for each element
			System.out.print(a[i] + " "); // display it
		}
		System.out.println(" ");
	}

	public long getMax() {
		int maxIndex = getMaxIndex();

		if (nElems == maxIndex) {
			return -1L;
		}
		return a[maxIndex];
	}

	public void removeMax() {
		int maxIndex = getMaxIndex();

		for (int i = maxIndex; i < nElems; i++) {
			a[i] = a[i + 1];
		}
		nElems--;
	}

	private int getMaxIndex() {
		int maxIdx = 0;
		for (int j = 1; j < nElems; j++) {
			if (a[maxIdx] < a[j]) {
				maxIdx = j;
			}
		}

		return maxIdx;
	}

	static class HighArrayApp {

		public static void main(String[] args) {
			int maxSize = 100; // array size
			HighArray arr; // reference to array
			arr = new HighArray(maxSize); // create the array

			arr.insert(77); // insert 10 items
			arr.insert(99);
			arr.insert(44);
			arr.insert(55);
			arr.insert(22);
			arr.insert(88);
			arr.insert(11);
			arr.insert(00);
			arr.insert(66);
			arr.insert(33);

			arr.display(); // display items

			System.out.println(arr.getMax());
			arr.removeMax();

			arr.display();

			int searchKey = 35; // search for item
			if (arr.find(searchKey)) {
				System.out.println("Found " + searchKey);
			}
			else {
				System.out.println("Can't find " + searchKey);
			}

			arr.delete(00); // delete 3 items
			arr.delete(55);
			arr.delete(99);

			arr.display(); // display items again
		}
	}
}
