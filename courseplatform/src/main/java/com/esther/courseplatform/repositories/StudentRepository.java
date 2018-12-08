package com.esther.courseplatform.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.courseplatform.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findAll();
	
	Student findByEmail(String email);
	
//	List<Student> findAllByCourses(Course courseName)
//	  @Query("select t from #{#entityName} t where t.attribute = ?1")
//	  List<T> findAllByAttribute(String attribute);
//	}
	
	long count();
}
