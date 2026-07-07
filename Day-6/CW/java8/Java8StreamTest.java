package com.coforge.day6.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8StreamTest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 12, 13, 14, 15);

		List<Integer> even = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		System.out.println(even);

		long count = list.stream().filter(n -> n % 2 == 0).count();

		System.out.println(count);

		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		list.stream().filter(n -> n % 2 == 0).map(n -> n * 2).forEach(System.out::println);

		List<String> names = Arrays.asList("valan", "teja", "naresh", "suresh");

		names.stream().filter(s -> s.contains("a")).forEach(s -> System.out.println(s + " : " + s.length()));

		Map<Integer, String> map = names.stream().collect(Collectors.toMap(x -> x.length(), x -> x));

	}
}