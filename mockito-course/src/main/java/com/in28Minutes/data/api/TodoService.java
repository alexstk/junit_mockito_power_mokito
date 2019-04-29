package com.in28Minutes.data.api;

import java.util.List;

// Create TodoServiceStub
// Test TodoBusinessImpl using TodoServiceStub 
public interface TodoService {
	List<String> retrieveTodos(String user);
	void deleteTodo(String todo);
}
