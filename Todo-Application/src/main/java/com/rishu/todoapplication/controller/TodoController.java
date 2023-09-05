package com.rishu.todoapplication.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishu.todoapplication.entity.Todo;
import com.rishu.todoapplication.serviceImpl.TodoServiceImpl;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoServiceImpl todoServiceImpl;
	
	@PostMapping("/addTodo")
	public ResponseEntity<Todo>addTodo(@RequestBody Todo todo)
	{
		Todo addedTodo = todoServiceImpl.addTodo(todo);
		return new ResponseEntity<>(addedTodo, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTodo")
	public ResponseEntity<List<Todo>>getAllTodo()
	{
		List<Todo>todos = todoServiceImpl.getAllTodo();
		return new ResponseEntity<>(todos,HttpStatus.OK);
	}
	@GetMapping("/getTodo/{id}")
	public ResponseEntity<Todo>getTodo(@PathVariable Integer id)
	{
		Todo todo = todoServiceImpl.getTodo(id);
		return new ResponseEntity<>(todo,HttpStatus.OK);
	}
	@PutMapping("/updateTodo/{id}")
	public ResponseEntity<Todo>updateTodo(@RequestBody Todo todo , @PathVariable Integer id)
	{
		Todo updatedTodo = todoServiceImpl.updateTodo(todo, id);
		return new ResponseEntity<>(updatedTodo,HttpStatus.OK);
	}
	@DeleteMapping("/deleteTodo/{id}")
	public ResponseEntity<String>deleteTodo(@PathVariable Integer id)
	{
		todoServiceImpl.deleteTodo(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}
	@GetMapping("/getTodoByStatus/{status}")
	public ResponseEntity<List<Todo>>getTodoByStatus(@PathVariable String status)
	{
		List<Todo>todos = todoServiceImpl.getTodoByStatus(status);
		return new ResponseEntity<>(todos,HttpStatus.OK);
	}
	@GetMapping("/getTodoByAddedDate/{addedDate}")
	public ResponseEntity<List<Todo>>getTodoByAddedDate(@PathVariable
    @DateTimeFormat(pattern = "yyyy-MM-dd") Date addedDate)
	{
		List<Todo>todos = todoServiceImpl.getTodoByAddedDate(addedDate);
		return new ResponseEntity<>(todos,HttpStatus.OK);
	}
	@GetMapping("/getTodoByTitle/{title}")
	public ResponseEntity<List<Todo>>getTodoByTitle(@PathVariable String title)
	{
		List<Todo>todos = todoServiceImpl.getTodoByTitle(title);
		return new ResponseEntity<>(todos,HttpStatus.OK);
	}
	@GetMapping("/getTodoByLastDate/{lastDate}")
	public ResponseEntity<List<Todo>>getTodoByLastDate(@PathVariable
		    @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastDate)
	{
		List<Todo>todos = todoServiceImpl.getTodoByLastDate(lastDate);
		return new ResponseEntity<>(todos,HttpStatus.OK);
	}
	
	
	
	

}
