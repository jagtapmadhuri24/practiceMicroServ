package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	
	@GetMapping(path="/users")
	public List<User> retriveAllUser(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Integer id){
		User user= userDaoService.findOne(id);

	if(user==null){
		throw new UserNotFoundException("ID: "+id);
		
	}
	
	return user;
	
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser=userDaoService.save(user);
		//this will provide the url from where you can access the created resource.
		URI uri=ServletUriComponentsBuilder.fromCurrentContextPath().path("users/{id}").buildAndExpand(savedUser.getId()).toUri();
		System.out.println("URI  "+uri);
		//return ResponseEntity.ok(uri);
		return ResponseEntity.created(uri).build(); // the response(created uri) will be in header of response.
	}

	@DeleteMapping("users/{id}")
	public void deleteById(@PathVariable int id){
	User user= userDaoService.deletebyId(id);
		if(user==null){
			throw new UserNotFoundException("ID "+id);
		}
		
	}
	
	
	
}
