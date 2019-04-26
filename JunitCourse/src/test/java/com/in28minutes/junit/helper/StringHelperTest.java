package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {
	
	StringHelper helper;
	
	@Before
	public void setup() {
		helper = new StringHelper();
	}
	
	

	// AACD => CD	ACD => CD	CDEF => CDEF	CDAA => CDAA
	@Test
	public void truncateAInFirst2Positions_AInFirst2Positions() {
		// expected, actual
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void truncateAInFirst2Positions2_AInFirstPositions() {
		assertEquals("CDA", helper.truncateAInFirst2Positions("CDA"));
	}

	
	// ABCD => false,	ABAB =>	true,	AB => true,  A => false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Basic_Negative_Scenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Basic_Positive_Scenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Two_Characters_Scenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_One_Character_Scenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
	}


}
