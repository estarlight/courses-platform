package com.esther.courseplatform.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.courseplatform.models.Course;
import com.esther.courseplatform.models.CourseStudent;
import com.esther.courseplatform.models.Student;

@Repository
public interface CSRepository extends CrudRepository<CourseStudent,Long>{
	
	List<CourseStudent> findAll();
	
	List<CourseStudent> findAllByCourse(Course course);
	List<CourseStudent> findAllByStudent(Student student);

}
