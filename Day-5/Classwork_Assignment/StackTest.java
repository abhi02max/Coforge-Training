package com.coforge.day5.classwork;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(20);

		System.out.println(stack);

		stack.pop();

		System.out.println(stack);

		System.out.println(stack.peek());

		System.out.println(stack);
	}

}