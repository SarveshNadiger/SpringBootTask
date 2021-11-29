package org.impelsys.PracticeBoot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Course {

	@Id
	//@GeneratedValue
	private Integer id;

	@NotBlank
	private String courseName;
	private String courseDetails;

	@ManyToMany
	@JoinTable(
			name="usr_crs",
			joinColumns=@JoinColumn(name="User_id"),
			inverseJoinColumns=@JoinColumn(name="Course_id")
			)
	private Set<User> enrolledUser = new HashSet<>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseDetails() {
		return courseDetails;
	}


	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}


	public Set<User> getEnrolledUser() {
		return enrolledUser;
	}


	public void setEnrolledUser(Set<User> enrolledUser) {
		this.enrolledUser = enrolledUser;
	}


	public Course(Integer id, @NotBlank String courseName, String courseDetails, Set<User> enrolledUser) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDetails = courseDetails;
		this.enrolledUser = enrolledUser;
	}


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void enrolledUser(User user) {
		// TODO Auto-generated method stub
		enrolledUser.add(user);
		
	}
	 

	

}
