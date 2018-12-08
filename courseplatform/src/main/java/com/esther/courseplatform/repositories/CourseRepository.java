package com.esther.courseplatform.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.courseplatform.models.Course;
import com.esther.courseplatform.models.CourseStudent;
import com.esther.courseplatform.models.Student;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
	
	List<Course> findAll();
	

//	
//	@Query("select t from #{#entityName} t where t.attribute = ?1")
//	  List<CourseStudent> findAllByCourseId(Long id);

}
