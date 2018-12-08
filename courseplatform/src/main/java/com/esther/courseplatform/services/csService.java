package com.esther.courseplatform.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.esther.courseplatform.models.Course;
import com.esther.courseplatform.models.CourseStudent;
import com.esther.courseplatform.models.Student;
import com.esther.courseplatform.repositories.CSRepository;



@Service
public class csService {

	private final CSRepository cSRepo;
	
	public csService(CSRepository cSRepo) {
		this.cSRepo = cSRepo;
	}
	
	public List<CourseStudent> allConnections(){
		return cSRepo.findAll();
	}
	
	public List<CourseStudent> connectionsByCourse(Course course) {
		return cSRepo.findAllByCourse(course);
	}
	
	public List<CourseStudent> connectionsByStudent(Student student) {
		return cSRepo.findAllByStudent(student);
	}
	
	public CourseStudent addConnection(CourseStudent cs) {
		return cSRepo.save(cs);
	}
}
