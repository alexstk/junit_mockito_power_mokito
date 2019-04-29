package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

import com.in28Minutes.data.api.TodoService;

// This is a sample implementation of TodoService
public class TodoServiceStub implements TodoService {
	
	// Stub problems
	// Dynamic Conditions
	// Service Definition
	
	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	@Override
	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
