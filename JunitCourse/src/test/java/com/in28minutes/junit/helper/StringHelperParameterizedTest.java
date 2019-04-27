package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	private StringHelper helper = new StringHelper();
	private String input;
	private String expectedOutput;

	public StringHelperParameterizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
		System.out.println("Constructor: Input: " + input + "    Output: " + expectedOutput);
	}
	
	@Parameters
	public static Collection<String[]> testConditions() {
		String[][] expectedOutputs = { 
			{ "AACD", "CD" },
			{ "AD", "CD" } 
		};
		System.out.println("Load Test Conditions");
		return Arrays.asList(expectedOutputs);
	}

	// AACD => CD ACD => CD CDEF => CDEF CDAA => CDAA
	@Test
	public void truncateAInFirst2Positions_AInFirst2Positions() {
		// expected, actual
		System.out.println("Test Execution");
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}

}
