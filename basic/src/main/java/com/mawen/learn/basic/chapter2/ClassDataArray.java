package com.mawen.learn.basic.chapter2;

import java.util.Arrays;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @see 2.5
 * @since 2024/6/13
 */
public class ClassDataArray {

	private Person[] a;

	private int nElems;

	public ClassDataArray(int max) {
		a = new Person[max];
		nElems = 0;
	}

	public Person find(String searchName) {
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j].getLast().equals(searchName)) {
				break;
			}
		}
		if (j == nElems) {
			return null;
		}
		else {
			return a[j];
		}
	}

	public void insert(String last, String first, int age) {
		a[nElems] = new Person(last, first, age);
		nElems++;
	}

	public boolean delete(String searchName) {
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j].getLast().equals(searchName)) {
				break;
			}
		}

		if (j == nElems) {
			return false;
		}
		else {
			for (int k = j; k < nElems; k++) {
				a[k] = a[k + 1];
			}
			nElems--;
			return true;
		}
	}

	public void displayA() {
		for (int i = 0; i < nElems; i++) {
			a[i].displayPerson();
		}
	}

	private static class Person {

		private String lastName;
		private String firstName;
		private int age;

		public Person(String lastName, String firstName, int age) {
			this.lastName = lastName;
			this.firstName = firstName;
			this.age = age;
		}

		public void displayPerson() {
			System.out.print(" Last name: " + lastName);
			System.out.print(", First name: " + firstName);
			System.out.println(", Age: " + age);
		}

		public String getLast() {
			return this.lastName;
		}
	}

	private static class ClassDataApp {
		public static void main(String[] args) {
			int maxSize = 100;
			ClassDataArray arr;
			arr = new ClassDataArray(maxSize);

			arr.insert("Evans", "Patty", 24);
			arr.insert("Smith","Lorraine", 37);
			arr.insert("Yee","Tom",43);
			arr.insert("Adams","Henry",63);
			arr.insert("Hashimoto","Sato",21);
			arr.insert("Stimson","Henry", 29);
			arr.insert("Velasquez", "Jose", 72);
			arr.insert("Lamarque","Henry",54);
			arr.insert("Vang","Minh",22);
			arr.insert("Creswell", "Lucinda", 18);

			arr.displayA();

			String searchKey = "Stimson";
			Person found;
			found = arr.find(searchKey);
			if (found != null) {
				System.out.print("Found ");
				found.displayPerson();
			}
			else {
				System.out.println("Can't find " + searchKey);
			}

			System.out.println("Deleting Smith, Yee, and Creswell");
			arr.delete("Smith");
			arr.delete("Yee");
			arr.delete("Creswell");

			arr.displayA();
		}
	}

}
