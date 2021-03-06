package com.in28Minutes.powermock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SystemUnderTest {
	private Dependency dependency;

	public int methodUsingAnArrayListConstructor() {
		ArrayList list = new ArrayList();
		return list.size();
	}

	public int methodCallingAStaticMethod() {
		//privateMethodUnderTest calls static method SomeClass.staticMethod
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for (int stat : stats)
			sum += stat;
		return UtilityClass.staticMethod(sum);
	}

	private long privateMethodUnderTest() {
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for (int stat : stats)
			sum += stat;
		return sum;
	}

	private static long privateStaticMethodUnderTest() {
		List<Integer> stats = Arrays.asList(1, 2, 3);
		long sum = 0;
		for (int stat : stats)
			sum += stat;
		return sum;
	}

	private static void privateStaticVoidMethodUnderTest() {
		List<Integer> stats = Arrays.asList(1, 2, 3);
		long sum = 0;
		for (int stat : stats)
			sum += stat;
	}
}