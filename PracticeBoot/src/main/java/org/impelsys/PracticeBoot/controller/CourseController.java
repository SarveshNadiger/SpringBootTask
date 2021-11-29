package org.impelsys.PracticeBoot.controller;

import java.util.List;

import javax.validation.Valid;

import org.impelsys.PracticeBoot.model.Course;
import org.impelsys.PracticeBoot.model.User;
import org.impelsys.PracticeBoot.service.CourseService;
import org.impelsys.PracticeBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService crsservice;
	
	
	@Autowired
	private UserService service;
	
	@PostMapping("/addCourse")
	public Course addCourse(@Valid @RequestBody Course  course) {
		return crsservice.saveCourse(course);
		
		
	}
	@PostMapping("/addCourses")
	public List<Course> addCourses(@Valid @RequestBody List<Course> courses){
		return crsservice.saveCourses(courses);
	}
	
	@GetMapping("/courses")
	public List<Course> findAllCourses(){
		return crsservice.getCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Course findCourseById(@PathVariable int id) {
		return crsservice.getCourseById(id);
	}
	
	@DeleteMapping("/deletecourse/{id}")
	public String deleteCourse(@PathVariable int id) {
		return crsservice.deleteCourse(id);
	}
	@PutMapping("{courseID}/users/{userID}")
	public Course enrollUsertoCourse(
			@PathVariable int courseID,
			@PathVariable int userID
			) {
		Course course = crsservice.getCourseById(courseID);
		User user =  service.getUserById(userID);
		course.enrolledUser(user);
		return crsservice.saveCourse(course);
	}

}
