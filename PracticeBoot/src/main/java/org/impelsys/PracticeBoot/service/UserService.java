package org.impelsys.PracticeBoot.service;

import java.util.List;
import java.util.Optional;

import org.impelsys.PracticeBoot.model.User;
import org.impelsys.PracticeBoot.model.UserCourse;
import org.impelsys.PracticeBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public User saveUser(User user) {  //Save single user
		return repository.save(user);
	}
	
	public List<User> saveUsers(List<User> users) {   //save List of user
		return (List<User>) repository.saveAll(users);
	}
	
	public List<User> getUsers(){
		
		return (List<User>) repository.findAll(); // get list of users
		
		
	}
	
	public User getUserById(int id){ // get user by name
		return repository.findById(id).orElse(null); 
	}
	public User getUserByName(String name){ // get user by name
		
		return repository.findByName(name); 
	
	}
	
	public String deleteUser(int id) {  // delete bu id
		repository.deleteById(id);
		return "Sucessfully Delete "+id;
	}
	
	public User updateUser(User user) {
		User currentUser=repository.findById(user.getId()).orElse(null);
		currentUser.setName(user.getName());
		currentUser.setAddress(user.getAddress());
		currentUser.setEmail(user.getEmail());
		currentUser.setPhno(user.getPhno());
		currentUser.setCourses(user.getCourses());
		currentUser.setId(user.getId());
		return repository.save(currentUser);
	}

	/*
	 * public Page<User> getUserPagination(Integer pageNumber, Integer pageSize) {
	 * Sort sort= Sort.by(Sort.Direction.ASC,"name"); Pageable pageable =
	 * PageRequest.of(pageNumber, pageSize, sort); return
	 * repository.findAll(pageable); }
	 */
	
	public Page findUserWithPaggable(Pageable pageable) {
	       return repository.findAll(pageable);
}
	
	
	
}
