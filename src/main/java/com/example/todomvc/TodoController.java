package com.example.todomvc;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/todo")
public class TodoController {
	
	private static final Logger log = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	private TodoRepository repository;
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Todo findById(@PathVariable(value = "id") long id) {		
		log.info(">>>>>>>> TodoController - findById <<<<<<<<<<<");
		
		return repository.findOne(id);	
	}
	
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public Todo save(@RequestBody Todo newTodo) {
		log.info(">>>>>>>> TodoController - save <<<<<<<<<<<");
		
		Todo saved = repository.save(newTodo);
		
		return saved;
	}
	
	@RequestMapping(path = "/all")
	public List<Todo> findAll(){		
		log.info(">>>>>>>> TodoController - findAll <<<<<<<<<<<");
		
		return (List<Todo>) repository.findAll();
	}
	
	
	@RequestMapping(path = "/populate")
	public List<Todo> populate() {
		log.info(">>>>>>>> TodoController - populate <<<<<<<<<<<");
		
		Todo savedA = repository.save(new Todo("AAA", true, 1));
		Todo savedB = repository.save(new Todo("BBB", false, 2));
		Todo savedC = repository.save(new Todo("CCC", true, 3));	
		
		return Arrays.asList(savedA, savedB, savedC);
	}
}