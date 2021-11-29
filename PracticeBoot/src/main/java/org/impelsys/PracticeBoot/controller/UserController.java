package org.impelsys.PracticeBoot.controller;

import java.util.List;

import javax.validation.Valid;

import org.impelsys.PracticeBoot.model.User;
import org.impelsys.PracticeBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping("/addUser")
	public User addUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<User> addUsers(@Valid @RequestBody List<User> users) {
		return service.saveUsers(users);
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return service.getUsers();
	}
	@GetMapping("/userbyid/{id}")
	public User findUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
	@GetMapping("/userbyname/{name}")
	public User findUserByName(@PathVariable String name) {
		return service.getUserByName(name);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
	
	/*
	 * @RequestMapping(value="/PagingAndSortingUser/{pageNumber}/{pageSize}",
	 * method= RequestMethod.GET) public Page<User> userPagination(@PathVariable
	 * Integer pageNumber,@PathVariable Integer pageSize ){ return
	 * service.getUserPagination(pageNumber,pageSize); }
	 */
	
	@GetMapping(value = "Pageable")
	 Page userPageable(Pageable pageable) {
	       return service.findUserWithPaggable(pageable);
	   }
	
	
	
	
	

}
