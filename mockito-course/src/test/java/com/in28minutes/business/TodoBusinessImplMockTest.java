package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28Minutes.business.TodoBusinessImpl;
import com.in28Minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplMockTest {
	/*
		 What is mocking?
		 Mocking is creating objects that simulate the behavior of real objects.
		 Unlike Stubs, Mocks can be dynamicaly created from code - at runtime.
		 Mocks offer more functionality than stubbing.
		 You can verify method calls and a lot of other things.
	 */

	@Test
	public void retrieveTodosRelatedToSpring_usingAMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos =  Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void retrieveTodosRelatedToSpring_usingAMockWithEmptyList() {
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos =  Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void retrieveTodosRelatedToSpring_usingBDD() {
		// Use BDD is very similar like normal test. Is a way to organize test
		// Given - Setup
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos =  Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When - Execution
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		// Then - Check
		assertThat(filteredTodos.size(), is(2));
	}

}
