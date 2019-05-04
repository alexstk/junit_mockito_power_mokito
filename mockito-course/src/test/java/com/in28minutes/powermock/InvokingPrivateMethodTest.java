package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.in28Minutes.powermock.Dependency;
import com.in28Minutes.powermock.SystemUnderTest;

@RunWith(PowerMockRunner.class )
public class InvokingPrivateMethodTest {

	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest ;

	// WhiteBox is too flexible. It can be used for private, static, void, not void methods. Really cool
	@Test
	public void privateMethodUnderTest_MockingMethod_CallingPrivateMethodOk() throws Exception {
		List<Integer> stats = Arrays.asList(1, 2, 3);
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");

		assertEquals(6, result);
	}

	@Test
	public void privateStaticMethodUnderTest_CallingPrivateStaticMethodOk()  throws Exception {
		long result = Whitebox.invokeMethod(systemUnderTest, "privateStaticMethodUnderTest");
		
		assertEquals(6, result);
	}
	
	@Test
	public void privateStaticVoidMethodUnderTest_CallingPrivateStaticMethodOk() throws Exception {
		Whitebox.invokeMethod(systemUnderTest, "privateStaticVoidMethodUnderTest");
	}
	
}

//@PrepareForTest(SystemUnderTest.class)