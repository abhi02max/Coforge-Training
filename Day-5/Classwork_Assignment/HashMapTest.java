package com.coforge.day5.classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> hashmap = new HashMap<>();
		hashmap.put(10, "Java");
		hashmap.put(20, "Python");
		hashmap.put(40, "Angular");
		hashmap.put(30, "React");
		hashmap.put(50, "CSE");

		System.out.println(hashmap);

		hashmap.put(10, "C++");

		System.out.println(hashmap);

		hashmap.remove(30);

		System.out.println(hashmap);

		System.out.println(hashmap.get(20));

		// Traverse the Map Collection
		Set<Integer> keys = hashmap.keySet();//Because keySet return set
		for (Integer key : keys) {
			System.out.println(key + " " + hashmap.get(key));
		}

		Set<Entry<Integer, String>> entries = hashmap.entrySet();

		for (Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}

	}
}