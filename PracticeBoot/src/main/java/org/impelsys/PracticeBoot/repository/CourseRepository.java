package org.impelsys.PracticeBoot.repository;

import org.impelsys.PracticeBoot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository 
public interface CourseRepository extends JpaRepository<Course,Integer> {

	//Course findByName(String name);

	

}
