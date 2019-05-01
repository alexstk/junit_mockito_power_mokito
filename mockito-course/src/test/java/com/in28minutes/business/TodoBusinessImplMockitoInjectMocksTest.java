package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28Minutes.business.TodoBusinessImpl;
import com.in28Minutes.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	

	@Test
	public void retrieveTodosRelatedToSpring_usingAMock() {
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void retrieveTodosRelatedToSpring_usingAMockWithEmptyList() {
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(0, filteredTodos.size());
	}

	@Test
	public void retrieveTodosRelatedToSpring_usingBDD() {
		// Use BDD is very similar like normal test. Is a way to organize test
		// Given - Setup
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When - Execution
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Then - Check
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then - Check
		// This verifies that deleteTodo() is called any number of times with "Learn to
		// Dance" as an argument
		verify(todoServiceMock).deleteTodo("Learn to Dance");

		// This verifies that deleteTodo() is called 1 time with "Learn to Dance" as an
		// argument
		verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");

		// This verifies that deleteTodo() is called at least 1 time with "Learn to
		// Dance" as an argument
		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Dance");

		// This verifies that deleteTodo() is called at least 1 times with "Learn to
		// Dance" as an argument
		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");

		// This verifies that deleteTodo() is never called with "Learn Spring MVC" as an
		// argument
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDDWithGivenThenWhenSintax() {
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then - Check
		// This is equivalent to the verify. The difference is this is BDD style
		then(todoServiceMock).should().deleteTodo("Learn to Dance");
		then(todoServiceMock).should(times(1)).deleteTodo("Learn to Dance");
		then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn to Dance");
		then(todoServiceMock).should(atLeast(1)).deleteTodo("Learn to Dance");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {

		/*
		 * Steps to use an Argument Captor 1. Declare argument captor 2. Define argument
		 * captor on specific method call 3. Check captured argument
		 */

		// Given

		List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentsCapture() {
		/*
		Steps to use an Argument Captor 
			1. Declare argument captor
			2. Define argument captor on specific method call
			3. Check captured argument
		 */
		
		// Given
		List<String> todos =  Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		// Then 
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(
				stringArgumentCaptor.getAllValues(), 
				is(Arrays.asList(
						"Learn to Rock and Roll",
						"Learn to Dance"
		)));
	}
}
