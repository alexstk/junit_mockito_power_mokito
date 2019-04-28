package com.in28Minutes.data.api;

import java.util.List;

public interface TodoService {
	List<String> retrieveTodos(String user);
}
