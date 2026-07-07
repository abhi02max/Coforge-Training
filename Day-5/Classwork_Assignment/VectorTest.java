package com.coforge.day5.classwork;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {

		Vector<Integer> list1 = new Vector<>();

		list1.add(new Integer(10));// boxing
		list1.add(20);// directly converting primitive to object which is autoboxing
		list1.add(30);
		list1.add(40);
		list1.add(50);
		list1.add(20);

		System.out.println(list1);

		System.out.println(list1.get(2));

		list1.remove(3);

		list1.set(3, 20);

		System.out.println(list1);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(i + " " + list1.get(i));
		}

		// Traverse without index
		for (Integer i : list1) {
			System.out.println(i);
		}

		// Traverse using Iterator
		Iterator<Integer> it = list1.iterator();//common interface for all
		while (it.hasNext()) {
			System.out.println(it.next());

			//Traverse using Enumeration only for vector
			Enumeration<Integer> en = list1.elements(); //legacy interface
		}
	}
}