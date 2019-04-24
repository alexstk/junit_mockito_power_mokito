package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	StringHelper helper = new StringHelper();

	@Test
	public void truncateAInFirst2Positions_AInFirst2Positions() {
		// AACD => CD	ACD => CD	CDEF => CDEF	CDAA => CDAA
		// expected, actual
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
		
	}

	@Test
	public void truncateAInFirst2Positions2_AInFirstPositions() {
		// expected, actual
		assertEquals("CDA", helper.truncateAInFirst2Positions("CDA"));
		
		
	}
}
