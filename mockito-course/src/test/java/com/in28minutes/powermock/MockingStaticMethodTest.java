package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.in28Minutes.powermock.Dependency;
import com.in28Minutes.powermock.SystemUnderTest;
import com.in28Minutes.powermock.UtilityClass;

@RunWith(PowerMockRunner.class )
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {

	// Combine mockito and powermockito
	// 1.Specify class runner
	// 2.Initialize class with static methods to be mocked
	// 3.Mock the particular static method
	
	// Note that PowerMockRunner, is compatible with @Mock, @InjectMocks, @Captor
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest ;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	// Standard mocking with mockito! Nothing special yet!
	@Test
	public void methodCallingAStaticMethod_MockingStaticMethod_MockingOk() {
		List<Integer> stats = Arrays.asList(1, 2, 3);
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		PowerMockito.mockStatic(UtilityClass.class);
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		int result = systemUnderTest.methodCallingAStaticMethod();
		assertEquals(150, result);
	}
	
	@Test
	public void methodCallingAStaticMethod_MockingStaticMethodVerifingStaticMethodCall_MockingOk() {
		List<Integer> stats = Arrays.asList(1, 2, 3);
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		// Note that after static power mocking, Mockito.when() of a static method works fine like PowerMokito.when() would do
		PowerMockito.mockStatic(UtilityClass.class);
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		int result = systemUnderTest.methodCallingAStaticMethod();
		assertEquals(150, result);
		
		PowerMockito.verifyStatic();	// Verifies next mocked static method
		//UtilityClass.staticMethod(6);	// This is the call we want to verify
		
	}
}
