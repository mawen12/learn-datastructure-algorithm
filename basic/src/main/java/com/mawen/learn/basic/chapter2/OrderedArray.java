package com.mawen.learn.basic.chapter2;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @see 2.4
 * @since 2024/6/12
 */
public class OrderedArray {

	private final long[] a;

	private int nElems;

	public OrderedArray(int capacity) {
		a = new long[capacity];
		nElems = 0;
	}

	private int size() {
		return nElems;
	}

	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey) {
				return curIn; // found it
			}
			else if (lowerBound > upperBound) {
				return nElems; // can't find it
			}
			else { // divide range
				if (a[curIn] < searchKey) {
					lowerBound = curIn + 1; // it's in upper half
				}
				else {
					upperBound = curIn - 1; // it's in lower half
				}
			}
		}
	}

	/**
	 * put element into array
	 */
	public void insert(long value) {
		int j;
		for (j = 0; j < nElems; j++) { // find where it goes
			if (a[j] > value) { // (linear search)
				break;
			}
		}


		for (int k = nElems; k > j; k--) { // move bigger ones up
			a[k] = a[k - 1];
		}

		a[j] = value;   // insert it
		nElems++;       // increment size
	}

	public boolean delete(long value) {
		int j = find(value);
		if (j == nElems) { // can't find it
			return false;
		}
		else { // found it
			for (int k = j; k < nElems; k++) { // move bigger ones down
				a[k] = a[k + 1];
			}
			nElems--; // decrement size
			return true;
		}
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

	static class OrderedApp {
		public static void main(String[] args) {
			int maxSize = 100; // array size
			OrderedArray arr; // reference to array
			arr = new OrderedArray(maxSize); // create the array

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

			int searchKey = 55; // search for item
			if (arr.find(searchKey) != arr.size()) {
				System.out.println("Found " + searchKey);
			}
			else {
				System.out.println("Can't find " + searchKey);
			}

			arr.display(); // display items

			arr.delete(00); // delete 3 items
			arr.delete(55);
			arr.delete(99);

			arr.display(); // display items again
		}
	}
}
