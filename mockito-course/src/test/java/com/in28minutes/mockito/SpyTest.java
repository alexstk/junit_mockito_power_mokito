package com.in28minutes.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Spy;

public class SpyTest {
	// Mocks return default value
	// A mock does not get any logic from actual class it is mocking
	// A spy does get all logic from actual class it is spying. Spy is also called a Partial Method
	// We can use @Spy like @Mock
	@Test
	public void testWithMock() {
		List arrayListMock = mock(ArrayList.class);
		assertEquals(0, arrayListMock.size());

		arrayListMock.add("Dummy");
		assertEquals(0, arrayListMock.size());

		stub(arrayListMock.size()).toReturn(5);
		assertEquals(5, arrayListMock.size());
	}

	@Test
	public void testWithSpy() {
		List arrayListSpy = spy(ArrayList.class);
		assertEquals(0, arrayListSpy.size());
		
		arrayListSpy.add("Dummy");
		assertEquals(1, arrayListSpy.size());
		
		arrayListSpy.remove("Dummy");
		assertEquals(0, arrayListSpy.size());

		// In a spy we can override any method to give the behavior we want
		stub(arrayListSpy.size()).toReturn(5);
		assertEquals(5, arrayListSpy.size());
	}

	@Test
	public void testWithSpyAndVerify() {
		List arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Dummy");
		verify(arrayListSpy).add("Dummy");
		verify(arrayListSpy, never()).remove(0);

	}
}
