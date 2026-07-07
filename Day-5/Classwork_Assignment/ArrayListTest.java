package com.coforge.day5.classwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();

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
		Iterator<Integer> it = list1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}