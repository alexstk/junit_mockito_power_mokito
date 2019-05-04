package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.in28Minutes.powermock.SystemUnderTest;

@RunWith(PowerMockRunner.class )
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {

	/*
	Steps for mocking a constructor:
	1.	Prepare for test the class who has the constructor -> SystemUnderTest
	2.	Override the constructor
	*/
	
	@Mock
	ArrayList mockList;
	
	@InjectMocks
	SystemUnderTest systemUnderTest ;

	@Test
	public void methodUsingAnArrayListConstructor_MockArrayListUsingAMock_Ok() throws Exception {
		when(mockList.size()).thenReturn(10);
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		assertEquals(10, mockList.size());
	}

}
