package org.impelsys.PracticeBoot.service;

import java.util.List;

import org.impelsys.PracticeBoot.model.Course;
import org.impelsys.PracticeBoot.model.User;
import org.impelsys.PracticeBoot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repo;
	
	public Course saveCourse(Course course) {
		return repo.save(course);
	}
	
	public List<Course> saveCourses(List<Course> courses){
		return repo.saveAll(courses);
	}
	
	public List<Course> getCourses(){
		return repo.findAll();
	}
	
	public Course getCourseById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public String deleteCourse(int id) {
		 repo.deleteById(id);
		 return "Sucessfully deleted "+id;
	}
	public Course updateCourse(Course course) {
		Course currentCourse=repo.findById(course.getId()).orElse(null);
		currentCourse.setCourseName(course.getCourseName());
		currentCourse.setCourseDetails(course.getCourseDetails());
		currentCourse.setId(course.getId());
		currentCourse.setEnrolledUser(course.getEnrolledUser());
		
		
		return repo.save(currentCourse);
	}
}
