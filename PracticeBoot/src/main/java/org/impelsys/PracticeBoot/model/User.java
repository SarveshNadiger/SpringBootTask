package org.impelsys.PracticeBoot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")
public class User {
	
	@Id
	//@GeneratedValue
	private Integer id;
	
	@NotBlank
	private String name;
	
	@Email(message="Please provide valid email id")
	private String email;
	private String address;
	private int phno;
	
	@JsonIgnore
	@ManyToMany(mappedBy="enrolledUser")
	private Set<Course> courses = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public User(Integer id, @NotBlank String name, @Email(message = "Please provide valid email id") String email,
			String address, int phno, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phno = phno;
		this.courses = courses;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

	
	
	
	
	

}
