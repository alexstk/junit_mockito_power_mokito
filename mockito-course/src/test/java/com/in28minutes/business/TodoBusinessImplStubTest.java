package com.in28minutes.business;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.in28Minutes.business.TodoBusinessImpl;
import com.in28Minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void retrieveTodosRelatedToSpring_usingAStub() {
		
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
	
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size());
		
	}
	
	@Test
	public void retrieveTodosRelatedToSpring_usingAStub_checkingValues() {
		
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
	
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		String[] expectedTodos= {"Learn Spring MVC", "Learn Spring"};
				
		assertArrayEquals(filteredTodos.toArray(), expectedTodos);
		
	}

}
