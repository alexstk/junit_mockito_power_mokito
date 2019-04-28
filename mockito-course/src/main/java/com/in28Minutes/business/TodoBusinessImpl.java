package com.in28Minutes.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.in28Minutes.data.api.TodoService;

public class TodoBusinessImpl {
	
	private TodoService todoService;
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<>();
		List<String> todos = todoService.retrieveTodos(user);
		
		// Using lambda
		filteredTodos = todos.stream().filter(todo -> "Spring".contains(todo)).collect(Collectors.toList());
		
		/*for (String todo : todos) {
			if(todo.contains("Spring"))
				filteredTodos.add(todo);
		}*/
		
		
		
		return filteredTodos;
	}

}
