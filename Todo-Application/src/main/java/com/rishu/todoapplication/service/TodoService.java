package com.rishu.todoapplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rishu.todoapplication.entity.Todo;

@Service
public class TodoService 
{
	
	List<Todo>todos = new ArrayList<>();

	public ResponseEntity<Todo> createTodo(Todo todo) {
		// TODO Auto-generated method stub
		Todo obj = new Todo();
		Date currentDate = new Date();
		obj.setId(todo.getId());
		obj.setContent(todo.getContent());
		obj.setStatus(todo.getStatus());
		obj.setTitle(todo.getTitle());
		obj.setAddedDate(currentDate);
		obj.setToDoDate(todo.getToDoDate());
		todos.add(obj);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}

	public ResponseEntity<List<Todo>> getAllTodos() {
		// TODO Auto-generated method stub
		List<Todo>list = new ArrayList<>();
		for(Todo t : todos)
		{
			list.add(t);
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	public ResponseEntity<Todo> getTodoById(Integer id) {
		// TODO Auto-generated method stub
		
		for(Todo t : todos)
		{
			if(t.getId() == id)
			{
				return new ResponseEntity<>(t, HttpStatus.OK);
			}
		}
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Todo> updateTodo(Todo todo, Integer id) {
		// TODO Auto-generated method stub
		for(Todo t : todos)
		{
			if(t.getId() == id)
			{
				t.setId(todo.getId());
				t.setContent(todo.getContent());
				t.setStatus(todo.getStatus());
				t.setTitle(todo.getTitle());
				return new ResponseEntity<>(t,HttpStatus.OK);
			}
			
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}

	public ResponseEntity<String> deleteTodo(Integer id) {
		// TODO Auto-generated method stub
		Iterator<Todo> iterator = todos.iterator();
	    
	    while (iterator.hasNext()) {
	        Todo t = iterator.next();
	        
	        if (t.getId() == id) {
	            iterator.remove();  
	            return new ResponseEntity<>("Deleted", HttpStatus.OK);
	        }
	    }
	    
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
