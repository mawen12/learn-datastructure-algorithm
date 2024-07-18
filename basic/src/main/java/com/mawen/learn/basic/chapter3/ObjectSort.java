package com.mawen.learn.basic.chapter3;

/**
 * Object sort
 *
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @see 3.4
 * @since 2024/7/16
 */
public class ObjectSort {

	private Person[] arr;
	private int nElems;

	public ObjectSort(int max) {
		arr = new Person[max];
		nElems = 0;
	}

	public void insert(String last, String first, int age) {
		arr[nElems] = new Person(last, first, age);
		nElems++;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			arr[i].displayPerson();
		}
		System.out.println("");
	}

	public void insertionSort() {
		int in, out;

		for(out = 1; out < nElems; out++) {
			Person temp = arr[out];
			in = out;

			while (in > 0 && arr[in - 1].getLast().compareTo(temp.getLast()) > 0) {
				arr[in] = arr[in - 1];
				--in;
			}

			arr[in] = temp;
		}
	}

	static class ObjectSortApp {
		public static void main(String[] args) {
			int maxSize = 100;
			ObjectSort arr = new ObjectSort(maxSize);

			arr.insert("Evans","Patty",24);
			arr.insert("Smith","Doc",59);
			arr.insert("Smith","Lorraine",37);
			arr.insert("Smith","Paul",37);
			arr.insert("Yee","Tom",43);
			arr.insert("Hashimoto","Sato",21);
			arr.insert("Stimson","Henry",29);
			arr.insert("Velasquez","Jose",72);
			arr.insert("Vang","Minh",22);
			arr.insert("Creswell","Lucinda",18);

			System.out.println("Before sorting:");
			arr.display();

			arr.insertionSort();

			System.out.println("After sorting:");
			arr.display();
		}
	}

	static class Person {
		private String lastName;
		private String firstName;
		private int age;

		public Person(String lastName, String firstName, int age) {
			this.lastName = lastName;
			this.firstName = firstName;
			this.age = age;
		}

		public void displayPerson() {
			System.out.print("  Last name: " + lastName);
			System.out.print(", First name: " + firstName);
			System.out.println(", Age: " + age);
		}

		public String getLast() {
			return lastName;
		}
	}
}
