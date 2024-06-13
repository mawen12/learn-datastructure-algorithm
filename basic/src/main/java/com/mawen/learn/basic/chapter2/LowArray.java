package com.mawen.learn.basic.chapter2;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @see 2.2
 * @since 2024/6/7
 */
public class LowArray {

	/**
	 * ref to array a
	 */
	private long[] a;

	public LowArray(int size) {
		// create array
		this.a = new long[size];
	}

	/**
	 * set value
	 */
	public void setElem(int index, long value) {
		a[index] = value;
	}

	/**
	 * get value
	 */
	public long getElem(int index) {
		return a[index];
	}


	static class LowArrayApp {

		public static void main(String[] args) {
			LowArray arr; // reference
			arr = new LowArray(100); // create LowArray object
			int nElems = 0; // number of items in array
			int j; // loop variable

			arr.setElem(0, 77); // insert 10 items
			arr.setElem(1, 99);
			arr.setElem(2, 44);
			arr.setElem(3, 55);
			arr.setElem(4, 22);
			arr.setElem(5, 88);
			arr.setElem(6, 11);
			arr.setElem(7, 00);
			arr.setElem(8, 66);
			arr.setElem(9, 33);
			nElems = 10; // now 10 items in array

			// display items
			for (j = 0; j < nElems; j++) {
				System.out.print(arr.getElem(j) + " ");
			}
			System.out.println("");

			// search for data item
			int searchKey = 26;
			for (j = 0; j < nElems; j++) { // for each element,
				if (arr.getElem(j) == searchKey) { // found item?
					break;
				}
			}
			if (j == nElems) { // no
				System.out.println("Can't found " + searchKey);
			}
			else { // yes
				System.out.println("Found " + searchKey);
			}

			// delete value 35
			for (j = 0; j < nElems; j++) { // look for it
				if (arr.getElem(j) == 55) {
					break;
				}
			}
			for (int k = j; k < nElems; k++) { // higher ones down
				arr.setElem(k,arr.getElem(k + 1));
			}
			nElems--; // decrement size

			// display items
			for (j = 0; j < nElems; j++) {
				System.out.print(arr.getElem(j) + " ");
			}
			System.out.println("");
		}
	}
}
