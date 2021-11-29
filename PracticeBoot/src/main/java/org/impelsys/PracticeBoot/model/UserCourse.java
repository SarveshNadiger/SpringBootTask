package org.impelsys.PracticeBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class UserCourse {
	@Id
	@GeneratedValue
	private Integer id;
	
	
	
	/*
	 * private User usr;
	 * 
	 * private Course crs;
	 */
	 
	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserCourse(Integer id) {
		super();
		this.id = id;
	}

	public UserCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 

}
