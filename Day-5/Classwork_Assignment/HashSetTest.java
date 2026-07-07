package com.coforge.day5.classwork;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<>();

		set.add(new Integer(10));
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		set.add(20);
		System.out.println(set);
		set.remove(3);

		// Traverse without index
		for (Integer i : set) {
			System.out.println(i);
		}

		// Traverse using Iterator
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}