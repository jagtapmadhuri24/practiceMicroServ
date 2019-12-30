package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/userJpaApi")
public class UserJPAResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository; 
	
	
	@GetMapping(path="/jpa/users")
	public List<User> retriveAllUser(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable Integer id){
		Optional<User> user= userRepository.findById(id);

	if(!user.isPresent()){
		throw new UserNotFoundException("ID: "+id);
		
	}
	//Resource<User> resource=new Resource<User>(user.get());
	
	return user.get();
	
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser=userRepository.save(user);
		//this will provide the url from where you can access the created resource.
		URI uri=ServletUriComponentsBuilder.fromCurrentContextPath().path("users/{id}").buildAndExpand(savedUser.getId()).toUri();
		System.out.println("URI  "+uri);
		//return ResponseEntity.ok(uri);
		return ResponseEntity.created(uri).build(); // the response(created uri) will be in header of response.
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteById(@PathVariable int id){
		userRepository.deleteById(id);
		
		
	}
	
	
	
}
